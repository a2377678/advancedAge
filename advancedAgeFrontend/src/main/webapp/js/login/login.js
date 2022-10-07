function getVerify() {
    // $("#imgCode").on("click", function() {
    $("#imgVerify").attr("src", 'getVerify?' + Math.random());//jquery方式
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
			if (result.split(";")[0]=='success') {
				if($('#type').val()=='AA'){
                	location.href='schedule?sid='+result.split(";")[1];
				}else if($('#type').val()=='AR'){
					location.href='schedule_pass?sid='+result.split(";")[1];
				}
            } else if(result=='password error'){
				alert("密碼錯誤");
			}else{
                alert("驗證失敗");
            }
        }
    });
}