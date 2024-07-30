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

function addInsureProof(num){
	$('button[onclick^="addInsureProof"]').hide();
	$('#insure').append('<div class="full"> '+
        '<label for="insureProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="insureProof'+(Number(num)+1)+'" name="insureProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delInsureProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addInsureProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="insureProof'+(Number(num)+1)+'"]').change(function(){
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

function delInsureProof(num){
	if($('input[id="insureProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="insureProof'+num+'"]').parent().remove();
		$('input[id^="insureProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="insureProof'+num+'"]').parent().remove();
	}
}

function addSalaryProof(num){
	$('button[onclick^="addSalaryProof"]').hide();
	$('#salary').append('<div class="full"> '+
        '<label for="salaryProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="salaryProof'+(Number(num)+1)+'" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delSalaryProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addSalaryProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="salaryProof'+(Number(num)+1)+'"]').change(function(){
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

function delSalaryProof(num){
	if($('input[id="salaryProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="salaryProof'+num+'"]').parent().remove();
		$('input[id^="salaryProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="salaryProof'+num+'"]').parent().remove();
	}
}

function addAttendanceProof(num){
	$('button[onclick^="addAttendanceProof"]').hide();
	$('#attendance').append('<div class="full"> '+
        '<label for="attendanceProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="attendanceProof'+(Number(num)+1)+'" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> '+
        '<button class="add" onclick="delAttendanceProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addAttendanceProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="attendanceProof'+(Number(num)+1)+'"]').change(function(){
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

function delAttendanceProof(num){
	if($('input[id="attendanceProof'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="attendanceProof'+num+'"]').parent().remove();
		$('input[id^="attendanceProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="attendanceProof'+num+'"]').parent().remove();
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

//function registerFilesUpload(){
//	let registerFiles = new FormData();
//	$('input[name^="registerProof"]').each(function(){
//		registerFiles.append('registerFiles',$(this)[0].files[0]);
//	});
//	$.ajax({
//	   	type: 'post',
//		url: 'advancedAgeApplyRegisterFileUplolad',// 資料不需要編碼
//		enctype: 'multipart/form-data',	   	
//		contentType: false,// 資料物件不需要轉換成鍵值對格式
//	   	processData: false,
//		data: registerFiles,
//		beforeSend: function() {
//	   		$('#loading').show()
//	   	},
//		complete: function() {
//	   		$('#loading').hide()
//	   	},
//		success: function(res) {
//	   	// 判斷是否接收成功
//		   	
//		}
//	});
//}
//function insureFilesUpload(){
//	let insureFiles = new FormData();
//	$('input[name^="insureProof"]').each(function(){
//		insureFiles.append('insureFiles',$(this)[0].files[0]);
//	});
//	$.ajax({
//	   	type: 'post',
//		url: 'advancedAgeApplyInsureFileUplolad',// 資料不需要編碼
//		enctype: 'multipart/form-data',	   	
//		contentType: false,// 資料物件不需要轉換成鍵值對格式
//	   	processData: false,
//		data: insureFiles,
//		beforeSend: function() {
//	   		$('#loading').show()
//	   	},
//		complete: function() {
//	   		$('#loading').hide()
//	   	},
//		success: function(res) {
//	   	// 判斷是否接收成功
//		   	
//		}
//	});
//}
//function salaryFilesUpload(){
//	let salaryFiles = new FormData();
//	$('input[name^="salaryProof"]').each(function(){
//		salaryFiles.append('salaryFiles',$(this)[0].files[0]);
//	});
//	$.ajax({
//	   	type: 'post',
//		url: 'advancedAgeApplySalaryFileUplolad',// 資料不需要編碼
//		enctype: 'multipart/form-data',	   	
//		contentType: false,// 資料物件不需要轉換成鍵值對格式
//	   	processData: false,
//		data: salaryFiles,
//		beforeSend: function() {
//	   		$('#loading').show()
//	   	},
//		complete: function() {
//	   		$('#loading').hide()
//	   	},
//		success: function(res) {
//	   	// 判斷是否接收成功
//		   	
//		}
//	});
//}
//function attendanceFilesUpload(){
//	let attendanceFiles = new FormData();
//	$('input[name^="attendanceProof"]').each(function(){
//		attendanceFiles.append('salaryFiles',$(this)[0].files[0]);
//	});
//	$.ajax({
//	   	type: 'post',
//		url: 'advancedAgeApplyAttendanceFileUplolad',// 資料不需要編碼
//		enctype: 'multipart/form-data',	   	
//		contentType: false,// 資料物件不需要轉換成鍵值對格式
//	   	processData: false,
//		data: salaryFiles,
//		beforeSend: function() {
//	   		$('#loading').show()
//	   	},
//		complete: function() {
//	   		$('#loading').hide()
//	   	},
//		success: function(res) {
//	   	// 判斷是否接收成功
//		   	
//		}
//	});
//}
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
		$('#insure').find('span.file_name').text()!='' &&
		$('#salary').find('span.file_name').text()!='' &&
		$('#attendance').find('span.file_name').text()!='' ){
			
	}else{
		checkFile=0;
	}
	if(checkFile==0)
	{
		alert('請確認檔案是否上傳');
	}
	else
	{
		location.href='employ_05';
	}
}

function upload(){
	if(fileCheck()){
		let registerFiles = new FormData();
		$('input[name^="registerProof"]').each(function(){
			registerFiles.append('registerFiles',$(this)[0].files[0]);
		});
		
		let insureFiles = new FormData();
		$('input[name^="insureProof"]').each(function(){
			insureFiles.append('insureFiles',$(this)[0].files[0]);
		});
		
		let salaryFiles = new FormData();
		$('input[name^="salaryProof"]').each(function(){
			salaryFiles.append('salaryFiles',$(this)[0].files[0]);
		});
		
		let attendanceFiles = new FormData();
		$('input[name^="attendanceProof"]').each(function(){
			attendanceFiles.append('attendanceFiles',$(this)[0].files[0]);
		});
		
		let necessaryFiles = new FormData();
		$('input[name^="necessaryProof"]').each(function(){
			necessaryFiles.append('necessaryFiles',$(this)[0].files[0]);
		});
		
		if(registerFiles.get('registerFiles') != 'undefined' || insureFiles.get('insureFiles') != 'undefined'  || salaryFiles.get('salaryFiles') != 'undefined' || attendanceFiles.get('attendanceFiles') != 'undefined' || necessaryFiles.get('necessaryFiles') != 'undefined' ){
			$('#loader-container').show();
			$.ajax({
			   	type: 'post',
				url: 'advancedAgeApplyRegisterFileUplolad',// 資料不需要編碼
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
							url: 'advancedAgeApplyInsureFileUplolad',// 資料不需要編碼
							enctype: 'multipart/form-data',	   	
							contentType: false,// 資料物件不需要轉換成鍵值對格式
						   	processData: false,
							data: insureFiles,
							success: function(res) {
								if(res=='fail'){
									alert('請確認檔案格式');
									reloadPage();
								}else{
							   		$.ajax({
									   	type: 'post',
										url: 'advancedAgeApplySalaryFileUplolad',// 資料不需要編碼
										enctype: 'multipart/form-data',	   	
										contentType: false,// 資料物件不需要轉換成鍵值對格式
									   	processData: false,
										data: salaryFiles,
										success: function(res) {
											if(res=='fail'){
												alert('請確認檔案格式');
												reloadPage();
											}else{
											   	$.ajax({
												   	type: 'post',
													url: 'advancedAgeApplyAttendanceFileUplolad',// 資料不需要編碼
													enctype: 'multipart/form-data',	   	
													contentType: false,// 資料物件不需要轉換成鍵值對格式
												   	processData: false,
													data: attendanceFiles,
													success: function(res) {
														if(res=='fail'){
															alert('請確認檔案格式');
															reloadPage();
														}else{
														   	$.ajax({
															   	type: 'post',
																url: 'advancedAgeApplyNecessaryFileUplolad',// 資料不需要編碼
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
			
//		setTimeout(function(){window.location.reload();}, 1000);
			    
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
