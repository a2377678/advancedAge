function getVerify() {
    // $("#imgCode").on("click", function() {
    $("#imgVerify").attr("src", 'getVerify?' + (new Date()).getTime());//jquery方式
    // });
}

function aVerify(){
    // alert(value);
    $.ajax({
        type: 'post',
        url: 'paymentCheckVerify',
        dataType: "text",
        data: {
            verifyInput: $("#verifyInput").val(),
			seq : $('#seq').val(),
			password : $('#password').val()
        },
        success: function (result) {
            if (result=='success') {
                location.href='employ_payment_02';
            } else if(result=='no base'){
				alert("案件未送出申請");
			}else if(result=='audit'){
				alert("案件審核中");
			}else if(result=='failed'){
				alert("案件不合格");
			}else if(result=='approved'){
				alert("案件待核定");
			}else if(result=='password error'){
				alert("尚未申請帳號/密碼錯誤");
			}
			else{
                alert("驗證失敗");
            }
            // window.location.reload();
//            getVerify();
        }
    });
}