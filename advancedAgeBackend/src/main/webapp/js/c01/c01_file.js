$(function(){
	$('.btn_a2s').click(function(){
//		let date=$(this).parent().parent().find('span.date').text();
		$.ajax({
		    type: "post",
		    url: 'saveReceiptRar',
			data: {
				fileBelongId : $('#baseId').val(),
				fileFrequency : $(this).val()
		    },
			success: function(json){  
				if(json.split(";")[0]=='success')
				{
					var url = json.split(";")[1];
					if (url !== '') {
		                var path = url.split('?path=')[1];
						if (/\/[a-zA-Z0-9_-]+\/[a-zA-Z0-9_-]+\.rar$/.test(path)) {  // 使用正則表達式進行驗證
		                    var encodedPath = encodeURIComponent(path);
		                    var downloadUrl = 'downloadRar?path=' + encodedPath;
		                    window.open(downloadUrl);
		                } else {
		                    alert('無效的路徑');
		                }
		            }
				}
				else{
					alert('下載檔案中檔案重複');
				}
		    },
		    error: function(json){
			    alert(json);
		    }
    	});
	})
	
})

function saveData(){
	$.ajax({
	    type: "POST",
	    url: 'changeFileStatus3',
	    data: {
			aaid : $('#baseAaid').val(),
			allowanceFileRemark : $('#otherRemark').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			allowanceEmailContent : $('#mailContent').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				alert('暫存成功');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function sendMail(){
	$.ajax({
	    type: "POST",
	    url: 'sendMail',
	    data: {
			mailContent : $('#mailHeader').text()+$('#mailContent').val()+$('#mailFooter').text(),
			email : $('#email').val(),
			advancedAgeBaseId : $('#baseId').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			mailType : 'B'
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			
			if(json=='success'){
				$.ajax({
				    type: "POST",
				    url: 'changeFileStatus3',
				    data: {
						aaid : $('#baseAaid').val(),
						allowanceFileRemark : $('#otherRemark').val(),
						verifyUnit : $('#verifyUnit').val(),
						verifyPerson : $('#verifyPerson').val(),
						allowanceEmailContent : $('#mailContent').val(),
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						if(json=='success'){
							alert('信件已發送');
						}
				    },
				    error: function(json){
					    alert(json);
				    }
			    });
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}