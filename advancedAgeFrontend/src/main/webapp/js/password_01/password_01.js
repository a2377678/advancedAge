function apply(){
	$.ajax({
	    type: "POST",
	    url: 'editCompanyInfo',
	    data: {
			companyName : $('#companyName').val(),
	    	seq : $('#seq').val(),
			contactName : $('#contactName').val(),
			contactJobtitle : $('#contactJobtitle').val(),
			contactWorkPhoneAreaCode : $('#contactWorkPhoneAreaCode').val(),
			contactWorkPhone : $('#contactWorkPhone').val(),
			contactWorkPhoneExtension : $('#contactWorkPhoneExtension').val(),
			contactPhone : $('#contactPhone').val(),
			email : $('#email').val(),
			accountStatus : 3,
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			let registerFiles = new FormData();
			$('input[name^="registerProof"]').each(function(){
				registerFiles.append('registerFiles',$(this)[0].files[0]);
			});
			$.ajax({
			   	type: 'post',
				url: 'forgetCompanyInfoRegisterFileUplolad',// 資料不需要編碼
				enctype: 'multipart/form-data',	   	
				contentType: false,// 資料物件不需要轉換成鍵值對格式
			   	processData: false,
				data: registerFiles,
				success: function(res) {
			   	// 判斷是否接收成功
				   	location.href='password_02';
				}
			});
			
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}