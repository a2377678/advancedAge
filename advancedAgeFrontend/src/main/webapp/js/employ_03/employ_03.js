$(function(){
	$('#listForm').validate();
	if($('#excel').find('a').attr('class') != '' && $('#excel').find('a').attr('class') != undefined)
	{
		$('#listStaff').hide();
		$('#listFile').show();
	}
	$('button.close').click(function(){
		if(confirm('是否確定要移除？'))
		{
			let path=$(this).parent().parent('li');
			$.ajax({
			    type: "POST",
			    url: 'delAdvancedAgeEmploymentList',
			    data: {
					identification : $(this).parent().parent('li').find('input[name^="identification"]').val(),
					seq : $('#seq').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){
					if(json=='success'){
						path.remove();
					}
				}
			})
		}
		return false;
	});
	$('#nearHighEmploymentNumber').change(function(){
		$('#continueEmploymentPercentage').val((Number($('#continueEmploymentNumber').val())/Number($(this).val())*100).toFixed(1));
	});
	$('#continueEmploymentNumber').change(function(){
		$('#continueEmploymentPercentage').val((Number($(this).val())/Number($('#nearHighEmploymentNumber').val())*100).toFixed(1));
	});
	
	$('input[name^="recurringSalary"]').change(function(){
//		let total=Number($(this).parent().parent().find('input[name^="notRecurringSalary"]').val())+Number($(this).val());
		let total=Number($(this).val());
		$(this).parent().parent().find('input[name^="averageSalary"]').val(Math.floor(total/3));
	});
	
//	$('input[name^="notRecurringSalary"]').change(function(){
//		let total =Number($(this).parent().parent().find('input[name^="recurringSalary"]').val())+Number($(this).val());
//		$(this).parent().parent().find('input[name^="averageSalary"]').val(Math.floor(total/3));
//	});
	
	$('input[name^="identification"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
		}
//		else
//		{
//			$(this).parent().parent('li').find('input').attr('required',false);
//			$(this).parent().parent('li').find('select').attr('required',false);
//			$(this).parent().parent('li').find('input').removeClass();
//			$(this).parent().parent('li').find('select').removeClass();
//			$(this).parent().parent('li').find('label.error').remove();
//		}
	});
	
	$('#employed').click(function(){
		$('#excel').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').show();
		$('#listFile').hide();
		$('#uploadFile').val('');
	});
	
	$('#excel').click(function(){
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').hide();
		$('#listFile').show();
	});
});

