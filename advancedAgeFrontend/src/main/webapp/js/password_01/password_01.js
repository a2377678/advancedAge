function addRegisterProof(num){
	$('button[onclick^="addRegisterProof"]').hide();
	$('#register').append('<div class="full">'+
        '<label for="registerProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="registerProof'+(Number(num)+1)+'" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
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

function fileCheck(){
	let check=1;
	$('input[name$="Proof"]').each(function(){
		if($(this).val()!=''){
			if($(this).val().indexOf('.rar')!=-1 || $(this).val().indexOf('.7z')!=-1 || $(this).val().indexOf('.zip')!=-1 || $(this).val().indexOf('.png')!=-1 || $(this).val().indexOf('.jpg')!=-1 || $(this).val().indexOf('.pdf')!=-1 || $(this).val().indexOf('.docx')!=-1 || $(this).val().indexOf('.doc')!=-1 || $(this).val().indexOf('.odt')!=-1){
			}
			else
			{
				check=0;
			}
		}else
		{
			check=0;
		}
	})
	if(check==0)
	{
		return false;
	}
	else
	{
		return true;
	}
}

function apply(){
	if($('#createForm').valid())
	{
		if(fileCheck()){
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
					email : $('#email').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					if(json!='fail'){
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
								if(res=='success')
								{
							   		location.href='password_02';
								}else{
									alert('請確認檔案格式');
								}
							}
						});
					}else{
						alert('填寫資料有誤');
					}
			    },
			    error: function(json){
				    alert('填寫資料有誤');
			    }
		    });
		}else{
			alert('請上傳檔案');
		}
	}
}