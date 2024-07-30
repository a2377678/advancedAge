$(function() {
	$('input[name$="Proof"]').change(function() {
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

function addRegisterProof(num) {
	$('button[onclick^="addRegisterProof"]').hide();
	$('#register').append('<div class="full">' +
		'<label for="registerProof' + (Number(num) + 1) + '">文件(' + (Number(num) + 1) + ')</label> ' +
		'<input type="file" id="registerProof' + (Number(num) + 1) + '" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> ' +
		'<button class="add" onclick="delRegisterProof(' + (Number(num) + 1) + ')">－</button> ' +
		'<button class="add" onclick="addRegisterProof(' + (Number(num) + 1) + ')" style>＋</button> ' +
		'</div>')
	$('input[id="registerProof' + (Number(num) + 1) + '"]').change(function() {
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

function delRegisterProof(num) {
	if ($('input[id="registerProof' + num + '"]').parent().find('button[onclick^="add"]').attr('style') == '') {
		$('input[id="registerProof' + num + '"]').parent().remove();
		$('input[id^="registerProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else {
		$('input[id="registerProof' + num + '"]').parent().remove();
	}

}

function addJointAuthorizeProof(num) {
	$('button[onclick^="addJointAuthorizeProof"]').hide();
	$('#jointAuthorize').append('<div class="full">' +
		'<label for="jointAuthorizeProof' + (Number(num) + 1) + '">文件(' + (Number(num) + 1) + ')</label> ' +
		'<input type="file" id="jointAuthorizeProof' + (Number(num) + 1) + '" name="jointAuthorizeProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> ' +
		'<button class="add" onclick="delJointAuthorizeProof(' + (Number(num) + 1) + ')">－</button> ' +
		'<button class="add" onclick="addJointAuthorizeProof(' + (Number(num) + 1) + ')" style>＋</button> ' +
		'</div>')
	$('input[id="jointAuthorizeProof' + (Number(num) + 1) + '"]').change(function() {
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

function delJointAuthorizeProof(num) {
	if ($('input[id="jointAuthorizeProof' + num + '"]').parent().find('button[onclick^="add"]').attr('style') == '') {
		$('input[id="jointAuthorizeProof' + num + '"]').parent().remove();
		$('input[id^="jointAuthorizeProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else {
		$('input[id="jointAuthorizeProof' + num + '"]').parent().remove();
	}

}

function addNecessaryProof(num) {
	$('button[onclick^="addNecessaryProof"]').hide();
	$('#necessary').append('<div class="full"> ' +
		'<label for="necessaryProof' + (Number(num) + 1) + '">文件(' + (Number(num) + 1) + ')</label> ' +
		'<input type="file" id="necessaryProof' + (Number(num) + 1) + '" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt"> ' +
		'<button class="add" onclick="delNecessaryProof(' + (Number(num) + 1) + ')">－</button> ' +
		'<button class="add" onclick="addNecessaryProof(' + (Number(num) + 1) + ')" style>＋</button> ' +
		'</div>');
	$('input[id="NecessaryProof' + (Number(num) + 1) + '"]').change(function() {
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

function delNecessaryProof(num) {
	if ($('input[id="necessaryProof' + num + '"]').parent().find('button[onclick^="add"]').attr('style') == '') {
		$('input[id="necessaryProof' + num + '"]').parent().remove();
		$('input[id^="necessaryProof"]').parent().last().find('button[onclick^="add"]').show();
	}
	else {
		$('input[id="necessaryProof' + num + '"]').parent().remove();
	}
}

function fileCheck() {
	let check = 1;
	$('input[name$="Proof"]').each(function() {
		if ($(this).val() != '') {
			if ($(this).val().indexOf('.rar') != -1 || $(this).val().indexOf('.7z') != -1 || $(this).val().indexOf('.zip') != -1 || $(this).val().indexOf('.png') != -1 || $(this).val().indexOf('.jpg') != -1 || $(this).val().indexOf('.pdf') != -1 || $(this).val().indexOf('.doc') != -1 || $(this).val().indexOf('.docx') != -1 || $(this).val().indexOf('.odt') != -1) {
			}
			else {
				check = 0;
			}
		}
	})
	if (check == 0) {
		return false;
	}
	else {
		return true;
	}
}

function fileUploadCheck(){
	let checkFile=1;
	if($('#register').find('span.file_name').text()!=''){
			
	}else{
		checkFile=0;
	}
	if(checkFile==0)
	{
		alert('請確認檔案是否上傳');
	}
	else
	{
		location.href='career_07';
	}
}

function upload() {
	if (fileCheck()) {
		let registerFiles = new FormData();
		$('input[name^="registerProof"]').each(function() {
			registerFiles.append('registerFiles', $(this)[0].files[0]);
		});

		let jointAuthorizeFiles = new FormData();
		$('input[name^="jointAuthorizeProof"]').each(function() {
			jointAuthorizeFiles.append('jointAuthorizeFiles', $(this)[0].files[0]);
		});

		let necessaryFiles = new FormData();
		$('input[name^="necessaryProof"]').each(function() {
			necessaryFiles.append('necessaryFiles', $(this)[0].files[0]);
		});

		if (registerFiles.get('registerFiles') != 'undefined'
			|| jointAuthorizeFiles.get('jointAuthorizeFiles') != 'undefined'
				|| necessaryFiles.get('necessaryFiles') != 'undefined') {

			$('#loader-container').show();
			$.ajax({
				type: 'post',
				url: 'advancedAgeRetirementReemploymentApplyRegisterFileUplolad',// 資料不需要編碼
				enctype: 'multipart/form-data',
				contentType: false,// 資料物件不需要轉換成鍵值對格式
				processData: false,
				data: registerFiles,
				success: function(res) {
					if (res == 'fail') {
						alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
						reloadPage();
					} else {
						$.ajax({
							type: 'post',
							url: 'advancedAgeRetirementReemploymentApplyJointAuthorizeFileUplolad',// 資料不需要編碼
							enctype: 'multipart/form-data',
							contentType: false,// 資料物件不需要轉換成鍵值對格式
							processData: false,
							data: jointAuthorizeFiles,
							success: function(res) {
								if (res == 'fail') {
									alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
									reloadPage();
								} else {
									$.ajax({
										type: 'post',
										url: 'advancedAgeRetirementReemploymentApplyNecessaryFileUplolad',// 資料不需要編碼
										enctype: 'multipart/form-data',
										contentType: false,// 資料物件不需要轉換成鍵值對格式
										processData: false,
										data: necessaryFiles,
										success: function(res) {
											if (res == 'fail') {
												alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
												reloadPage();
											}else {
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
//			setTimeout(function() { window.location.reload(); }, 1000);
		} else {
			alert('請選擇檔案');
		}
	} else {
		alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
	}
}

function reloadPage(){
	window.location.reload();
}