$(function(){
	$('input[name$="Proof"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
		}
	});
})

function addApprovedProof(num){
	$('button[onclick^="addApprovedProof"]').hide();
	$('#approved').append('<div class="full">'+
        '<label for="approvedProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="approvedProof'+(Number(num)+1)+'" name="approvedProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button class="add" onclick="delApprovedProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addApprovedProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="approvedProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
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
        '<input type="file" id="receiptProof'+(Number(num)+1)+'" name="receiptProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button class="add" onclick="delReceiptProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addReceiptProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="receiptProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
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

function addEmploymentProof(num){
	$('button[onclick^="addEmploymentProof"]').hide();
	$('#employment').append('<div class="full">'+
        '<label for="employmentProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="employmentProof'+(Number(num)+1)+'" name="employmentProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button class="add" onclick="delEmploymentProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addEmploymentProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>')
	$('input[id="employmentProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
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


function addSalaryProof(num){
	$('button[onclick^="addSalaryProof"]').hide();
	$('#salary').append('<div class="full"> '+
        '<label for="salaryProof'+(Number(num)+1)+'">文件('+(Number(num)+1)+')</label> '+
        '<input type="file" id="salaryProof'+(Number(num)+1)+'" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button class="add" onclick="delSalaryProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addSalaryProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="salaryProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
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
        '<input type="file" id="attendanceProof'+(Number(num)+1)+'" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button class="add" onclick="delAttendanceProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addAttendanceProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="AttendanceProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
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
        '<input type="file" id="necessaryProof'+(Number(num)+1)+'" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z"> '+
        '<button class="add" onclick="delNecessaryProof('+(Number(num)+1)+')">－</button> '+
        '<button class="add" onclick="addNecessaryProof('+(Number(num)+1)+')" style>＋</button> '+
        '</div>');
	$('input[id="NecessaryProof'+(Number(num)+1)+'"]').change(function(){
		if($(this)[0].files[0].size/1024/1024>5)
		{
			alert('檔案大小不得超過 5mb');
			$(this).val('');
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
			if($(this).val().indexOf('.rar')!=-1 || $(this).val().indexOf('.7z')!=-1 || $(this).val().indexOf('.zip')!=-1 || $(this).val().indexOf('.png')!=-1 || $(this).val().indexOf('.jpg')!=-1 || $(this).val().indexOf('.pdf')!=-1){
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
		
		let employmentFiles = new FormData();
		$('input[name^="employmentProof"]').each(function(){
			employmentFiles.append('employmentFiles',$(this)[0].files[0]);
		});
		employmentFiles.append('baseId',$('#baseId').val());
		
		let salaryFiles = new FormData();
		$('input[name^="salaryProof"]').each(function(){
			salaryFiles.append('salaryFiles',$(this)[0].files[0]);
		});
		salaryFiles.append('baseId',$('#baseId').val());
		
		let attendanceFiles = new FormData();
		$('input[name^="attendanceProof"]').each(function(){
			attendanceFiles.append('attendanceFiles',$(this)[0].files[0]);
		});
		attendanceFiles.append('baseId',$('#baseId').val());
		
		let necessaryFiles = new FormData();
		$('input[name^="necessaryProof"]').each(function(){
			necessaryFiles.append('necessaryFiles',$(this)[0].files[0]);
		});
		necessaryFiles.append('baseId',$('#baseId').val());
		
		if(approvedFiles.get('approvedFiles') != 'undefined' || receiptFiles.get('receiptFiles') != 'undefined' || employmentFiles.get('employmentFiles') != 'undefined'  || salaryFiles.get('salaryFiles') != 'undefined' || attendanceFiles.get('attendanceFiles') != 'undefined' || necessaryFiles.get('necessaryFiles') != 'undefined' ){
			$('#loader-container').show();
			$.ajax({
			   	type: 'post',
				url: 'advancedAgeEmploymentListApprovedFileUplolad',// 資料不需要編碼
				enctype: 'multipart/form-data',	   	
				contentType: false,// 資料物件不需要轉換成鍵值對格式
			   	processData: false,
				data: approvedFiles,
				success: function(res) {
					$.ajax({
					   	type: 'post',
						url: 'advancedAgeEmploymentListReceiptFileUplolad',// 資料不需要編碼
						enctype: 'multipart/form-data',	   	
						contentType: false,// 資料物件不需要轉換成鍵值對格式
					   	processData: false,
						data: receiptFiles,
						success: function(res) {
							$.ajax({
							   	type: 'post',
								url: 'advancedAgeEmploymentListEmploymentFileUplolad',// 資料不需要編碼
								enctype: 'multipart/form-data',	   	
								contentType: false,// 資料物件不需要轉換成鍵值對格式
							   	processData: false,
								data: employmentFiles,
								success: function(res) {
									$.ajax({
									   	type: 'post',
										url: 'advancedAgeEmploymentListSalaryFileUplolad',// 資料不需要編碼
										enctype: 'multipart/form-data',	   	
										contentType: false,// 資料物件不需要轉換成鍵值對格式
									   	processData: false,
										data: salaryFiles,
										success: function(res) {
											$.ajax({
											   	type: 'post',
												url: 'advancedAgeEmploymentListAttendanceFileUplolad',// 資料不需要編碼
												enctype: 'multipart/form-data',	   	
												contentType: false,// 資料物件不需要轉換成鍵值對格式
											   	processData: false,
												data: attendanceFiles,
												success: function(res) {
													$.ajax({
													   	type: 'post',
														url: 'advancedAgeEmploymentListNecessaryFileUplolad',// 資料不需要編碼
														enctype: 'multipart/form-data',	   	
														contentType: false,// 資料物件不需要轉換成鍵值對格式
													   	processData: false,
														data: necessaryFiles,
														success: function(res) {
														}
													});
												}
											});
										}
									});
								}
							});
						}
					});
				}
			});
			setTimeout(function(){window.location.reload();}, 1000);
		}else{
		alert('請選擇檔案');
		}
	}else{
		alert('格式有誤');
	}
}