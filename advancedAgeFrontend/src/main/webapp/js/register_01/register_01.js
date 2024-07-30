$(function(){
	$('#registerCity').change(function(){
		if($('#checkbox').prop('checked')){
			$('#contactCity').val($(this).val());
			$('#registerArea').html('<option value="null">請選擇</option>');
			$('#contactArea').html('<option value="null">請選擇</option>');
			if($('#registerCity').val()!='')
			{
				$.ajax({
				    type: "POST",
				    url: 'getAreaList',
				    data: {
				    	cityCode : $('#registerCity').val()
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						let areaSplit=json.split(";");
						for(let a=0;a<areaSplit.length;a++)
						{
							let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
	                    	let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
							$('#registerArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
							$('#contactArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//							$('#registerArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
//							$('#contactArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
						}
				    },
				    error: function(json){
//					    alert(json);
				    }
			    });
			}
			
		}else{
			$('#registerArea').html('<option value="null">請選擇</option>');
			if($('#registerCity').val()!='')
			{
				$.ajax({
				    type: "POST",
				    url: 'getAreaList',
				    data: {
				    	cityCode : $('#registerCity').val()
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						let areaSplit=json.split(";");
						for(let a=0;a<areaSplit.length;a++)
						{
							let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
	                    	let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
							$('#registerArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//							$('#registerArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
						}
				    },
				    error: function(json){
					    alert(json);
				    }
			    });
			}
		}
	});
	
	$('#registerArea').change(function(){
		if($('#checkbox').prop('checked')){
			$('#contactArea').val($('#registerArea').val());
		}
	});
	$('#registerAddress').change(function(){
		if($('#checkbox').prop('checked')){
			$('#contactAddress').val($('#registerAddress').val());
		}
	});
	
	$('#contactCity').change(function(){
		$('#contactArea').html('<option value="null">請選擇</option>');
		if($('#contactCity').val()!='')
		{
			$.ajax({
			    type: "POST",
			    url: 'getAreaList',
			    data: {
			    	cityCode : $('#contactCity').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					let areaSplit=json.split(";");
					for(let a=0;a<areaSplit.length;a++)
					{
						let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
                    	let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
						$('#contactArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
					}
			    },
			    error: function(json){
				    alert(json);
			    }
		    });
		}
	});
	
	$('#checkbox').click(function(){
		if($('#checkbox').prop('checked')){
			$('#contactCity').val($('#registerCity').val());
			$('#contactArea').html('<option value="null">請選擇</option>');
			if($('#contactCity').val()!='')
			{
				$.ajax({
				    type: "POST",
				    url: 'getAreaList',
				    data: {
				    	cityCode : $('#contactCity').val()
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						let areaSplit=json.split(";");
						for(let a=0;a<areaSplit.length;a++)
						{
							let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
                    		let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
							$('#contactArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//							$('#contactArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
						}
						$('#contactArea').val($('#registerArea').val());
				    },
				    error: function(json){
					    alert(json);
				    }
			    });
			}
			$('#contactAddress').val($('#registerAddress').val());
		}
	})
	
})

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

function addAuthorizeProof(num){
	$('button[onclick^="addAuthorizeProof"]').hide();
	$('#authorize').append('<div class="full">'+
        '<label for="authorizeProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="authorizeProof'+(Number(num)+1)+'" name="authorizeProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button type="button" class="add" onclick="delAuthorizeProof('+(Number(num)+1)+')">－</button> '+
        '<button type="button" class="add" onclick="addAuthorizeProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="authorizeProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
		}
	});
}

function delAuthorizeProof(num){
	if($('input[id="authorizeProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="authorizeProof'+num+'"]').parent().remove();
		$('input[id^="authorizeProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="authorizeProof'+num+'"]').parent().remove();
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
function enroll(){
	if($('#createForm').valid())
	{
		if(fileCheck()){
			let registerFiles = new FormData();
			$('input[name^="registerProof"]').each(function(){
				registerFiles.append('registerFiles',$(this)[0].files[0]);
			});
			
			let authorizeFiles = new FormData();
			$('input[name^="authorizeProof"]').each(function(){
				authorizeFiles.append('authorizeFiles',$(this)[0].files[0]);
			});
			
			$.ajax({
			    type: "POST",
			    url: 'addCompanyInfo',
			    data: {
					companyName : $('#companyName').val(),
			    	seq : $('#seq').val(),
					principal : $('#principal').val(),
					industry : $('#industry').val(),
					registerCity : $('#registerCity').val(), 
					registerArea : $('#registerArea').val(),
					registerAddress : $('#registerAddress').val(),
					contactCity : $('#contactCity').val(), 
					contactArea : $('#contactArea').val(),
					contactAddress : $('#contactAddress').val(),
					contactName : $('#contactName').val(),
					contactJobtitle : $('#contactJobtitle').val(),
					contactWorkPhoneAreaCode : $('#contactWorkPhoneAreaCode').val(),
					contactWorkPhone : $('#contactWorkPhone').val(),
					contactWorkPhoneExtension : $('#contactWorkPhoneExtension').val(),
					contactPhone : $('#contactPhone').val(),
					faxAreaCode : $('#faxAreaCode').val(),
					fax : $('#fax').val(),
					email : $('#email').val(),
					accountStatus : 2,
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					if(json=='fail'){
						alert('統一編號已註冊');
					}else{
						registerFiles.append('companyInfoId',json);
						authorizeFiles.append('companyInfoId',json);
						$.ajax({
						   	type: 'post',
							url: 'companyInfoRegisterFileUplolad',// 資料不需要編碼
							enctype: 'multipart/form-data',	   	
							contentType: false,// 資料物件不需要轉換成鍵值對格式
						   	processData: false,
							data: registerFiles,
							success: function(res) {
								if(res=='fail'){
									alert('請確認檔案格式');
								}else{
									$.ajax({
									   	type: 'post',
										url: 'companyInfoAuFileUplolad',// 資料不需要編碼
										enctype: 'multipart/form-data',	   	
										contentType: false,// 資料物件不需要轉換成鍵值對格式
									   	processData: false,
										data: authorizeFiles,
										success: function(res) {
											if(res=='fail'){
												alert('請確認檔案格式');
											}else{
										   		location.href='register_02';
											}
										}
									});
								}
								
							}
						});
					}
			    },
			    error: function(json){
				    alert(json);
			    }
		    });
		}else{
			alert('請上傳正確格式檔案');
		}
	}
}
