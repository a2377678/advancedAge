function upload(){
	alert('upload');
	let file = new FormData();
	file.append('uploadFile',$('#upload').get(0).files[0]);
	file.append('year',$('#year').val());
	if($('#type').val()==1){
	    $.ajax({
		   	type: 'post',
			url: 'addOldData',// 資料不需要編碼
			enctype: 'multipart/form-data',	   	
			contentType: false,// 資料物件不需要轉換成鍵值對格式
		   	processData: false,
			data: file,
			success: function(res) {
		   	// 判斷是否接收成功
				if(res=='success')
				{
			   		alert('檔案已上傳');
					window.location.reload();
				}else{
					alert('請確認檔案格式及內容');
				}
			}
		});
	}else{
		$.ajax({
		   	type: 'post',
			url: 'addOldEmployment',// 資料不需要編碼
			enctype: 'multipart/form-data',	   	
			contentType: false,// 資料物件不需要轉換成鍵值對格式
		   	processData: false,
			data: file,
			success: function(res) {
		   	// 判斷是否接收成功
				if(res=='success')
				{
			   		alert('檔案已上傳');
					window.location.reload();
				}else{
					alert('請確認檔案格式及內容');
				}
			}
		});
	}  
}

function sendMail(){
	$.ajax({
		   	type: 'post',
			url: 'testMail',// 資料不需要編碼
			enctype: 'multipart/form-data',	   	
			contentType: false,// 資料物件不需要轉換成鍵值對格式
		   	processData: false,
			success: function(res) {
			}
		});
}