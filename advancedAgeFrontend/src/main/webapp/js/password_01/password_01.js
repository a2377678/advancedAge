function addRegisterProof(num){
	$('button[onclick^="addRegisterProof"]').hide();
	$('#register').append('<div class="full">'+
        '<label for="registerProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="registerProof'+(Number(num)+1)+'" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button type="button" class="add" onclick="delRegisterProof('+(Number(num)+1)+')">－</button> '+
        '<button type="button" class="add" onclick="addRegisterProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="registerProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
		}
	});
}

function delRegisterProof(num){
	if($('input[id="registerProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="registerProof'+num+'"]').parent().remove();
		$('input[id^="registerProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="registerProof'+num+'"]').parent().remove();
	}
}

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
			registerFiles.append('companyInfoId',json);
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