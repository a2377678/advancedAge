var postTarget;
var timeoutId;
function postData(target,data)
{
	if(!http.sendRequest)
	{
		return null;
	}
	http.url=target;
	http.actionMethod="POST";
	var code=http.sendRequest(data);
	if(code!=0) return null;
	return http.responseText;

}
function checkFinish(){
	if(postTarget){
		postTarget.close();
		alert("尚未安裝元件");
	}
}
function makeSignature()
{
	if($('#pin').val().length==0)
	{
		alert('請輸入PIN碼');
		return;
	}
    var ua = window.navigator.userAgent;
	if(ua.indexOf("MSIE")!=-1 || ua.indexOf("Trident")!=-1) //is IE, use ActiveX
	{
		postTarget=window.open("waiting.htm?簽章中", "Signing","height=200, width=200, left=100, top=20");
		var tbsPackage=getTbsPackage();
		document.getElementById("httpObject").innerHTML='<OBJECT id="http" width=1 height=1 style="LEFT: 1px; TOP: 1px" type="application/x-httpcomponent" VIEWASTEXT></OBJECT>';
		var data=postData("http://localhost:61161/sign","tbsPackage="+tbsPackage);
		postTarget.close();
		postTarget=null;
		if(!data) alert('尚未安裝元件');
		else setSignature(data);
	}
	else{
		postTarget=window.open("http://localhost:61161/popupForm", "簽章中","height=200, width=200, left=100, top=20");
		timeoutId=setTimeout(checkFinish,3500);
	}
}

function getTbsPackage(){
	var tbsData = {};
	tbsData["tbs"]=encodeURIComponent(document.getElementById("tbs").value);
	tbsData["tbsEncoding"]=document.getElementById("tbsEncoding").value;
	tbsData["hashAlgorithm"]=document.getElementById("hashAlgorithm").value;
	tbsData["withCardSN"]=document.getElementById("withCardSN").value;
	tbsData["pin"]=encodeURIComponent(document.getElementById("pin").value);
	tbsData["nonce"]=document.getElementById("nonce").value;
	tbsData["func"]="MakeSignature";
	tbsData["signatureType"]="PKCS7";
	var json = JSON.stringify(tbsData);
	return json;
}
function setSignature(signature)
{
	var ret=JSON.parse(signature);
	document.getElementById("ResultSignedData").value=ret.signature;
	document.getElementById("returnCode").value=ret.ret_code;
	if(ret.ret_code!=0){
		alert(MajorErrorReason(ret.ret_code));
		if(ret.last_error)
			alert(MinorErrorReason(ret.last_error));
	}
	else{
		getData();
	}
}

function receiveMessage(event)
{
	if(console) console.debug(event);
	//安全起見，這邊應填入網站位址檢查
	if(event.origin!="http://localhost:61161")
		return;
	try{
		var ret = JSON.parse(event.data);
		if(ret.func){
			if(ret.func=="getTbs"){
				clearTimeout(timeoutId);
				var json=getTbsPackage()
				postTarget.postMessage(json,"*");
			}else if(ret.func=="sign"){
				setSignature(event.data);
			}
		}else{
			if(console) console.error("no func");
		}
	}catch(e){
		//errorhandle
		if(console) console.error(e);
	}
}

function getData(){
	$.ajax({  
        type: "POST",  
        url: 'employCheckCA',   
        dataType: "text",
        data: {
            base64: $('#ResultSignedData').val()
        },
        success: function(result){ 
			let result_spl=result.split(";");
			if(result_spl[0]=='success'){
				var redirectUrl = result_spl[1];
	            if (isValidRedirectUrl(redirectUrl)) {
	                location.href = encodeURIComponent(redirectUrl);
	            } else {
	                alert("無效的重定向 URL");
	            }
			}else{
				alert('讀卡失敗');
			}
        }  
   });
}

function isValidRedirectUrl(url) {
  	var pattern = /^[a-zA-Z]+_\d+$/;
  	var pattern2 = /^[a-zA-Z]+$/;
	var pattern3 = /^[a-zA-Z]+_[a-zA-Z]+$/;
	var pattern4 = /^http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
  	return pattern.test(url) || pattern2.test(url) || pattern3.test(url) || pattern4.test(url);
}

if (window.addEventListener) {
	window.addEventListener("message", receiveMessage, false);
	}else {
	//for IE8
		window.attachEvent("onmessage", receiveMessage);
	}
	//for IE8
var console=console||{"log":function(){}, "debug":function(){}, "error":function(){}};