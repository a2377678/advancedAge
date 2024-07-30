function aVerify(){
	if($('#form').valid()){
	    $.ajax({
	        type: 'post',
	        url: 'career_payment_01',
	        dataType: "text",
	        success: function (result) {
				let result_spl=result.split(";");
				if (result_spl[0]=='success') {
					var redirectUrl = result_spl[1];
				    if (isValidRedirectUrl(redirectUrl)) {
				        location.href = encodeURIComponent(redirectUrl);
				    } else {
				        alert("無效的重定向 URL");
				    }
	            } else if(result_spl[0]=='no base'){
					alert("案件未送出申請");
				}else if(result_spl[0]=='audit'){
					alert("案件審核中");
				}else if(result_spl[0]=='failed'){
					alert("案件不合格");
				}else if(result_spl[0]=='approved'){
					alert("案件待核定");
				}else if(result_spl[0]=='password error'){
					alert("尚未申請帳號/密碼錯誤");
				}
				else{
	                alert("驗證失敗");
	            }
	        }
	    });
	}
}

function isValidRedirectUrl(url) {
  	var pattern = /^[a-zA-Z]+_[a-zA-Z]+_\d+$/;
  	var pattern2 = /^[a-zA-Z]+$/;
	var pattern3 = /^[a-zA-Z]+_[a-zA-Z]+$/;
	var pattern4 = /^http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
  	return pattern.test(url) || pattern2.test(url) || pattern3.test(url) || pattern4.test(url);
}