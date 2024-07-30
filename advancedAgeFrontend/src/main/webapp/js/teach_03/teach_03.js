$(function(){
	$.datepicker.regional['zh-TW']={
   dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
   dayNamesMin:["日","一","二","三","四","五","六"],
   monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
   monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
   prevText:"上月",
   nextText:"次月",
   weekHeader:"週"
};
	$.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
	$('#employed').click(function(){
		$('#list').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').show();
		$('#listTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#listTable').show();
	})
	
	$('#planStartTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	let startDate;
	$('#planEndTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#planStartTime').val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	$('input[name^="insuranceTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        }  
	});
	
	$('input[name^="birthday"]').datepicker({ 
		changeMonth: true,
		yearRange: "-100:+0",
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
			dateText = dateText - 19110000;
            if(dateText.toString().length==6){
				dateText = '0'+dateText.toString().substr(0, 2) + dateText.toString().substr(2, 2) + dateText.toString().substr(4);
			}else if(dateText.toString().length==7){
            	dateText = dateText.toString().substr(0, 3)+ dateText.toString().substr(3, 2) + dateText.toString().substr(5);
			}
            $(this).val(dateText);
        }  
	});
	
	$('input[name^="identification"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
		}
	});
	
	$('input[name^="identification"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
		}else
		{
			if($(this).attr('id')!='identification1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass();
				$(this).parent().parent('li').find('select').removeClass();
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
	
	if($('#list').find('a').attr('class') != '' && $('#list').find('a').attr('class') != undefined)
	{
		$('#employedTable').hide();
		$('#listTable').show();
	}
	
	$('#highEmploymentNumber').change(function(){
		$('#employmentNumber').val(Number($(this).val())+Number($('#middleEmploymentNumber').val())+Number($('#lowEmploymentNumber').val())+Number($('#lowerEmploymentNumber').val()));
	})
	
	$('#middleEmploymentNumber').change(function(){
		$('#employmentNumber').val(Number($(this).val())+Number($('#highEmploymentNumber').val())+Number($('#lowEmploymentNumber').val())+Number($('#lowerEmploymentNumber').val()));
	})
	
	$('#lowEmploymentNumber').change(function(){
		$('#employmentNumber').val(Number($(this).val())+Number($('#highEmploymentNumber').val())+Number($('#middleEmploymentNumber').val())+Number($('#lowerEmploymentNumber').val()));
	})
	
	$('#lowerEmploymentNumber').change(function(){
		$('#employmentNumber').val(Number($(this).val())+Number($('#highEmploymentNumber').val())+Number($('#middleEmploymentNumber').val())+Number($('#lowEmploymentNumber').val()));
	})
	
})

function wordsLimit(e,limitLength){
	let words=$(e).val();
	if(words.length>limitLength){
		$(e).val(words.slice(0,limitLength));
	}
}