function planSave(showMsg,upload){
	$.ajax({
	    type: "POST",
	    url: 'addAdvancedAgePlan',
	    data: {
			items : $('#items').val(),
	    	employmentNumber : $('#employmentNumber').val(),
			highEmploymentNumber : $('#highEmploymentNumber').val(),
			middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
			lowEmploymentNumber : $('#lowEmploymentNumber').val(),
			nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
			continueEmploymentNumber : $('#continueEmploymentNumber').val(),
			continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
			attachEmploymentList : upload,
			seq : $('#seq').val()
//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
//			friendlyMeasures : $('#friendlyMeasures').val(),
//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
//			assistanceMeasures : $('#assistanceMeasures').val(),
//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(showMsg=='Y')
			{
		   		alert('資料已暫存');
			}
//			assistanceMeasuresFilesUpload(showMsg);
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

//function assistanceMeasuresFilesUpload(showMsg){
//	if($('#attachAssistanceMeasures').val()!='')
//	{
//		let assistanceMeasuresFiles = new FormData();
//		$('input[name^="attachAssistanceMeasures"]').each(function(){
//			assistanceMeasuresFiles.append('assistanceMeasuresFiles',$(this)[0].files[0]);
//		});
//		$.ajax({
//		   	type: 'post',
//			url: 'advancedAgePlanAssistanceMeasuresFileUplolad',// 資料不需要編碼
//			enctype: 'multipart/form-data',	   	
//			contentType: false,// 資料物件不需要轉換成鍵值對格式
//		   	processData: false,
//			data: assistanceMeasuresFiles,
//			success: function(res) {
//		   	// 判斷是否接收成功
//				friendlyMeasuresFilesUpload(showMsg);
//			}
//		});
//	}
//	else
//	{
//		friendlyMeasuresFilesUpload(showMsg);
//	}
//}

//function friendlyMeasuresFilesUpload(showMsg){
//	if($('#attachFriendlyMeasures').val()!='')
//	{
//		let friendlyMeasuresFiles = new FormData();
//		$('input[name^="attachFriendlyMeasures"]').each(function(){
//			friendlyMeasuresFiles.append('friendlyMeasuresFiles',$(this)[0].files[0]);
//		});
//		$.ajax({
//		   	type: 'post',
//			url: 'advancedAgePlanFriendlyMeasuresFileUplolad',// 資料不需要編碼
//			enctype: 'multipart/form-data',	   	
//			contentType: false,// 資料物件不需要轉換成鍵值對格式
//		   	processData: false,
//			data: friendlyMeasuresFiles,
//			success: function(res) {
//		   	// 判斷是否接收成功
//				expectedMeasuresEffectivenessFilesUpload(showMsg);
//			}
//		});
//	}else{
//		expectedMeasuresEffectivenessFilesUpload(showMsg);
//	}
//	
//}
//
//function expectedMeasuresEffectivenessFilesUpload(showMsg){
//	if($('#attachExpectedMeasuresEffectiveness').val()!='')
//	{
//		let expectedMeasuresEffectivenessFiles = new FormData();
//		$('input[name^="attachExpectedMeasuresEffectiveness"]').each(function(){
//			expectedMeasuresEffectivenessFiles.append('expectedMeasuresEffectivenessFiles',$(this)[0].files[0]);
//		});
//		$.ajax({
//		   	type: 'post',
//			url: 'advancedAgePlanExpectedMeasuresEffectivenessFilesFileUplolad',// 資料不需要編碼
//			enctype: 'multipart/form-data',	   	
//			contentType: false,// 資料物件不需要轉換成鍵值對格式
//		   	processData: false,
//			data: expectedMeasuresEffectivenessFiles,
//			success: function(res) {
//		   	// 判斷是否接收成功
//				if(showMsg=='Y')
//				{
//			   		alert('資料已暫存');
//				}
//			}
//		});
//	}
//	else
//	{
//		if(showMsg=='Y')
//		{
//	   		alert('資料已暫存');
//		}
//	}
//}

function listAdd(){
	maxNum=Number($('#listStaff').find('li').last().find('input[name^="name"]').attr('id').replace('name',''))+1;
	if(maxNum<6)
	{
		$('#listStaff').find('ol').append('<li>'+
	          '<div class="ss">'+
	          '<label for="name'+maxNum+'">勞工姓名</label>  '+
	          '<input type="text" id="name'+maxNum+'" name="name">'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="identification'+maxNum+'">身分證字號</label>  '+
	          '<input type="text" id="identification'+maxNum+'" name="identification">'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="insuranceType'+maxNum+'">保險類型</label>  '+
	          '<select id="insuranceType'+maxNum+'" name="insuranceType">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="1">勞工保險</option>'+
	          '  <option value="2">職災保險</option>'+
	          '</select>'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="insuranceTime'+maxNum+'">加保日期</label>  '+
	          '<input type="text" id="insuranceTime'+maxNum+'" name="insuranceTime" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')">'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="manager'+maxNum+'">職務類型</label>  '+
	          '<select id="manager'+maxNum+'" name="manager">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="Y">主管</option>'+
	          '  <option value="N">非主管</option>'+
	          '</select>'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="relatives'+maxNum+'">親等關係</label>  '+
	          '<select id="relatives'+maxNum+'" name="relatives">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="N">非三親等</option>'+
	          '  <option value="Y">三親等內</option>'+
	          '</select>'+
	          '<img src="images/icon_qu.png" class="icon_qu"'+
	          'title="【三親等內】之親屬包含：\n'+
	'配偶、父母、子女、兄弟姊妹、\n'+
	'(外)祖父母、(外)孫子女、\n'+
	'伯、叔、姑、舅、姨、\n'+
	'姪子(女)、外甥(女)、\n'+
	'(外)曾祖父母、(外)曾孫子女">'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="workingHours'+maxNum+'">工時類型</label>  '+
	          '<select id="workingHours'+maxNum+'" name="workingHours">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="A">全時</option>'+
	          '  <option value="P">部分工時</option>'+
	          '</select>'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="averageSalary'+maxNum+'">平均薪資</label>  '+
	          '<input type="text" id="averageSalary'+maxNum+'" name="averageSalary" class="readonly" placeholder="填寫完自動計算" readonly>'+
	          '</div>'+
	          '<div class="m">'+
	          '<label for="recurringSalary'+maxNum+'">經常性薪資</label>  '+
	          '<input type="text" id="recurringSalary'+maxNum+'" name="recurringSalary" pattern="[0-9]*" placeholder="申請前3個月總和">'+ 
	          ' ( 本薪 / 津貼 / 經常性獎金 )'+
	          '<img src="images/icon_qu.png" class="icon_qu"'+
	          'title="【經常性薪資】\n'+
	'包含：本薪、交通津貼、伙食津貼、\n'+
	'　　　績效獎金、全勤獎金、工作獎金；\n'+  
	'不含：差旅費、差旅津貼、交際費。"></div>'+          
			  '<div class="m">'+
	          '<label for="notRecurringSalary'+maxNum+'">非經常性薪資</label> '+
	          '<input type="text" id="notRecurringSalary'+maxNum+'" name="notRecurringSalary" placeholder="申請前3個月總和">'+
	' ( 加班費 / 不休假獎金 )'+
	          '<img src="images/icon_qu.png" class="icon_qu"'+
	          'title="【非經常性薪資】\n'+
	'包含：加班費、不休假獎金；  \n'+
	'不含：紅利、年終獎金、久任獎金、三節獎\n'+
	'　　　金、醫療補助費、子女教育補助費。"></div>'+
	          '<div class="close"><button class="close" title="移除此筆資料">X</button></div>'+
	        '</li>');
		$('button.close').click(function(){
			$.ajax({
			    type: "POST",
			    url: 'delAdvancedAgeEmploymentList',
			    data: {
					identification : $(this).parent().parent('li').find('input[name^="identification"]').val(),
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){
					
				}
			})
			$(this).parent().parent('li').remove();
		});
		
		$('input[name^="recurringSalary"]').change(function(){
	//		let total=Number($(this).parent().parent().find('input[name^="notRecurringSalary"]').val())+Number($(this).val());
			let total=Number($(this).val());
			$(this).parent().parent().find('input[name^="averageSalary"]').val(Math.floor(total/3));
		});
		
	//	$('input[name^="notRecurringSalary"]').change(function(){
	//		let total =Number($(this).parent().parent().find('input[name^="recurringSalary"]').val())+Number($(this).val());
	//		$(this).parent().parent().find('input[name^="averageSalary"]').val(Math.floor(total/3));
	//	});
		
		$('input[name^="identification"]').change(function(){
			if($(this).val().length>0)
			{
				$(this).parent().parent('li').find('input').attr('required',true);
				$(this).parent().parent('li').find('select').attr('required',true);
			}
			else
			{
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass();
				$(this).parent().parent('li').find('select').removeClass();
				$(this).parent().parent('li').find('label.error').remove();
			}
		});
	}
}

//function listDelete(){
//	$('#listStaff').find('li').last().remove();
//}

function listSave(showMsg){
	$('#loader-container').show();
	$.ajax({
	    type: "POST",
	    url: 'addAdvancedAgePlan',
	    data: {
			items : $('#items').val(),
	    	employmentNumber : $('#employmentNumber').val(),
			highEmploymentNumber : $('#highEmploymentNumber').val(),
			middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
			lowEmploymentNumber : $('#lowEmploymentNumber').val(),
			nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
			continueEmploymentNumber : $('#continueEmploymentNumber').val(),
			continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
			attachEmploymentList : 'N',
			seq : $('#seq').val()
//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
//			friendlyMeasures : $('#friendlyMeasures').val(),
//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
//			assistanceMeasures : $('#assistanceMeasures').val(),
//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			let list=[];
			$('#listStaff').find('li').each(function(index,value){
				if($(this).find('input[name^="identification"]').val()!='')
				{
					if($(this).find('select[name^="insuranceType"]').val()==1){
						let data={"name" : $(this).find('input[name^="name"]').val(),
							"identification" : $(this).find('input[name^="identification"]').val(),
							"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
							"manager" : $(this).find('select[name^="manager"]').val(),
							"relatives" : $(this).find('select[name^="relatives"]').val(),
							"workingHours" : $(this).find('select[name^="workingHours"]').val(),
							"averageSalary" : $(this).find('input[name^="averageSalary"]').val(),
							"recurringSalary" : $(this).find('input[name^="recurringSalary"]').val(),
							"notRecurringSalary" : $(this).find('input[name^="notRecurringSalary"]').val()
						}
						list.push(data);
					}
					else
					{
						let data={"name" : $(this).find('input[name^="name"]').val(),
							"identification" : $(this).find('input[name^="identification"]').val(),
							"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
							"manager" : $(this).find('select[name^="manager"]').val(),
							"relatives" : $(this).find('select[name^="relatives"]').val(),
							"workingHours" : $(this).find('select[name^="workingHours"]').val(),
							"averageSalary" : $(this).find('input[name^="averageSalary"]').val(),
							"recurringSalary" : $(this).find('input[name^="recurringSalary"]').val(),
							"notRecurringSalary" : $(this).find('input[name^="notRecurringSalary"]').val()
						}
						list.push(data);
					}
				}
				
			});
			$.ajax({
			    type: "POST",
			    url: 'addAdvancedAgeEmploymentList',
			    data: JSON.stringify(list),
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				contentType:"application/json",
			    success: function(json){  
					alert('資料已暫存');
					window.location.reload();
			    },
			    error: function(json){
				    alert('稍等5秒再試');
			    }
		    });
	    },
	    error: function(json){
		    alert(json);
	    }
    });
	
	
}
function fileUpload(showMsg){
	$('#loader-container').show();
	$.ajax({
	    type: "POST",
	    url: 'addAdvancedAgePlan',
	    data: {
			items : $('#items').val(),
	    	employmentNumber : $('#employmentNumber').val(),
			highEmploymentNumber : $('#highEmploymentNumber').val(),
			middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
			lowEmploymentNumber : $('#lowEmploymentNumber').val(),
			nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
			continueEmploymentNumber : $('#continueEmploymentNumber').val(),
			continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
			attachEmploymentList : 'Y',
			seq : $('#seq').val()
//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
//			friendlyMeasures : $('#friendlyMeasures').val(),
//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
//			assistanceMeasures : $('#assistanceMeasures').val(),
//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if($('#uploadFile').val() != '')
			{
				let file = new FormData();
				file.append('uploadFile',$('#uploadFile').get(0).files[0]);
				$.confirm({
				    title: '補助名單上傳前確認',
				    animation: 'zoom',
				    closeAnimation: 'scale',
				    content: '提醒您上傳會先清除之前的補助名單',
				    buttons: {
				      確認: function() {
				        $.ajax({
						   	type: 'post',
							url: 'addAdvancedAgeEmploymentListFromFile',// 資料不需要編碼
							enctype: 'multipart/form-data',	   	
							contentType: false,// 資料物件不需要轉換成鍵值對格式
						   	processData: false,
							data: file,
							success: function(res) {
						   	// 判斷是否接收成功
								if(res='success')
								{
							   		alert('檔案已上傳');
									window.location.reload();
								}
							}
						});
				      },
				      取消: function() {
						$('#loader-container').hide();
				      }
				    }
				  });
				
			}
			else
			{
				alert('請選擇上傳檔案');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
	
}
/*
function situationAdd(){
	let maxNum=Number($('#situationStaff').find('input[name^="employedExpiredStatus"]').last().attr('name').replace('employedExpiredStatus',''))+1;
	
	$('#situationStaff').append('<li>'+
          '<div class="ss">'+
          '<label for="applyYear'+maxNum+'">申請年度</label> '+
          '<input type="text" pattern="[0-9]" placeholder="yyy" maxlength="3" id="applyYear'+maxNum+'" name="applyYear">'+
          '</div>'+
          '<div class="ss">'+
          '<label for="workName'+maxNum+'">補助勞工姓名</label> '+
          '<input type="text" id="workName'+maxNum+'" name="workName">'+
          '</div>'+
          '<div class="ss">'+
          '<label for="workIdentification'+maxNum+'">身分證字號</label> '+
          '<input type="text" id="workIdentification'+maxNum+'" name="workIdentification">'+ 
          '</div>'+
          '<div class="ss">'+
          '<label for="employedAmong'+maxNum+'">獲補助月數</label> '+
          '<input type="number" step="1" min="0" id="employedAmong'+maxNum+'" name="employedAmong">'+
          '</div>'+
          '<div class="full">'+
          '<label for="employedExpiredStatus1'+maxNum+'">續期滿後留任狀況：</label> '+
          '  <span>'+
          '  <input type="radio" name="employedExpiredStatus'+maxValue+'" value="1" id="employedExpiredStatus1'+maxNum+'">'+
          '  於繼續僱用18個月內離職'+
          '  </span>'+
          '  <span>'+
          '  <input type="radio" name="employedExpiredStatus'+maxValue+'" value="2" id="employedExpiredStatus2'+maxNum+'">'+
          '  於繼續僱用18個月後'+
          '  <input type="number" step="1" min="0" style="width:50px;" id="employedExpiredResign'+maxNum+'" name="employedExpiredResign">'+
          '  個月離職'+
          '  </span>'+
          '  <input type="radio" name="employedExpiredStatus'+maxValue+'" value="3" id="employedExpiredStatus3'+maxNum+'">'+
          '  已滿18個月在職中'+
          '</div>'+
          '<div class="close"><button class="close" title="移除此筆資料">X</button></div>'+
        '</li>');
	$('button.close').click(function(){
		$(this).parent().parent('li').remove();
	});
}

function situationDelete(){
	$('#situationStaff').find('li').last().remove();
}

function situationSave(){
	let situation=[];
	$('#situationStaff').find('li').each(function(index,value){
		if($(this).find('input[name="workName"]').val()!='')
		{
			if($(this).find('input[name^="employedExpiredStatus"]:checked').val()=='2'){
				let data={"applyYear" : $(this).find('input[name="applyYear"]').val(),
					"name" : $(this).find('input[name="workName"]').val(),
					"identification" : $(this).find('input[name="workIdentification"]').val(),
					"employedAmong" : $(this).find('input[name="employedAmong"]').val(),
					"employedExpiredStatus" : $(this).find('input[name^="employedExpiredStatus"]:checked').val(),
					"employedExpiredResign" : $(this).find('input[name="employedExpiredResign"]').val()
				}
				situation.push(data);
			}
			else
			{
				let data={"applyYear" : $(this).find('input[name="applyYear"]').val(),
					"name" : $(this).find('input[name="workName"]').val(),
					"identification" : $(this).find('input[name="workIdentification"]').val(),
					"employedAmong" : $(this).find('input[name="employedAmong"]').val(),
					"employedExpiredStatus" : $(this).find('input[name^="employedExpiredStatus"]:checked').val()
				}
				situation.push(data);
			}
		}
		
//		alert($(this).find('select[name="insuranceType"]').val());
	});
//	alert(JSON.stringify(situation));
	
	$.ajax({
	    type: "POST",
	    url: 'addAdvancedAgeApplyEmployedSituation',
	    data: JSON.stringify(situation),
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		contentType:"application/json",
	    success: function(json){
			alert('資料已暫存');
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}
*/
function totalSave(showMsg){
	$('#loader-container').show();
	if($('#employed').find('a').attr('class')!='' && $('#employed').find('a').attr('class')!=undefined)
	{
		$.ajax({
		    type: "POST",
		    url: 'addAdvancedAgePlan',
		    data: {
				items : $('#items').val(),
		    	employmentNumber : $('#employmentNumber').val(),
				highEmploymentNumber : $('#highEmploymentNumber').val(),
				middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
				lowEmploymentNumber : $('#lowEmploymentNumber').val(),
				nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
				continueEmploymentNumber : $('#continueEmploymentNumber').val(),
				continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
				attachEmploymentList : 'N',
				seq : $('#seq').val()
	//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
	//			friendlyMeasures : $('#friendlyMeasures').val(),
	//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
	//			assistanceMeasures : $('#assistanceMeasures').val(),
	//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
	//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if($('#listForm').valid()){
					let list=[];
					$('#listStaff').find('li').each(function(index,value){
						if($(this).find('input[name^="identification"]').val()!='')
						{
							if($(this).find('select[name^="insuranceType"]').val()==1){
								let data={"name" : $(this).find('input[name^="name"]').val(),
									"identification" : $(this).find('input[name^="identification"]').val(),
									"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
									"manager" : $(this).find('select[name^="manager"]').val(),
									"relatives" : $(this).find('select[name^="relatives"]').val(),
									"workingHours" : $(this).find('select[name^="workingHours"]').val(),
									"averageSalary" : $(this).find('input[name^="averageSalary"]').val(),
									"recurringSalary" : $(this).find('input[name^="recurringSalary"]').val(),
									"notRecurringSalary" : $(this).find('input[name^="notRecurringSalary"]').val()
								}
								list.push(data);
							}
							else
							{
								let data={"name" : $(this).find('input[name^="name"]').val(),
									"identification" : $(this).find('input[name^="identification"]').val(),
									"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
									"manager" : $(this).find('select[name^="manager"]').val(),
									"relatives" : $(this).find('select[name^="relatives"]').val(),
									"workingHours" : $(this).find('select[name^="workingHours"]').val(),
									"averageSalary" : $(this).find('input[name^="averageSalary"]').val(),
									"recurringSalary" : $(this).find('input[name^="recurringSalary"]').val(),
									"notRecurringSalary" : $(this).find('input[name^="notRecurringSalary"]').val()
								}
								list.push(data);
							}
						}
						
					});
					$.ajax({
					    type: "POST",
					    url: 'addAdvancedAgeEmploymentList',
					    data: JSON.stringify(list),
					    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
						contentType:"application/json",
					    success: function(json){  
					   		if(showMsg=='Y')
							{
					   			alert('資料已暫存');
								window.location.reload();
							}
					    },
					    error: function(json){
						    alert('稍等5秒再試');
							$('#loader-container').hide();
					    }
				    });
				}
		    },
		    error: function(json){
			    alert(json);
				$('#loader-container').hide();
		    }
	    });
		
	}
	else
	{
		$.ajax({
		    type: "POST",
		    url: 'addAdvancedAgePlan',
		    data: {
				items : $('#items').val(),
		    	employmentNumber : $('#employmentNumber').val(),
				highEmploymentNumber : $('#highEmploymentNumber').val(),
				middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
				lowEmploymentNumber : $('#lowEmploymentNumber').val(),
				nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
				continueEmploymentNumber : $('#continueEmploymentNumber').val(),
				continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
				attachEmploymentList : 'Y',
				seq : $('#seq').val()
	//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
	//			friendlyMeasures : $('#friendlyMeasures').val(),
	//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
	//			assistanceMeasures : $('#assistanceMeasures').val(),
	//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
	//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if($('#uploadFile').val() != '')
				{
					let file = new FormData();
					file.append('uploadFile',$('#uploadFile').get(0).files[0]);
					$.confirm({
					    title: '補助名單上傳前確認',
					    animation: 'zoom',
					    closeAnimation: 'scale',
					    content: '提醒您上傳會先清除之前的補助名單',
					    buttons: {
					      確認: function() {
					        $.ajax({
							   	type: 'post',
								url: 'addAdvancedAgeEmploymentListFromFile',// 資料不需要編碼
								enctype: 'multipart/form-data',	   	
								contentType: false,// 資料物件不需要轉換成鍵值對格式
							   	processData: false,
								data: file,
								success: function(res) {
							   	// 判斷是否接收成功
									if(res='success')
									{
										if(showMsg=='Y')
										{
								   			alert('資料已暫存');
											window.location.reload();
										}
									}
								}
							});
					      },
					      取消: function() {
								$('#loader-container').hide();
					      }
					    }
					  });
					
				}
				else
				{
					if($('#alreadyExist').html()==undefined)
					{	
						alert('請選擇上傳檔案');
						$('#loader-container').hide();
					}
					else
					{
						alert('資料已暫存');
						$('#loader-container').hide();
					}
				}
		    },
		    error: function(json){
			    alert(json);
				$('#loader-container').hide();
		    }
	    });
		
	}
}
function next(){
	if($('#form').valid() && $('#listForm').valid()){
		$('#loader-container').show();
		if($('#employed').find('a').attr('class')!='' && $('#employed').find('a').attr('class')!=undefined)
		{
			$.ajax({
			    type: "POST",
			    url: 'addAdvancedAgePlan',
			    data: {
					items : $('#items').val(),
			    	employmentNumber : $('#employmentNumber').val(),
					highEmploymentNumber : $('#highEmploymentNumber').val(),
					middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
					lowEmploymentNumber : $('#lowEmploymentNumber').val(),
					nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
					continueEmploymentNumber : $('#continueEmploymentNumber').val(),
					continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
					attachEmploymentList : 'N',
					seq : $('#seq').val()
		//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
		//			friendlyMeasures : $('#friendlyMeasures').val(),
		//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
		//			assistanceMeasures : $('#assistanceMeasures').val(),
		//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
		//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					if($('#listForm').valid()){
						let list=[];
						$('#listStaff').find('li').each(function(index,value){
							if($(this).find('input[name^="identification"]').val()!='')
							{
								if($(this).find('select[name^="insuranceType"]').val()==1){
									let data={"name" : $(this).find('input[name^="name"]').val(),
										"identification" : $(this).find('input[name^="identification"]').val(),
										"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
										"manager" : $(this).find('select[name^="manager"]').val(),
										"relatives" : $(this).find('select[name^="relatives"]').val(),
										"workingHours" : $(this).find('select[name^="workingHours"]').val(),
										"averageSalary" : $(this).find('input[name^="averageSalary"]').val(),
										"recurringSalary" : $(this).find('input[name^="recurringSalary"]').val(),
										"notRecurringSalary" : $(this).find('input[name^="notRecurringSalary"]').val()
									}
									list.push(data);
								}
								else
								{
									let data={"name" : $(this).find('input[name^="name"]').val(),
										"identification" : $(this).find('input[name^="identification"]').val(),
										"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
										"manager" : $(this).find('select[name^="manager"]').val(),
										"relatives" : $(this).find('select[name^="relatives"]').val(),
										"workingHours" : $(this).find('select[name^="workingHours"]').val(),
										"averageSalary" : $(this).find('input[name^="averageSalary"]').val(),
										"recurringSalary" : $(this).find('input[name^="recurringSalary"]').val(),
										"notRecurringSalary" : $(this).find('input[name^="notRecurringSalary"]').val()
									}
									list.push(data);
								}
							}
							
						});
						$.ajax({
						    type: "POST",
						    url: 'addAdvancedAgeEmploymentList',
						    data: JSON.stringify(list),
						    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
							contentType:"application/json",
						    success: function(json){ 
						   		if(json='success')
								{
									location.href='employ_04?seq='+$('#seq').val();
								}
						    },
						    error: function(json){
							    alert('稍等5秒再試');
								$('#loader-container').hide();
						    }
					    });
					}
			    },
			    error: function(json){
				    alert(json);
					$('#loader-container').hide();
			    }
		    });
			
		}
		else
		{
			$.ajax({
			    type: "POST",
			    url: 'addAdvancedAgePlan',
			    data: {
					items : $('#items').val(),
			    	employmentNumber : $('#employmentNumber').val(),
					highEmploymentNumber : $('#highEmploymentNumber').val(),
					middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
					lowEmploymentNumber : $('#lowEmploymentNumber').val(),
					nearHighEmploymentNumber : $('#nearHighEmploymentNumber').val(),
					continueEmploymentNumber : $('#continueEmploymentNumber').val(),
					continueEmploymentPercentage : $('#continueEmploymentPercentage').val(),
					attachEmploymentList : 'Y',
					seq : $('#seq').val()
		//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
		//			friendlyMeasures : $('#friendlyMeasures').val(),
		//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
		//			assistanceMeasures : $('#assistanceMeasures').val(),
		//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
		//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					if($('#uploadFile').val() != '')
					{
						let file = new FormData();
						file.append('uploadFile',$('#uploadFile').get(0).files[0]);
						$.confirm({
						    title: '補助名單上傳前確認',
						    animation: 'zoom',
						    closeAnimation: 'scale',
						    content: '提醒您上傳會先清除之前的補助名單',
						    buttons: {
						      確認: function() {
						        $.ajax({
								   	type: 'post',
									url: 'addAdvancedAgeEmploymentListFromFile',// 資料不需要編碼
									enctype: 'multipart/form-data',	   	
									contentType: false,// 資料物件不需要轉換成鍵值對格式
								   	processData: false,
									data: file,
									success: function(res) {
								   	// 判斷是否接收成功
										if(res='success')
										{
									   			location.href='employ_04?seq='+$('#seq').val();
										}
									}
								});
						      },
						      取消: function() {
								$('#loader-container').hide();
						      }
						    }
						  });
					}
					else
					{
						if($('#alreadyExist').html()==undefined)
						{	
							alert('請選擇上傳檔案');
							$('#loader-container').hide();
						}
						else
						{
							location.href='employ_04?seq='+$('#seq').val();
						}
					}
			    },
			    error: function(json){
				    alert(json);
			    }
		    });
			
		}
	}
}