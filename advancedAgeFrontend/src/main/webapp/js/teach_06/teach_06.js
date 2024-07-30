$(function(){
	$('input[name$="Proof"]').change(function(){
		let fileName=$(this)[0].files[0].name;
		if(fileName.indexOf('jpg')!=-1 || fileName.indexOf('png')!=-1 || fileName.indexOf('pdf')!=-1
		|| fileName.indexOf('doc')!=-1 || fileName.indexOf('docx')!=-1 || fileName.indexOf('odt')!=-1){
			if($(this)[0].files[0].size/1024/1024>5)
			{
				alert('檔案大小不得超過 5mb');
				$(this).val('');
			}
		}else if(fileName.indexOf('rar')!=-1 || fileName.indexOf('zip')!=-1 || fileName.indexOf('7z')!=-1){
			if($(this)[0].files[0].size/1024/1024>50)
			{
				alert('壓縮檔案大小不得超過 50mb');
				$(this).val('');
			}
		}
	});
})

function addRegisterProof(num){
	$('button[onclick^="addRegisterProof"]').hide();
	$('#register').append('<div class="full">'+
        '<label for="registerProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="registerProof'+(Number(num)+1)+'" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delRegisterProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addRegisterProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="registerProof'+(Number(num)+1)+'"]').change(function(){
		let fileName=$(this)[0].files[0].name;
		if(fileName.indexOf('jpg')!=-1 || fileName.indexOf('png')!=-1 || fileName.indexOf('pdf')!=-1
		|| fileName.indexOf('doc')!=-1 || fileName.indexOf('docx')!=-1 || fileName.indexOf('odt')!=-1){
			if($(this)[0].files[0].size/1024/1024>5)
			{
				alert('檔案大小不得超過 5mb');
				$(this).val('');
			}
		}else if(fileName.indexOf('rar')!=-1 || fileName.indexOf('zip')!=-1 || fileName.indexOf('7z')!=-1){
			if($(this)[0].files[0].size/1024/1024>50)
			{
				alert('壓縮檔案大小不得超過 50mb');
				$(this).val('');
			}
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

function addSpeakerRetirementProof(num){
	$('button[onclick^="addSpeakerRetirementProof"]').hide();
	$('#speakerRetirement').append('<div class="full"> '+
        '<label for="speakerRetirementProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="speakerRetirementProof'+(Number(num)+1)+'" name="speakerRetirementProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delSpeakerRetirementProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addSpeakerRetirementProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="speakerRetirementProof'+(Number(num)+1)+'"]').change(function(){
		let fileName=$(this)[0].files[0].name;
		if(fileName.indexOf('jpg')!=-1 || fileName.indexOf('png')!=-1 || fileName.indexOf('pdf')!=-1
		|| fileName.indexOf('doc')!=-1 || fileName.indexOf('docx')!=-1 || fileName.indexOf('odt')!=-1){
			if($(this)[0].files[0].size/1024/1024>5)
			{
				alert('檔案大小不得超過 5mb');
				$(this).val('');
			}
		}else if(fileName.indexOf('rar')!=-1 || fileName.indexOf('zip')!=-1 || fileName.indexOf('7z')!=-1){
			if($(this)[0].files[0].size/1024/1024>50)
			{
				alert('壓縮檔案大小不得超過 50mb');
				$(this).val('');
			}
		}
	});
}

function delSpeakerRetirementProof(num){
	if($('input[id="speakerRetirementProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="speakerRetirementProof'+num+'"]').parent().remove();
		$('input[id^="speakerRetirementProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="speakerRetirementProof'+num+'"]').parent().remove();
	}
}

function addSpeakerExperienceProof(num){
	$('button[onclick^="addSpeakerExperienceProof"]').hide();
	$('#speakerExperience').append('<div class="full"> '+
        '<label for="speakerExperienceProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="speakerExperienceProof'+(Number(num)+1)+'" name="speakerExperienceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delSpeakerExperienceProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addSpeakerExperienceProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="speakerExperienceProof'+(Number(num)+1)+'"]').change(function(){
		let fileName=$(this)[0].files[0].name;
		if(fileName.indexOf('jpg')!=-1 || fileName.indexOf('png')!=-1 || fileName.indexOf('pdf')!=-1
		|| fileName.indexOf('doc')!=-1 || fileName.indexOf('docx')!=-1 || fileName.indexOf('odt')!=-1){
			if($(this)[0].files[0].size/1024/1024>5)
			{
				alert('檔案大小不得超過 5mb');
				$(this).val('');
			}
		}else if(fileName.indexOf('rar')!=-1 || fileName.indexOf('zip')!=-1 || fileName.indexOf('7z')!=-1){
			if($(this)[0].files[0].size/1024/1024>50)
			{
				alert('壓縮檔案大小不得超過 50mb');
				$(this).val('');
			}
		}
	});
}

function delSpeakerExperienceProof(num){
	if($('input[id="speakerExperienceProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="speakerExperienceProof'+num+'"]').parent().remove();
		$('input[id^="speakerExperienceProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="speakerExperienceProof'+num+'"]').parent().remove();
	}
}

function addEmploymentProof(num){
	$('button[onclick^="addEmploymentProof"]').hide();
	$('#employment').append('<div class="full">'+
        '<label for="employmentProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="employmentProof'+(Number(num)+1)+'" name="employmentProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delEmploymentProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addEmploymentProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="employmentProof'+(Number(num)+1)+'"]').change(function(){
		let fileName=$(this)[0].files[0].name;
		if(fileName.indexOf('jpg')!=-1 || fileName.indexOf('png')!=-1 || fileName.indexOf('pdf')!=-1
		|| fileName.indexOf('doc')!=-1 || fileName.indexOf('docx')!=-1 || fileName.indexOf('odt')!=-1){
			if($(this)[0].files[0].size/1024/1024>5)
			{
				alert('檔案大小不得超過 5mb');
				$(this).val('');
			}
		}else if(fileName.indexOf('rar')!=-1 || fileName.indexOf('zip')!=-1 || fileName.indexOf('7z')!=-1){
			if($(this)[0].files[0].size/1024/1024>50)
			{
				alert('壓縮檔案大小不得超過 50mb');
				$(this).val('');
			}
		}
	});
}

function delEmploymentProof(num){
	if($('input[id="employmentProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="employmentProof'+num+'"]').parent().remove();
		$('input[id^="employmentProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="employmentProof'+num+'"]').parent().remove();
	}
}

function addNecessaryProof(num){
	$('button[onclick^="addNecessaryProof"]').hide();
	$('#necessary').append('<div class="full"> '+
        '<label for="necessaryProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="necessaryProof'+(Number(num)+1)+'" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delNecessaryProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addNecessaryProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="necessaryProof'+(Number(num)+1)+'"]').change(function(){
		let fileName=$(this)[0].files[0].name;
		if(fileName.indexOf('jpg')!=-1 || fileName.indexOf('png')!=-1 || fileName.indexOf('pdf')!=-1
		|| fileName.indexOf('doc')!=-1 || fileName.indexOf('docx')!=-1 || fileName.indexOf('odt')!=-1){
			if($(this)[0].files[0].size/1024/1024>5)
			{
				alert('檔案大小不得超過 5mb');
				$(this).val('');
			}
		}else if(fileName.indexOf('rar')!=-1 || fileName.indexOf('zip')!=-1 || fileName.indexOf('7z')!=-1){
			if($(this)[0].files[0].size/1024/1024>50)
			{
				alert('壓縮檔案大小不得超過 50mb');
				$(this).val('');
			}
		}
	});
}

function delNecessaryProof(num){
	if($('input[id="necessaryProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="necessaryProof'+num+'"]').parent().remove();
		$('input[id^="necessaryProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="necessaryProof'+num+'"]').parent().remove();
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

function fileUploadCheck(){
	let checkFile=1;
	if($('#register').find('span.file_name').text()!='' &&
		$('#speakerRetirement').find('span.file_name').text()!='' &&
		$('#speakerExperience').find('span.file_name').text()!='' &&
		$('#employment').find('span.file_name').text()!='' ){
			
	}else{
		checkFile=0;
	}
	if(checkFile==0)
	{
		alert('請確認檔案是否上傳');
	}
	else
	{
		location.href='teach_07';
	}
}

function upload(){
	if(fileCheck()){
		let registerFiles = new FormData();
		$('input[name^="registerProof"]').each(function(){
			registerFiles.append('registerFiles',$(this)[0].files[0]);
		});
		
		let speakerRetirementFiles = new FormData();
		$('input[name^="speakerRetirementProof"]').each(function(){
			speakerRetirementFiles.append('speakerRetirementFiles',$(this)[0].files[0]);
		});
		
		let speakerExperienceFiles = new FormData();
		$('input[name^="speakerExperienceProof"]').each(function(){
			speakerExperienceFiles.append('speakerExperienceFiles',$(this)[0].files[0]);
		});
		
		
		let employmentFiles = new FormData();
		$('input[name^="employmentProof"]').each(function(){
			employmentFiles.append('employmentFiles',$(this)[0].files[0]);
		});
		
		let necessaryFiles = new FormData();
		$('input[name^="necessaryProof"]').each(function(){
			necessaryFiles.append('necessaryFiles',$(this)[0].files[0]);
		});
		
		if(registerFiles.get('registerFiles') != 'undefined' || speakerRetirementFiles.get('speakerRetirementFiles') != 'undefined'  || speakerExperienceFiles.get('speakerExperienceFiles') != 'undefined' || employmentFiles.get('employmentFiles') != 'undefined' || necessaryFiles.get('necessaryFiles') != 'undefined' ){
			$('#loader-container').show();
			$.ajax({
			   	type: 'post',
				url: 'retirementAdvancedAgeExperienceInheritanceApplyRegisterFileUplolad',// 資料不需要編碼
				enctype: 'multipart/form-data',	   	
				contentType: false,// 資料物件不需要轉換成鍵值對格式
			   	processData: false,
				data: registerFiles,
				success: function(res) {
					if(res=='fail'){
						alert('請確認檔案格式');
						reloadPage();
					}else{
						$.ajax({
						   	type: 'post',
							url: 'retirementAdvancedAgeExperienceInheritanceApplySpeakerRetirementFileUplolad',// 資料不需要編碼
							enctype: 'multipart/form-data',	   	
							contentType: false,// 資料物件不需要轉換成鍵值對格式
						   	processData: false,
							data: speakerRetirementFiles,
							success: function(res) {
								if(res=='fail'){
									alert('請確認檔案格式');
									reloadPage();
								}else{
							   		$.ajax({
									   	type: 'post',
										url: 'retirementAdvancedAgeExperienceInheritanceApplySpeakerExperienceFileUplolad',// 資料不需要編碼
										enctype: 'multipart/form-data',	   	
										contentType: false,// 資料物件不需要轉換成鍵值對格式
									   	processData: false,
										data: speakerExperienceFiles,
										success: function(res) {
											if(res=='fail'){
												alert('請確認檔案格式');
												reloadPage();
											}else{
											   	$.ajax({
												   	type: 'post',
													url: 'retirementAdvancedAgeExperienceInheritanceApplyEmploymentFileUplolad',// 資料不需要編碼
													enctype: 'multipart/form-data',	   	
													contentType: false,// 資料物件不需要轉換成鍵值對格式
												   	processData: false,
													data: employmentFiles,
													success: function(res) {
														if(res=='fail'){
															alert('請確認檔案格式');
															reloadPage();
														}else{
														   	$.ajax({
															   	type: 'post',
																url: 'retirementAdvancedAgeExperienceInheritanceApplyNecessaryFileUplolad',// 資料不需要編碼
																enctype: 'multipart/form-data',	   	
																contentType: false,// 資料物件不需要轉換成鍵值對格式
															   	processData: false,
																data: necessaryFiles,
																success: function(res) {
																   	if(res=='fail'){
																		alert('請確認檔案格式');
																		reloadPage();
																	}else{
																		reloadPage();
																	}
																}
															});
														}
													}
												});
											}
										}
									});
								}
							}
						});
					}
				}
			});
			
		}else{
			alert('請選擇檔案');
		}
	}else{
		alert('格式有誤');
	}
	
}

function reloadPage(){
	window.location.reload();
}