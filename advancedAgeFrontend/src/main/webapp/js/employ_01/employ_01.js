function getVerify() {
    // $("#imgCode").on("click", function() {
    $("#imgVerify").attr("src", 'getVerify?' + Math.random());//jquery方式
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
//			alert(result);
            if (result.split(";")[0]=='success') {
                location.href='employ_02?sid='+result.split(";")[1];
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