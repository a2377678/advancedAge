function getVerify() {
    // $("#imgCode").on("click", function() {
    $("#imgVerify").attr("src", 'getVerify?' + (new Date()).getTime());//jquery方式
    // });

}

function aVerify(){
    $.ajax({
        type: 'post',
        url: 'checkVerify',
        dataType: "text",
        data: {
            verifyInput: $("#verifyInput").val(),
			seq : $('#seq').val(),
			password : $('#password').val()
        },
        success: function (result) {
			let result_spl=result.split(";");
			if (result_spl[0]=='success') {
				var redirectUrl = result_spl[1];
			    if (isValidRedirectUrl(redirectUrl)) {
			        location.href = encodeURIComponent(redirectUrl);
			    } else {
			        alert("無效的重定向 URL");
			    }
            } else if(result_spl=='password error'){
				alert("密碼錯誤");
			}else{
                alert("驗證失敗");
            }
        }
    });
}

function SSO(){
	if($('#SSOseq').val()!='' && $('#SSOseq').val().length==8){
		$.ajax({
	        type: 'get',
	        url: 'genLoginUrl',
	        dataType: "text",
			data: {
				seq : $('#SSOseq').val()
	        },
	        success: function (result) {
	        	if (isValidRedirectUrl(result)) {
		            location.href = result;
		        } else {
		            alert('無效的重定向 URL');
		        }
	        }
	    });
	}else{
		alert('請輸入8碼統編');
	}
}

function isValidRedirectUrl(url) {
  	var pattern = /^[a-zA-Z]+_\d+$/;
  	var pattern2 = /^[a-zA-Z]+$/;
	var pattern3 = /^[a-zA-Z]+_[a-zA-Z]+$/;
	var pattern4 = /^http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
  	return pattern.test(url) || pattern2.test(url) || pattern3.test(url) || pattern4.test(url);
}