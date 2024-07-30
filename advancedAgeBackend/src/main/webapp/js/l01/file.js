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
		    url: 'saveRar2',
			data: {
				fileBelongId : $('#applyId').val(),
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
			let register='',speakerRetirement='',speakerExperience='',employment='',necessary='';
//			登記證明狀態
			$(this).find('input[name^="registerFileStatus"]:checked').each(function(){
				if(register==''){
					register=$(this).val();
				}else{
					register=register+$(this).val();
				}
			})
			if(final == '')
			{
				if(register == ''){
					final='4';
				}else{
					final=register;
				}
			}else{
				if(register == ''){
					final=final+";4";
				}else{
					final=final+";"+register;
				}
			}
			
			//勞保/職災保險證明狀態
			$(this).find('input[name^="speakerRetirementFileStatus"]:checked').each(function(){
				if(speakerRetirement==''){
					speakerRetirement=$(this).val();
				}else{
					speakerRetirement=speakerRetirement+$(this).val();
				}
			})
			
			if(speakerRetirement == ''){
				final=final+"、4";
			}else{
				final=final+"、"+speakerRetirement;
			}
			
			//薪資證明狀態
			$(this).find('input[name^="speakerExperienceFileStatus"]:checked').each(function(){
				if(speakerExperience==''){
					speakerExperience=$(this).val();
				}else{
					speakerExperience=speakerExperience+$(this).val();
				}
			})
			if(speakerExperience == ''){
				final=final+"、4";
			}else{
				final=final+"、"+speakerExperience;
			}
			
			//出勤證明狀態
			$(this).find('input[name^="employmentFileStatus"]:checked').each(function(){
				if(employment==''){
					employment=$(this).val();
				}else{
					employment=employment+$(this).val();
				}
			})
			if(employment == ''){
				final=final+"、4";
			}else{
				final=final+"、"+employment;
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
		$(this).parent().parent().parent().parent().find('input[name^="registerFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n設立登記證明 : '+'\n'+msg+'\n');
		
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="speakerRetirementFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n講師為退休高齡者證明 : '+'\n'+msg+'\n');
		
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="speakerExperienceFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n具專業技術及經驗證明 : '+'\n'+msg+'\n');
			
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="employmentFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n僱用證明 : '+'\n'+msg+'\n');
			
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
			mailType : 'A'
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			
			if(json=='success'){
				$.ajax({
				    type: "POST",
				    url: 'changeFileStatus',
				    data: {
						aaid : $('#baseAaid').val(),
						fileStatus : '2',
						fileRemark : $('#otherRemark').val(),
						verifyUnit : $('#verifyUnit').val(),
						verifyPerson : $('#verifyPerson').val(),
						emailContent : $('#mailContent').val()
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
			fileStatusRecord : data,
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
	    url: 'changeFileStatus',
	    data: {
			aaid : $('#baseAaid').val(),
			fileRemark : $('#otherRemark').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			emailContent : $('#mailContent').val(),
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
	    url: 'changeFileStatus',
	    data: {
			aaid : $('#baseAaid').val(),
			fileStatus : '4',
			fileRemark : $('#otherRemark').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			emailContent : $('#mailContent').val(),
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