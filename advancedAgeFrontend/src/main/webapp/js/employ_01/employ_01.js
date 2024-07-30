function getVerify() {
	
    // $("#imgCode").on("click", function() {
    $("#imgVerify").attr("src", 'getVerify?' + (new Date()).getTime());//jquery方式
    // });
}

function aVerify(){
    // alert(value);
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
            if (result=='success') {
                location.href='employ_02';
            } else if(result=='password error'){
				alert("密碼錯誤");
			}else{
                alert("驗證失敗");
            }
            // window.location.reload();
//            getVerify();
        }
    });
}