function planSave(){
	let executionWay_bind='';
	$('input[name^="executionWay"]:checked').each(function(){
		if(executionWay_bind=='')
		{	
			executionWay_bind=$(this).val();
		}else{
			executionWay_bind=executionWay_bind+'、'+$(this).val();
		}
	})
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
	    data: {
			items : $('#items').val(),
			friendlyMeasures : $('#friendlyMeasures').val(),
	    	employmentNumber : $('#employmentNumber').val(),
			lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
			lowEmploymentNumber : $('#lowEmploymentNumber').val(),
			middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
			highEmploymentNumber : $('#highEmploymentNumber').val(),
			retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
			planDescription : $('#planDescription').val(),
			executionWay : executionWay_bind,
			executionWayDescription : $('#executionWayDescription').val(),
			planStartTime : $('#planStartTime').val(),
			planEndTime : $('#planEndTime').val(),
			experienceInheritance : $('#experienceInheritance').val(),
			participate : $('#participate').val(),
			benefit : $('#benefit').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success')
			{
		   		alert('資料已暫存');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}
function listAdd(){
	maxNum = 1;
	let countli = $('#employedTable ol li').length;
	if (countli > 0) {
		maxNum=Number($('#employedTable').find('li').last().find('input[name^="name"]').attr('id').replace('name',''))+1;
	}
	if (countli < 5 && countli != 0) {
		listAddContent();
	}
	if (countli == 0) {
		maxNum = 1;
		listAddContent();
	}
}

function listAddContent() {
	
		$('#employedTable').find('ol').append('<li>'+
	          '<div class="ss">'+
	          '<label for="name'+maxNum+'">勞工姓名</label>  '+
	          '<input type="text" id="name'+maxNum+'" name="name'+maxNum+'">'+
	          '</div>'+

			  '<div class="ss">'+
	          '<label for="name'+maxNum+'">出生日期</label>  '+
	          '<input type="text" id="birthday'+maxNum+'" name="birthday'+maxNum+'" placeholder="yyymmdd" readonly>'+
	          '</div>'+

	          '<div class="ss">'+
	          '<label for="identification'+maxNum+'">身分證字號</label>  '+
	          '<input type="text" id="identification'+maxNum+'" name="identification'+maxNum+'">'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="insuranceType'+maxNum+'">保險類型</label>  '+
	          '<select id="insuranceType'+maxNum+'" name="insuranceType'+maxNum+'">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="1">勞工保險</option>'+
	          '  <option value="2">職災保險</option>'+
	          '</select>'+
	          '</div>'+
	          '<div class="ss">'+
	          '<label for="insuranceTime'+maxNum+'">加保日期</label>  '+
	          '<input type="text" id="insuranceTime'+maxNum+'" name="insuranceTime'+maxNum+'" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')" readonly>'+
	          '</div>'+
			  '<div class="ss">'+
	          '<label for="manager'+maxNum+'">職務類型</label> '+
	          '<select id="manager'+maxNum+'" name="manager'+maxNum+'">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="Y">主管</option>'+
	          '  <option value="N">非主管</option>'+
	          '</select>'+
	          '</div>'+
	        
	          '<div class="ss">'+
	          '<label for="relatives'+maxNum+'">親等關係</label> '+
	          '<select id="relatives'+maxNum+'" name="relatives'+maxNum+'">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="N">非三親等</option>'+
	          '  <option value="Y">三親等內</option>'+
	          '</select>'+
	          '<img src="images/icon_qu.png" class="icon_qu"'+
	          'title="【三親等內】之親屬包含：'+
	'配偶、父母、子女、兄弟姊妹、'+
	'(外)祖父母、(外)孫子女、'+
	'伯、叔、姑、舅、姨、'+
	'姪子(女)、外甥(女)、'+
	'(外)曾祖父母、(外)曾孫子女">'+
	          '</div>'+
	        
	          '<div class="ss">'+
	          '<label for="workingHours'+maxNum+'">工時類型</label> '+
	          '<select id="workingHours'+maxNum+'" name="workingHours'+maxNum+'">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="A">全時</option>'+
	          '  <option value="P">部分工時</option>'+
	          '</select>'+
	          '</div>'+
	        
	          '<div class="ss">'+
	          '<label for="executionWay'+maxNum+'">計畫執行</label> '+
	          '<select id="executionWay'+maxNum+'" name="executionWay'+maxNum+'">'+
	          '  <option value>請選擇</option>'+
	          '  <option value="C">教育訓練課程講授</option>'+
	          '  <option value="S">實務技術指導</option>'+
	          '</select>'+
	          '</div>'+
	          '<div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>'+
	        '</li>');
		if(maxNum==1){
			$('#identification1').parent().parent('li').find('input').attr('required',true);
			$('#identification1').parent().parent('li').find('select').attr('required',true);
		}
		$('input[name^="identification"]').change(function(){
			if($(this).val().length>0)
			{
				$(this).parent().parent('li').find('input').attr('required',true);
				$(this).parent().parent('li').find('select').attr('required',true);
			}
			else
			{
				if($(this).attr('id')!='identification1'){
					$(this).parent().parent('li').find('input').attr('required',false);
					$(this).parent().parent('li').find('select').attr('required',false);
					$(this).parent().parent('li').find('input').removeClass();
					$(this).parent().parent('li').find('select').removeClass();
					$(this).parent().parent('li').find('label.error').remove();
				}
			}
		});
	$('#insuranceTime'+maxNum).datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        }  
	});
	
	$('#birthday'+maxNum).datepicker({ 
		changeMonth: true,
		yearRange: "-100:+0",
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            if(dateText.toString().length==6){
				dateText = '0'+dateText.toString().substr(0, 2) + dateText.toString().substr(2, 2) + dateText.toString().substr(4);
			}else if(dateText.toString().length==7){
            	dateText = dateText.toString().substr(0, 3)+ dateText.toString().substr(3, 2) + dateText.toString().substr(5);
			}
            $(this).val(dateText);
        }  
	});
}

