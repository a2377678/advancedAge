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

function addApprovedProof(num){
	$('button[onclick^="addApprovedProof"]').hide();
	$('#approved').append('<div class="full">'+
        '<label for="approvedProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="approvedProof'+(Number(num)+1)+'" name="approvedProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delApprovedProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addApprovedProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="approvedProof'+(Number(num)+1)+'"]').change(function(){
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

function delApprovedProof(num){
	if($('input[id="approvedProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="approvedProof'+num+'"]').parent().remove();
		$('input[id^="approvedProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="approvedProof'+num+'"]').parent().remove();
	}
}

function addReceiptProof(num){
	$('button[onclick^="addReceiptProof"]').hide();
	$('#receipt').append('<div class="full">'+
        '<label for="receiptProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="receiptProof'+(Number(num)+1)+'" name="receiptProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delReceiptProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addReceiptProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="receiptProof'+(Number(num)+1)+'"]').change(function(){
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

function delReceiptProof(num){
	if($('input[id="receiptProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="receiptProof'+num+'"]').parent().remove();
		$('input[id^="receiptProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="receiptProof'+num+'"]').parent().remove();
	}
}

function addResultProof(num){
	$('button[onclick^="addResultProof"]').hide();
	$('#result').append('<div class="full">'+
        '<label for="resultProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="resultProof'+(Number(num)+1)+'" name="resultProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delResultProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addResultProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="resultProof'+(Number(num)+1)+'"]').change(function(){
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

function delResultProof(num){
	if($('input[id="resultProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="resultProof'+num+'"]').parent().remove();
		$('input[id^="resultProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="resultProof'+num+'"]').parent().remove();
	}
}

function addExpenditureProof(num){
	$('button[onclick^="addExpenditureProof"]').hide();
	$('#expenditure').append('<div class="full">'+
        '<label for="expenditureProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="expenditureProof'+(Number(num)+1)+'" name="expenditureProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delExpenditureProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addExpenditureProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="expenditureProof'+(Number(num)+1)+'"]').change(function(){
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

function delExpenditureProof(num){
	if($('input[id="expenditureProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="expenditureProof'+num+'"]').parent().remove();
		$('input[id^="expenditureProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="expenditureProof'+num+'"]').parent().remove();
	}
}

function addSpeakerFeeProof(num){
	$('button[onclick^="addSpeakerFeeProof"]').hide();
	$('#speakerFee').append('<div class="full">'+
        '<label for="speakerFeeProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="speakerFeeProof'+(Number(num)+1)+'" name="speakerFeeProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delSpeakerFeeProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addSpeakerFeeProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="speakerFeeProof'+(Number(num)+1)+'"]').change(function(){
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

function delSpeakerFeeProof(num){
	if($('input[id="speakerFeeProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="speakerFeeProof'+num+'"]').parent().remove();
		$('input[id^="speakerFeeProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="speakerFeeProof'+num+'"]').parent().remove();
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
	if($('#approved').find('span.file_name').text()!='' &&
		$('#receipt').find('span.file_name').text()!='' &&
		$('#result').find('span.file_name').text()!='' &&
		$('#expenditure').find('span.file_name').text()!='' &&
		$('#speakerFee').find('span.file_name').text()!='' ){
			
	}else{
		checkFile=0;
	}
	if(checkFile==0)
	{
		alert('請確認檔案是否上傳');
	}
	else
	{
		location.href='teach_payment_04';
	}
}

function upload(){
	if(fileCheck()){
		let approvedFiles = new FormData();
		$('input[name^="approvedProof"]').each(function(){
			approvedFiles.append('approvedFiles',$(this)[0].files[0]);
		});
		approvedFiles.append('baseId',$('#baseId').val());
		
		let receiptFiles = new FormData();
		$('input[name^="receiptProof"]').each(function(){
			receiptFiles.append('receiptFiles',$(this)[0].files[0]);
		});
		receiptFiles.append('baseId',$('#baseId').val());
		
		let resultFiles = new FormData();
		$('input[name^="resultProof"]').each(function(){
			resultFiles.append('resultFiles',$(this)[0].files[0]);
		});
		resultFiles.append('baseId',$('#baseId').val());
		
		let expenditureFiles = new FormData();
		$('input[name^="expenditureProof"]').each(function(){
			expenditureFiles.append('expenditureFiles',$(this)[0].files[0]);
		});
		expenditureFiles.append('baseId',$('#baseId').val());
		
		let speakerFeeFiles = new FormData();
		$('input[name^="speakerFeeProof"]').each(function(){
			speakerFeeFiles.append('speakerFeeFiles',$(this)[0].files[0]);
		});
		speakerFeeFiles.append('baseId',$('#baseId').val());
		
		let necessaryFiles = new FormData();
		$('input[name^="necessaryProof"]').each(function(){
			necessaryFiles.append('necessaryFiles',$(this)[0].files[0]);
		});
		necessaryFiles.append('baseId',$('#baseId').val());
		
		if(approvedFiles.get('approvedFiles') != 'undefined' || receiptFiles.get('receiptFiles') != 'undefined' || resultFiles.get('resultFiles') != 'undefined'  || expenditureFiles.get('expenditureFiles') != 'undefined' || speakerFeeFiles.get('speakerFeeFiles') != 'undefined' || necessaryFiles.get('necessaryFiles') != 'undefined' ){
			$('#loader-container').show();
			$.ajax({
			   	type: 'post',
				url: 'retirementAdvancedAgeExperienceInheritanceApprovedFileUplolad',// 資料不需要編碼
				enctype: 'multipart/form-data',	   	
				contentType: false,// 資料物件不需要轉換成鍵值對格式
			   	processData: false,
				data: approvedFiles,
				success: function(res) {
					if(res=='fail'){
						alert('請確認檔案格式');
						reloadPage();
					}else{
						$.ajax({
						   	type: 'post',
							url: 'retirementAdvancedAgeExperienceInheritanceReceiptFileUplolad',// 資料不需要編碼
							enctype: 'multipart/form-data',	   	
							contentType: false,// 資料物件不需要轉換成鍵值對格式
						   	processData: false,
							data: receiptFiles,
							success: function(res) {
								if(res=='fail'){
									alert('請確認檔案格式');
									reloadPage();
								}else{
									$.ajax({
									   	type: 'post',
										url: 'retirementAdvancedAgeExperienceInheritanceResultFileUplolad',// 資料不需要編碼
										enctype: 'multipart/form-data',	   	
										contentType: false,// 資料物件不需要轉換成鍵值對格式
									   	processData: false,
										data: resultFiles,
										success: function(res) {
											if(res=='fail'){
												alert('請確認檔案格式');
												reloadPage();
											}else{
												$.ajax({
												   	type: 'post',
													url: 'retirementAdvancedAgeExperienceInheritanceExpenditureFileUplolad',// 資料不需要編碼
													enctype: 'multipart/form-data',	   	
													contentType: false,// 資料物件不需要轉換成鍵值對格式
												   	processData: false,
													data: expenditureFiles,
													success: function(res) {
														if(res=='fail'){
															alert('請確認檔案格式');
															reloadPage();
														}else{
															$.ajax({
															   	type: 'post',
																url: 'retirementAdvancedAgeExperienceInheritanceSpeakerFeeFileUplolad',// 資料不需要編碼
																enctype: 'multipart/form-data',	   	
																contentType: false,// 資料物件不需要轉換成鍵值對格式
															   	processData: false,
																data: speakerFeeFiles,
																success: function(res) {
																	if(res=='fail'){
																		alert('請確認檔案格式');
																		reloadPage();
																	}else{
																		$.ajax({
																		   	type: 'post',
																			url: 'retirementAdvancedAgeExperienceInheritanceNecessaryFileUplolad',// 資料不需要編碼
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
