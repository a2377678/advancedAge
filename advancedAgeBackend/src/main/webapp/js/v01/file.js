$(function(){
	$('input[name*="FileStatus"]').click(function(){
		if($(this).val()==4){
			$(this).parent().parent().find('input[name*="FileStatus1"]').prop('checked',false);
			$(this).parent().parent().find('input[name*="FileStatus2"]').prop('checked',false);
			$(this).parent().parent().find('input[name*="FileStatus3"]').prop('checked',false);
		}else{
			$(this).parent().parent().find('input[name*="FileStatus4"]').prop('checked',false);
		}
	})
	$('.btn_a2s').click(function(){
		let date=$(this).parent().parent().find('span.date').text();
		$.ajax({
		    type: "post",
		    url: 'allowanceSaveRar2',
			data: {
				fileBelongId : $('#baseId').val(),
				date : date,
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
	//附件狀態儲存
	$('button.btn_a1s').click(function(){
		
		let final='';
		$('div.file_group').each(function(){
			let approved='',receipt='',result='',expenditure='',speakerFee='',necessary='';
			//本計畫核准函影本
			$(this).find('input[name^="approvedFileStatus"]:checked').each(function(){
				if(approved==''){
					approved=$(this).val();
				}else{
					approved=approved+$(this).val();
				}
			})
			if(final == '')
			{
				if(approved == ''){
					final='4';
				}else{
					final=approved;
				}
			}else{
				if(approved == ''){
					final=final+";4";
				}else{
					final=final+";"+approved;
				}
			}
			
			//請款之領據正本
			$(this).find('input[name^="receiptFileStatus"]:checked').each(function(){
				if(receipt==''){
					receipt=$(this).val();
				}else{
					receipt=receipt+$(this).val();
				}
			})
			
			if(receipt == ''){
				final=final+"、4";
			}else{
				final=final+"、"+receipt;
			}
			
			//成果報告內容附件
			$(this).find('input[name^="resultFileStatus"]:checked').each(function(){
				if(result==''){
					result=$(this).val();
				}else{
					result=result+$(this).val();
				}
			})
			if(result == ''){
				final=final+"、4";
			}else{
				final=final+"、"+result;
			}
			
			//經費支用單據明細
			$(this).find('input[name^="expenditureFileStatus"]:checked').each(function(){
				if(expenditure==''){
					expenditure=$(this).val();
				}else{
					expenditure=expenditure+$(this).val();
				}
			})
			if(expenditure == ''){
				final=final+"、4";
			}else{
				final=final+"、"+expenditure;
			}
			
			//其他必要證明狀態
			$(this).find('input[name^="necessaryFileStatus"]:checked').each(function(){
				if(necessary==''){
					necessary=$(this).val();
				}else{
					necessary=necessary+$(this).val();
				}
			})
			if(necessary == ''){
				final=final+"、4";
			}else{
				final=final+"、"+necessary;
			}
			final=final+"、"+$(this).find('input[name^="uploadTime"]').val();
		})
		fileStatusSave(final);
		
		//檔案狀態儲存後，帶入email
		if($('#mailContent').text()!='')
		{
			$('#mailContent').append('\n'+$(this).parent().parent().find('span.date').text()+' '+$(this).parent().parent().find('span.time').text().substring(0,5));
		}else
		{
			$('#mailContent').append($(this).parent().parent().find('span.date').text()+' '+$(this).parent().parent().find('span.time').text().substring(0,5));
		}
		let msg='';
		$(this).parent().parent().parent().parent().find('input[name^="approvedFileStatus"]:checked').each(function(){
			if(msg==''){
				if($(this).val()!=4){
					msg=$(this).parent().text();
				}
			}
			else
			{
				if($(this).val()!=4){
					msg=msg+'\n'+$(this).parent().text();
				}
			}
		})
		if(msg!='')
			$('#mailContent').append('\n本計畫核准函影本 : '+'\n'+msg+'\n');
		
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="receiptFileStatus"]:checked').each(function(){
			if(msg==''){
				if($(this).val()!=4){
					msg=$(this).parent().text();
				}
			}
			else
			{
				if($(this).val()!=4){
					msg=msg+'\n'+$(this).parent().text();
				}
			}
		})
		if(msg!='')
			$('#mailContent').append('\n請款之領據正本 : '+'\n'+msg+'\n');
		
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="resultFileStatus"]:checked').each(function(){
			if(msg==''){
				if($(this).val()!=4){
					msg=$(this).parent().text();
				}
			}
			else
			{
				if($(this).val()!=4){
					msg=msg+'\n'+$(this).parent().text();
				}
			}
		})
		if(msg!='')
			$('#mailContent').append('\n成果報告內容附件 : '+'\n'+msg+'\n');
			
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="expenditureFileStatus"]:checked').each(function(){
			if(msg==''){
				if($(this).val()!=4){
					msg=$(this).parent().text();
				}
			}
			else
			{
				if($(this).val()!=4){
					msg=msg+'\n'+$(this).parent().text();
				}
			}
		})
		if(msg!='')
			$('#mailContent').append('\n經費支用單據明細 : '+'\n'+msg+'\n');
			
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="necessaryFileStatus"]:checked').each(function(){
			if(msg==''){
				if($(this).val()!=4){
					msg=$(this).parent().text();
				}
			}
			else
			{
				if($(this).val()!=4){
					msg=msg+'\n'+$(this).parent().text();
				}
			}
		})
		if(msg!='')
			$('#mailContent').append('\n其他文件 : '+'\n'+msg+'\n');
	})
})
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
						caseStatus : '4',
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

function fileStatusSave(data){
	$.ajax({
	    type: "POST",
	    url: 'fileStatusSave',
	    data: {
			aaid : $('#baseAaid').val(),
			allowanceFileStatusRecord : data,
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				alert('儲存成功');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

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

function finish(){
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
				window.close();
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}