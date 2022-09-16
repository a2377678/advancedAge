$(function(){
	$('.btn_a2s').click(function(){
		let date=$(this).parent().parent().find('span.date').text();
		$.ajax({
		    type: "post",
		    url: 'saveRar',
			data: {
				fileBelongId : $('#applyId').val(),
				date : date,
				fileFrequency : $(this).val()
		    },
			success: function(json){  
				window.open('downloadRar?path=/A/'+$('#applyId').val()+'/'+date+'.rar');
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
			let register='',insure='',salary='',attendance='',necessary='';
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
			$(this).find('input[name^="insureFileStatus"]:checked').each(function(){
				if(insure==''){
					insure=$(this).val();
				}else{
					insure=insure+$(this).val();
				}
			})
			
			if(insure == ''){
				final=final+"、4";
			}else{
				final=final+"、"+insure;
			}
			
			//薪資證明狀態
			$(this).find('input[name^="salaryFileStatus"]:checked').each(function(){
				if(salary==''){
					salary=$(this).val();
				}else{
					salary=salary+$(this).val();
				}
			})
			if(salary == ''){
				final=final+"、4";
			}else{
				final=final+"、"+salary;
			}
			
			//出勤證明狀態
			$(this).find('input[name^="attendanceFileStatus"]:checked').each(function(){
				if(attendance==''){
					attendance=$(this).val();
				}else{
					attendance=attendance+$(this).val();
				}
			})
			if(attendance == ''){
				final=final+"、4";
			}else{
				final=final+"、"+attendance;
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
			$('#mailContent').append('\n公司設立登記證明 : '+'\n'+msg+'\n');
		
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="insureFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n勞保/職災保險證明 : '+'\n'+msg+'\n');
		
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="salaryFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n薪資證明 : '+'\n'+msg+'\n');
			
		msg='';
		$(this).parent().parent().parent().parent().find('input[name^="attendanceFileStatus"]:checked').each(function(){
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
			$('#mailContent').append('\n出勤證明 : '+'\n'+msg+'\n');
			
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
			$('#mailContent').append('\n其他必要證明 : '+'\n'+msg+'\n');
	})
})
function sendMail(){
	$.ajax({
	    type: "POST",
	    url: 'sendMail',
	    data: {
			mailContent : $('#mailHeader').text()+$('#mailContent').val()+$('#mailFooter').html().replaceAll('<br>',''),
			email : $('#email').val(),
			aaid : $('#baseAaid').val(),
			fileRemark : $('#otherRemark').val(),
			advancedAgeBaseId : $('#baseId').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val()
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
						fileRemark : $('#otherRemark').val()
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