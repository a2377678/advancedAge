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
	
	$('#participate').click(function(){
		$('#participateList').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#participateTable').show();
		$('#participateListTable').hide();
	})
	
	$('#participateList').click(function(){
		$('#participate').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#participateTable').hide();
		$('#participateListTable').show();
	})
	
	$('input[name^="insuranceTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		yearRange: "-100:+0",
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
	
	$('input[name^="executionStartTime"]').datepicker({ 
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
	$('input[name^="executionEndTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#executionStartTime'+$(this).attr('id').replace('executionEndTime','')).val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
	$('input[name^="subject"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$(this).parent().parent('li').find('textarea').attr('required',true);
		}
	});
	
	$('input[name^="subject"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$(this).parent().parent('li').find('textarea').attr('required',true);
		}else{
			if($(this).attr('id')!='subject1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('textarea').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass('error');
				$(this).parent().parent('li').find('select').removeClass('error');
				$(this).parent().parent('li').find('textarea').removeClass('error');
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
	
	$('input[name^="name"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$(this).parent().parent('li').find('input[name^="department"]').attr('required',false);
		}
	});
	
	$('input[name^="name"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$(this).parent().parent('li').find('input[name^="department"]').attr('required',false);
		}else{
			if($(this).attr('id')!='name1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass();
				$(this).parent().parent('li').find('select').removeClass();
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
})

function wordsLimit(e,limitLength){
	let words=$(e).val();
	if(words.length>limitLength){
		$(e).val(words.slice(0,limitLength));
	}
}

function listAdd(){
	maxNum = 1;
	let countli = $('#employedTable ol li').length;
	if (countli > 0) {
		maxNum=Number($('#employedTable').find('li').last().find('input[name^="subject"]').attr('id').replace('subject',''))+1;
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
	      '<div class="">' +
          '<label for="executionStartTime'+maxNum+'">預計執行期間</label>' +
          '<input type="text" class="short-2" id="executionStartTime'+maxNum+'" name="executionStartTime'+maxNum+'" placeholder="yyymmdd" readonly> ~' +
          '<input type="text" class="short-2" id="executionEndTime'+maxNum+'" name="executionEndTime'+maxNum+'" placeholder="yyymmdd" readonly>' +
          '</div>' +
          
		  '<div class="">' +
          '<label for="executionCity'+maxNum+'">計畫執行地</label>' +
          '<select name="executionCity'+maxNum+'" id="executionCity'+maxNum+'">' +
	      '<option value>請選擇</option>' +
	      '<c:forEach  items="${cityList}"  var="cityItem"  varStatus="userStatus">' +
	      '<option value="${cityItem.code}" >${cityItem.name}</option>' +
	      '</c:forEach>' +
	      '</select>' +
          '</div>' +

          '<div class="full">' +
          '<label for="subject'+maxNum+'">課程名稱</label>' +
          '<input type="text" id="subject'+maxNum+'" name="subject'+maxNum+'" placeholder="課程名稱">' +
          '</div>' +
        
		  '<div class="full">' +
          '<label for="introduction'+maxNum+'">課程大綱</label>' +
          '<textarea class="s" rows="2" id="introduction'+maxNum+'" name="introduction'+maxNum+'" onkeyup="wordsLimit(this,100)"  placeholder="課程大綱  ( 輸入框可拖曳加大範圍 )"></textarea>' +
          '</div>' +
			
		  '<div class="">' +
          '<label for="executionTime'+maxNum+'">預計開課時間</label>' +
          '<input type="text" id="executionTime'+maxNum+'" name="executionTime'+maxNum+'" placeholder="00:00~00:00">' +
          '</div>' +

          '<div class="">' +
          '<label for="speakerName'+maxNum+'">講師姓名</label>' +
          '<input type="text" id="speakerName'+maxNum+'" name="speakerName'+maxNum+'" placeholder="講師姓名">' +
          '</div>' +
        
          '<div class="">' +
          '<label for="teachingHours'+maxNum+'">預計授課時數</label>' +
          '<input type="number" id="teachingHours'+maxNum+'" name="teachingHours'+maxNum+'" step="1" min="0">' +
          '</div>' +
        
          '<div class="">' +
          '<label for="participateNumber'+maxNum+'">預計參訓人數</label>' +
          '<input type="number" id="participateNumber'+maxNum+'" name="participateNumber'+maxNum+'" step="1" min="0">' +
          '</div>' +
        
          '<div class="full">' +
          '<label for="participatePeople'+maxNum+'">預計參訓人數</label>' +
		  '<textarea class="s" rows="1" id="participatePeople'+maxNum+'" name="participatePeople'+maxNum+'" placeholder="預計參訓學員  ( 輸入框可拖曳加大範圍 )"></textarea>' +
          '</div>' +
          
          '<div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>' +
          
	        '</li>');
	if(maxNum==1){
		$('#subject1').parent().parent('li').find('input').attr('required',true);
		$('#subject1').parent().parent('li').find('select').attr('required',true);
		$('#subject1').parent().parent('li').find('textarea').attr('required',true);
	}
	$('#executionStartTime'+maxNum).datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        }  
	});
	
	$('#executionEndTime'+maxNum).datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#executionStartTime'+maxNum).val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
	$('#subject'+maxNum).change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$(this).parent().parent('li').find('textarea').attr('required',true);
		}else{
			if($(this).attr('id')!='subject1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('textarea').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass('error');
				$(this).parent().parent('li').find('select').removeClass('error');
				$(this).parent().parent('li').find('textarea').removeClass('error');
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
}

function listSave(){
	let list=[];
	$('#employedTable').find('li').each(function(index,value){
		if($(this).find('input[name^="subject"]').val()!='')
		{
			let data={"executionStartTime" : $(this).find('input[name^="executionStartTime"]').val(),
				"executionEndTime" : $(this).find('input[name^="executionEndTime"]').val(),
				"executionCity" : $(this).find('select[name^="executionCity"]').val(),
				"executionTime" : $(this).find('input[name^="executionTime"]').val(),
				"subject" : $(this).find('input[name^="subject"]').val(),
				"speakerName" : $(this).find('input[name^="speakerName"]').val(),
				"teachingHours" : $(this).find('input[name^="teachingHours"]').val(),
				"participateNumber" : $(this).find('input[name^="participateNumber"]').val(),
				"participatePeople" : $(this).find('textarea[name^="participatePeople"]').val(),
				"introduction" : $(this).find('textarea[name^="introduction"]').val(),
			}
			list.push(data);
		}
	});
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritanceSchedule',
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

function listDelete(e){
	if(confirm('是否確定要移除？'))
	{
		$.ajax({
		    type: "POST",
		    url: 'delRetirementAdvancedAgeExperienceInheritanceSchedule',
		    data: {
				subject : $(e).parent().parent('li').find('input[name^="subject"]').val(),
				executionStartTime : $(e).parent().parent('li').find('input[name^="executionStartTime"]').val(),
				executionEndTime : $(e).parent().parent('li').find('input[name^="executionEndTime"]').val(),
				executionTime : $(e).parent().parent('li').find('input[name^="executionTime"]').val()
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

function listFileUpload(){
	$('#loader-container').show();
	 
	if($('#uploadListFile').val() != '')
	{
		let file = new FormData();
		file.append('uploadFile',$('#uploadListFile').get(0).files[0]);
		$.confirm({
		    title: '上傳前確認',
		    animation: 'zoom',
		    closeAnimation: 'scale',
		    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
		    buttons: {
		      確認: function() {
		        $.ajax({
				   	type: 'post',
					url: 'addRetirementAdvancedAgeExperienceInheritanceScheduleFromFile',// 資料不需要編碼
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
							$('#uploadListFile').val('');
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
	
}

function participateAdd(){
	maxNum = 1;
	let countli = $('#participateTable ol li').length;
	if (countli > 0) {
		maxNum=Number($('#participateTable').find('li').last().find('input[name^="name"]').attr('id').replace('name',''))+1;
	}
	if (countli < 5 && countli != 0) {
		participateAddContent();
	}
	if (countli == 0) {
		maxNum = 1;
		participateAddContent();
	}
}


function participateAddContent() {
		$('#participateTable').find('ol').append('<li>'+
          '<div class="ss">  '+
          '<label for="name'+maxNum+'">學員姓名</label>  '+
          '<input type="text" id="name'+maxNum+'" name="name'+maxNum+'" placeholder="學員姓名">  '+
          '</div>  '+
        
          '<div class="ss">  '+
          '<label for="insuranceType'+maxNum+'">保險類型</label>  '+
          '<select id="insuranceType'+maxNum+'" name="insuranceType'+maxNum+'">  '+
          '  <option value>請選擇</option>  '+
          '  <option value="1">勞工保險</option>  '+
          '  <option value="2">職災保險</option>  '+
          '</select>  '+
          '</div>  '+
        
          '<div class="ss">  '+
          '<label for="insuranceTime'+maxNum+'">加保日期</label>  '+
          '<input type="text" id="insuranceTime'+maxNum+'" name="insuranceTime'+maxNum+'" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')" readonly>  '+
          '</div>  '+
        
          '<div class="ss">  '+
          '<label for="seniority'+maxNum+'">年資</label>  '+
          '<input type="number" step="1" min="0" class="short-3" id="seniority'+maxNum+'" name="seniority'+maxNum+'">年  '+
		  '<input type="number" step="1" min="0" max="12" class="short-3" id="seniorityMonth'+maxNum+'" name="seniorityMonth'+maxNum+'">月  '+
          '</div>  '+
        
          '<div class="ss">  '+
          '<label for="manager'+maxNum+'">職務類型</label>  '+
          '<select id="manager'+maxNum+'" name="manager'+maxNum+'">  '+
          '  <option value>請選擇</option>  '+
          '  <option value="Y">主管</option>  '+
          '  <option value="N">非主管</option>  '+
          '</select>  '+
          '</div>  '+
        
          '<div class="ss">  '+
          '<label for="department'+maxNum+'">部門</label>  '+
          '<input type="text" id="department'+maxNum+'" name="department'+maxNum+'" placeholder=" ( 無則免填 )">  '+
          '</div>  '+
        
          '<div class="ss">  '+
          '<label for="workingHours'+maxNum+'">工時類型</label>  '+
          '<select id="workingHours'+maxNum+'" name="workingHours'+maxNum+'">  '+
          '  <option value>請選擇</option>  '+
          '  <option value="A">全時</option>  '+
          '  <option value="P">部分工時</option>  '+
          '</select> ' +
          '</div> ' +
          
          '<div class="close"><button type="button" class="close" title="移除此筆資料" onclick="participateDelete(this)">X</button></div>' +
          
	        '</li>');
	if(maxNum==1){
		$('#name1').parent().parent('li').find('input').attr('required',true);
		$('#name1').parent().parent('li').find('select').attr('required',true);
		$('input[name^="department"]').attr('required',false);
	}
	$('#insuranceTime'+maxNum).datepicker({ 
		changeMonth: true,
	    changeYear: true,
		yearRange: "-100:+0",
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
	
	$('#name'+maxNum).change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('input[name^="department"]').attr('required',false);
		}else{
			if($(this).attr('id')!='name1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass();
				$(this).parent().parent('li').find('select').removeClass();
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
}

function participateSave(){
	let list=[];
	$('#participateTable').find('li').each(function(index,value){
		if($(this).find('input[name^="name"]').val()!='')
		{
			if($(this).find('select[name^="insuranceType"]').val()==1){
				let data={"name" : $(this).find('input[name^="name"]').val(),
					"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
					"seniority" : $(this).find('input[name^="seniority"]').val(),
					"seniorityMonth" : $(this).find('input[name^="seniorityMonth"]').val(),
					"manager" : $(this).find('select[name^="manager"]').val(),
					"department" : $(this).find('input[name^="department"]').val(),
					"workingHours" : $(this).find('select[name^="workingHours"]').val(),
				}
				list.push(data);
			}else{
				let data={"name" : $(this).find('input[name^="name"]').val(),
					"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
					"seniority" : $(this).find('input[name^="seniority"]').val(),
					"seniorityMonth" : $(this).find('input[name^="seniorityMonth"]').val(),
					"manager" : $(this).find('select[name^="manager"]').val(),
					"department" : $(this).find('input[name^="department"]').val(),
					"workingHours" : $(this).find('select[name^="workingHours"]').val(),
				}
				list.push(data);
			}
		}
	});
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeParticipateStudent',
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

function participateDelete(e){
	if(confirm('是否確定要移除？'))
	{
		$.ajax({
		    type: "POST",
		    url: 'delRetirementAdvancedAgeParticipateStudent',
		    data: {
				name : $(e).parent().parent('li').find('input[name^="name"]').val(),
				seniority : $(e).parent().parent('li').find('input[name^="seniority"]').val(),
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

function participateListFileUpload(){
	$('#loader-container').show();
	 
	if($('#uploadParticipateListFile').val() != '')
	{
		let file = new FormData();
		file.append('uploadFile',$('#uploadParticipateListFile').get(0).files[0]);
		$.confirm({
		    title: '上傳前確認',
		    animation: 'zoom',
		    closeAnimation: 'scale',
		    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
		    buttons: {
		      確認: function() {
		        $.ajax({
				   	type: 'post',
					url: 'addRetirementAdvancedAgeParticipateStudentFromFile',// 資料不需要編碼
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
							$('#uploadParticipateListFile').val('');
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
	
}

function totalSave(){
	
	let list=[],participateList=[];
	$('#employedTable').find('li').each(function(index,value){
		if($(this).find('input[name^="subject"]').val()!='')
		{
			let data={"executionStartTime" : $(this).find('input[name^="executionStartTime"]').val(),
			"executionEndTime" : $(this).find('input[name^="executionEndTime"]').val(),
			"executionCity" : $(this).find('select[name^="executionCity"]').val(),
			"executionTime" : $(this).find('input[name^="executionTime"]').val(),
			"subject" : $(this).find('input[name^="subject"]').val(),
			"speakerName" : $(this).find('input[name^="speakerName"]').val(),
			"teachingHours" : $(this).find('input[name^="teachingHours"]').val(),
			"participateNumber" : $(this).find('input[name^="participateNumber"]').val(),
			"participatePeople" : $(this).find('textarea[name^="participatePeople"]').val(),
			"introduction" : $(this).find('textarea[name^="introduction"]').val(),
			}
			list.push(data);
		}
	});
	
	$('#participateTable').find('li').each(function(index,value){
		if($(this).find('input[name^="name"]').val()!='')
		{
			if($(this).find('select[name^="insuranceType"]').val()==1){
				let data={"name" : $(this).find('input[name^="name"]').val(),
					"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
					"seniority" : $(this).find('input[name^="seniority"]').val(),
					"seniorityMonth" : $(this).find('input[name^="seniorityMonth"]').val(),
					"manager" : $(this).find('select[name^="manager"]').val(),
					"department" : $(this).find('input[name^="department"]').val(),
					"workingHours" : $(this).find('select[name^="workingHours"]').val(),
				}
				participateList.push(data);
			}else{
				let data={"name" : $(this).find('input[name^="name"]').val(),
					"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
					"seniority" : $(this).find('input[name^="seniority"]').val(),
					"seniorityMonth" : $(this).find('input[name^="seniorityMonth"]').val(),
					"manager" : $(this).find('select[name^="manager"]').val(),
					"department" : $(this).find('input[name^="department"]').val(),
					"workingHours" : $(this).find('select[name^="workingHours"]').val(),
				}
				participateList.push(data);
			}
		}
	});
	
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritanceSchedule',
	    data: JSON.stringify(list),
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		contentType:"application/json",
	    success: function(json){  
			if(json=='success')
			{
				$.ajax({
				    type: "POST",
				    url: 'addRetirementAdvancedAgeParticipateStudent',
				    data: JSON.stringify(participateList),
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
	    }
    });
	
}

function next(){
	if($('#listForm').valid() && $('#participateListForm').valid()){
		let list=[],participateList=[];
		$('#employedTable').find('li').each(function(index,value){
			if($(this).find('input[name^="subject"]').val()!='')
			{
				let data={"executionStartTime" : $(this).find('input[name^="executionStartTime"]').val(),
				"executionEndTime" : $(this).find('input[name^="executionEndTime"]').val(),
				"executionCity" : $(this).find('select[name^="executionCity"]').val(),
				"executionTime" : $(this).find('input[name^="executionTime"]').val(),
				"subject" : $(this).find('input[name^="subject"]').val(),
				"speakerName" : $(this).find('input[name^="speakerName"]').val(),
				"teachingHours" : $(this).find('input[name^="teachingHours"]').val(),
				"participateNumber" : $(this).find('input[name^="participateNumber"]').val(),
				"participatePeople" : $(this).find('textarea[name^="participatePeople"]').val(),
				"introduction" : $(this).find('textarea[name^="introduction"]').val(),
				}
				list.push(data);
			}
		});
		
		$('#participateTable').find('li').each(function(index,value){
			if($(this).find('input[name^="name"]').val()!='')
			{
				if($(this).find('select[name^="insuranceType"]').val()==1){
					let data={"name" : $(this).find('input[name^="name"]').val(),
						"laborProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
						"seniority" : $(this).find('input[name^="seniority"]').val(),
						"seniorityMonth" : $(this).find('input[name^="seniorityMonth"]').val(),
						"manager" : $(this).find('select[name^="manager"]').val(),
						"department" : $(this).find('input[name^="department"]').val(),
						"workingHours" : $(this).find('select[name^="workingHours"]').val(),
					}
					participateList.push(data);
				}else{
					let data={"name" : $(this).find('input[name^="name"]').val(),
						"occupationalAccidentProtectionTime" : $(this).find('input[name^="insuranceTime"]').val(),
						"seniority" : $(this).find('input[name^="seniority"]').val(),
						"seniorityMonth" : $(this).find('input[name^="seniorityMonth"]').val(),
						"manager" : $(this).find('select[name^="manager"]').val(),
						"department" : $(this).find('input[name^="department"]').val(),
						"workingHours" : $(this).find('select[name^="workingHours"]').val(),
					}
					participateList.push(data);
				}
			}
		});
		
		$.ajax({
		    type: "POST",
		    url: 'addRetirementAdvancedAgeExperienceInheritanceSchedule',
		    data: JSON.stringify(list),
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			contentType:"application/json",
		    success: function(json){  
				if(json=='success')
				{
					$.ajax({
					    type: "POST",
					    url: 'addRetirementAdvancedAgeParticipateStudent',
					    data: JSON.stringify(participateList),
					    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
						contentType:"application/json",
					    success: function(json){  
							if(json=='success')
							{
								location.href='teach_05';
							}
					    }
				    });
				}
		    }
	    });
	}
}