function listDelete(e){
	if(confirm('是否確定要移除？'))
	{
		$.ajax({
		    type: "POST",
		    url: 'delExperienceInheritanceSpeakerList',
		    data: {
				identification : $(e).parent().parent('li').find('input[name^="identification"]').val()
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){
				if(json=='success'){
					$(e).parent().parent().remove();
				}
			}
		});
	}
}

function listSave(){
	let executionWay_bind='';
	$('input[name^="executionWay"]:checked').each(function(){
		if(executionWay_bind=='')
		{	
			executionWay_bind=$(this).val();
		}else{
			executionWay_bind=executionWay_bind+'、'+$(this).val();
		}
	})
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
	    data: {
			items : $('#items').val(),
			friendlyMeasures : $('#friendlyMeasures').val(),
	    	employmentNumber : $('#employmentNumber').val(),
			lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
			lowEmploymentNumber : $('#lowEmploymentNumber').val(),
			middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
			highEmploymentNumber : $('#highEmploymentNumber').val(),
			retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
			planDescription : $('#planDescription').val(),
			executionWay : executionWay_bind,
			executionWayDescription : $('#executionWayDescription').val(),
			planStartTime : $('#planStartTime').val(),
			planEndTime : $('#planEndTime').val(),
			experienceInheritance : $('#experienceInheritance').val(),
			participate : $('#participate').val(),
			benefit : $('#benefit').val(),
			attachSpeakerList : 'N',
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
		   		let list=[];
				$('#employedTable').find('li').each(function(index,value){
					if($(this).find('input[name^="identification"]').val()!='')
					{
						if($(this).find('select[name^="insuranceType"]').val()==1){
							let data={"name" : $(this).find('input[name^="name"]').val(),
								"birthday" : $(this).find('input[name^="birthday"]').val(),
								"identification" : $(this).find('input[name^="identification"]').val(),
								"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
								"manager" : $(this).find('select[name^="manager"]').val(),
								"relatives" : $(this).find('select[name^="relatives"]').val(),
								"workingHours" : $(this).find('select[name^="workingHours"]').val(),
								"executionWay" : $(this).find('select[name^="executionWay"]').val()
							}
							list.push(data);
						}
						else
						{
							let data={"name" : $(this).find('input[name^="name"]').val(),
								"birthday" : $(this).find('input[name^="birthday"]').val(),
								"identification" : $(this).find('input[name^="identification"]').val(),
								"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
								"manager" : $(this).find('select[name^="manager"]').val(),
								"relatives" : $(this).find('select[name^="relatives"]').val(),
								"workingHours" : $(this).find('select[name^="workingHours"]').val(),
								"executionWay" : $(this).find('select[name^="executionWay"]').val()
							}
							list.push(data);
						}
					}
				});
				$.ajax({
				    type: "POST",
				    url: 'addExperienceInheritanceSpeakerList',
				    data: JSON.stringify(list),
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
					contentType:"application/json",
				    success: function(json){  
						if(json=='success')
						{
							alert('資料已暫存');
							window.location.reload();
						}
				    }
			    });
			}
			
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function fileUpload(){
	$('#loader-container').show();
	let executionWay_bind='';
	$('input[name^="executionWay"]:checked').each(function(){
		if(executionWay_bind=='')
		{	
			executionWay_bind=$(this).val();
		}else{
			executionWay_bind=executionWay_bind+'、'+$(this).val();
		}
	})
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
	    data: {
			items : $('#items').val(),
			friendlyMeasures : $('#friendlyMeasures').val(),
	    	employmentNumber : $('#employmentNumber').val(),
			lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
			lowEmploymentNumber : $('#lowEmploymentNumber').val(),
			middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
			highEmploymentNumber : $('#highEmploymentNumber').val(),
			retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
			planDescription : $('#planDescription').val(),
			executionWay : executionWay_bind,
			executionWayDescription : $('#executionWayDescription').val(),
			planStartTime : $('#planStartTime').val(),
			planEndTime : $('#planEndTime').val(),
			experienceInheritance : $('#experienceInheritance').val(),
			participate : $('#participate').val(),
			benefit : $('#benefit').val(),
			attachSpeakerList : 'Y',
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if($('#uploadFile').val() != '')
			{
				let file = new FormData();
				file.append('uploadFile',$('#uploadFile').get(0).files[0]);
				$.confirm({
				    title: '上傳前確認',
				    animation: 'zoom',
				    closeAnimation: 'scale',
				    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
				    buttons: {
				      確認: function() {
				        $.ajax({
						   	type: 'post',
							url: 'addExperienceInheritanceSpeakerListFromFile',// 資料不需要編碼
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
									alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
									$('#uploadFile').val('');
									$('#loader-container').hide();
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
				$('#loader-container').hide();
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
	
}

function totalSave(){
	$('#loader-container').show();
	if($('#employed').find('a').attr('class')!='' && $('#employed').find('a').attr('class')!=undefined)
	{
		let executionWay_bind='';
		$('input[name^="executionWay"]:checked').each(function(){
			if(executionWay_bind=='')
			{	
				executionWay_bind=$(this).val();
			}else{
				executionWay_bind=executionWay_bind+'、'+$(this).val();
			}
		})
		$.ajax({
		    type: "POST",
		    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
		    data: {
				items : $('#items').val(),
				friendlyMeasures : $('#friendlyMeasures').val(),
		    	employmentNumber : $('#employmentNumber').val(),
				lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
				lowEmploymentNumber : $('#lowEmploymentNumber').val(),
				middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
				highEmploymentNumber : $('#highEmploymentNumber').val(),
				retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
				planDescription : $('#planDescription').val(),
				executionWay : executionWay_bind,
				executionWayDescription : $('#executionWayDescription').val(),
				planStartTime : $('#planStartTime').val(),
				planEndTime : $('#planEndTime').val(),
				experienceInheritance : $('#experienceInheritance').val(),
				participate : $('#participate').val(),
				benefit : $('#benefit').val(),
				attachSpeakerList : 'N'
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
					let list=[];
					$('#employedTable').find('li').each(function(index,value){
						if($(this).find('input[name^="identification"]').val()!='')
						{
							if($(this).find('select[name^="insuranceType"]').val()==1){
								let data={"name" : $(this).find('input[name^="name"]').val(),
									"birthday" : $(this).find('input[name^="birthday"]').val(),
									"identification" : $(this).find('input[name^="identification"]').val(),
									"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
									"manager" : $(this).find('select[name^="manager"]').val(),
									"relatives" : $(this).find('select[name^="relatives"]').val(),
									"workingHours" : $(this).find('select[name^="workingHours"]').val(),
									"executionWay" : $(this).find('select[name^="executionWay"]').val()
								}
								list.push(data);
							}
							else
							{
								let data={"name" : $(this).find('input[name^="name"]').val(),
									"birthday" : $(this).find('input[name^="birthday"]').val(),
									"identification" : $(this).find('input[name^="identification"]').val(),
									"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
									"manager" : $(this).find('select[name^="manager"]').val(),
									"relatives" : $(this).find('select[name^="relatives"]').val(),
									"workingHours" : $(this).find('select[name^="workingHours"]').val(),
									"executionWay" : $(this).find('select[name^="executionWay"]').val()
								}
								list.push(data);
							}
						}
					});
					$.ajax({
					    type: "POST",
					    url: 'addExperienceInheritanceSpeakerList',
					    data: JSON.stringify(list),
					    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
						contentType:"application/json",
					    success: function(json){  
							if(json=='success')
							{
								alert('資料已暫存');
								window.location.reload();
							}
					    }
				    });
				
		    },
		    error: function(json){
			    alert(json);
				$('#loader-container').hide();
		    }
	    });
		
	}
	else
	{
		let executionWay_bind='';
		$('input[name^="executionWay"]:checked').each(function(){
			if(executionWay_bind=='')
			{	
				executionWay_bind=$(this).val();
			}else{
				executionWay_bind=executionWay_bind+'、'+$(this).val();
			}
		})
		$.ajax({
		    type: "POST",
		    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
		    data: {
				items : $('#items').val(),
				friendlyMeasures : $('#friendlyMeasures').val(),
		    	employmentNumber : $('#employmentNumber').val(),
				lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
				lowEmploymentNumber : $('#lowEmploymentNumber').val(),
				middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
				highEmploymentNumber : $('#highEmploymentNumber').val(),
				retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
				planDescription : $('#planDescription').val(),
				executionWay : executionWay_bind,
				executionWayDescription : $('#executionWayDescription').val(),
				planStartTime : $('#planStartTime').val(),
				planEndTime : $('#planEndTime').val(),
				experienceInheritance : $('#experienceInheritance').val(),
				participate : $('#participate').val(),
				benefit : $('#benefit').val(),
				attachSpeakerList : 'Y',
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if($('#uploadFile').val() != '')
				{
					let file = new FormData();
					file.append('uploadFile',$('#uploadFile').get(0).files[0]);
					$.confirm({
					    title: '上傳前確認',
					    animation: 'zoom',
					    closeAnimation: 'scale',
					    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
					    buttons: {
					      確認: function() {
					        $.ajax({
							   	type: 'post',
								url: 'addExperienceInheritanceSpeakerListFromFile',// 資料不需要編碼
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
										alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
										$('#uploadFile').val('');
										$('#loader-container').hide();
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
		    }
	    });
	}
}
function next(){
	if($('#form_step1').valid() && $('#form_step2').valid() && $('#listForm').valid()){
		if($('#employed').find('a').attr('class')!='' && $('#employed').find('a').attr('class')!=undefined)
		{
			let executionWay_bind='';
			$('input[name^="executionWay"]:checked').each(function(){
				if(executionWay_bind=='')
				{	
					executionWay_bind=$(this).val();
				}else{
					executionWay_bind=executionWay_bind+'、'+$(this).val();
				}
			})
			$.ajax({
			    type: "POST",
			    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
			    data: {
					items : $('#items').val(),
					friendlyMeasures : $('#friendlyMeasures').val(),
			    	employmentNumber : $('#employmentNumber').val(),
					lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
					lowEmploymentNumber : $('#lowEmploymentNumber').val(),
					middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
					highEmploymentNumber : $('#highEmploymentNumber').val(),
					retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
					planDescription : $('#planDescription').val(),
					executionWay : executionWay_bind,
					executionWayDescription : $('#executionWayDescription').val(),
					planStartTime : $('#planStartTime').val(),
					planEndTime : $('#planEndTime').val(),
					experienceInheritance : $('#experienceInheritance').val(),
					participate : $('#participate').val(),
					benefit : $('#benefit').val(),
					attachSpeakerList : 'N'
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					let list=[];
					$('#employedTable').find('li').each(function(index,value){
						if($(this).find('input[name^="identification"]').val()!='')
						{
							if($(this).find('select[name^="insuranceType"]').val()==1){
								let data={"name" : $(this).find('input[name^="name"]').val(),
									"birthday" : $(this).find('input[name^="birthday"]').val(),
									"identification" : $(this).find('input[name^="identification"]').val(),
									"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
									"manager" : $(this).find('select[name^="manager"]').val(),
									"relatives" : $(this).find('select[name^="relatives"]').val(),
									"workingHours" : $(this).find('select[name^="workingHours"]').val(),
									"executionWay" : $(this).find('select[name^="executionWay"]').val()
								}
								list.push(data);
							}
							else
							{
								let data={"name" : $(this).find('input[name^="name"]').val(),
									"birthday" : $(this).find('input[name^="birthday"]').val(),
									"identification" : $(this).find('input[name^="identification"]').val(),
									"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
									"manager" : $(this).find('select[name^="manager"]').val(),
									"relatives" : $(this).find('select[name^="relatives"]').val(),
									"workingHours" : $(this).find('select[name^="workingHours"]').val(),
									"executionWay" : $(this).find('select[name^="executionWay"]').val()
								}
								list.push(data);
							}
						}
					});
					$.ajax({
					    type: "POST",
					    url: 'addExperienceInheritanceSpeakerList',
					    data: JSON.stringify(list),
					    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
						contentType:"application/json",
					    success: function(json){  
							if(json=='success')
							{
								location.href='teach_04';
							}
					    }
				    });
			    },
			    error: function(json){
				    alert(json);
					$('#loader-container').hide();
			    }
		    });
			
		}
		else{
			let executionWay_bind='';
			$('input[name^="executionWay"]:checked').each(function(){
				if(executionWay_bind=='')
				{	
					executionWay_bind=$(this).val();
				}else{
					executionWay_bind=executionWay_bind+'、'+$(this).val();
				}
			})
			$.ajax({
			    type: "POST",
			    url: 'addRetirementAdvancedAgeExperienceInheritancePlan',
			    data: {
					items : $('#items').val(),
					friendlyMeasures : $('#friendlyMeasures').val(),
			    	employmentNumber : $('#employmentNumber').val(),
					lowerEmploymentNumber :	$('#lowerEmploymentNumber').val(),
					lowEmploymentNumber : $('#lowEmploymentNumber').val(),
					middleEmploymentNumber : $('#middleEmploymentNumber').val(), 
					highEmploymentNumber : $('#highEmploymentNumber').val(),
					retirementEmploymentNumber : $('#retirementEmploymentNumber').val(),
					planDescription : $('#planDescription').val(),
					executionWay : executionWay_bind,
					executionWayDescription : $('#executionWayDescription').val(),
					planStartTime : $('#planStartTime').val(),
					planEndTime : $('#planEndTime').val(),
					experienceInheritance : $('#experienceInheritance').val(),
					participate : $('#participate').val(),
					benefit : $('#benefit').val(),
					attachSpeakerList : 'Y',
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					if($('#uploadFile').val() != '')
					{
						let file = new FormData();
						file.append('uploadFile',$('#uploadFile').get(0).files[0]);
						$.confirm({
						    title: '上傳前確認',
						    animation: 'zoom',
						    closeAnimation: 'scale',
						    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
						    buttons: {
						      確認: function() {
						        $.ajax({
								   	type: 'post',
									url: 'addExperienceInheritanceSpeakerListFromFile',// 資料不需要編碼
									enctype: 'multipart/form-data',	   	
									contentType: false,// 資料物件不需要轉換成鍵值對格式
								   	processData: false,
									data: file,
									success: function(res) {
								   	// 判斷是否接收成功
										if(res=='success')
										{
									   		location.href='teach_04';
										}else{
											alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
											$('#uploadFile').val('');
											$('#loader-container').hide();
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
							location.href='teach_04';
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
}