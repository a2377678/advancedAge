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
	$('#listForm').validate();
	$('input[name^="employmentStartTime"]').datepicker({ 
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
	$('input[name^="employmentEndTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#employmentStartTime'+$(this).attr('id').replace('employmentEndTime','')).val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
	$('input[name^="birthday"]').datepicker({ 
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
	
	$('input[name^="count"]').change(function(){
		if($(this).parent().parent().find('select[name^="frequency"]').val()==1){
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*13000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*70));
			}
		}else{
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*15000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*80));
			}
		}
	});
	
	$('button.add').click(function(){
		if($(this).html()=="－")
		{
			$(this).parent().parent().find('.add').show();
			$(this).parent().remove();
		}
	})	
	
	$('input[name^="identification"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
		}else{
			if($(this).attr('id')!='identification1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass('error');
				$(this).parent().parent('li').find('select').removeClass('error');
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	})
	$('input[name^="identification"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
		}
	})
	
	$('#baseId').change(function(){
		$('#baseAllowanceFrequencyTime').val(0);
		$('#searchForm').submit();
	})
})
function showNewSalaryType(num){
	$('#employedTable'+num).find('.add').hide();
	$('#employedTable'+num).find('div.close').before('<div class="m patmant" id="employedTable'+num+'2"> '+
            '<label for="salaryType'+num+'2">請領補助 </label> '+
            '<select id="salaryType'+num+'2" name="salaryType'+num+'2" required> '+
              '<option value>請選擇</option> '+
              '<option value="M">按月計</option> '+
              '<option value="H">按時計</option> '+
            '</select> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【按月計酬】\n '+
' 第1-6個月每人每月補助 13,000 元。\n '+
' 第7-18個月每人每月補助 15,000 元。\n\n '+
'【非按月計酬】\n '+
' 第1-6個月每人每小時補助 70 元，\n '+
' 每月最高補助 13,000 元。\n '+
' 第7-18個月每人每小時補助 80 元，\n '+
' 每月最高補有 15,000 元。">\n '+
            '<label for="">申請期間 </label> '+
           	'<input type="text" class="short-2" id="employmentStartTime'+num+'2" name="employmentStartTime'+num+'2" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')" required readonly> 至  '+
            '<input type="text" class="short-2" id="employmentEndTime'+num+'2" name="employmentEndTime'+num+'2" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')>" required readonly> '+
            '<label for="">月數 / 時數 </label> '+
            '<input type="number" class="short" step="1" min="0" id="count'+num+'2" name="count'+num+'2" required> '+
            '<label for="">請領金額 </label> '+
            '<input type="text" id="amounts'+num+'2" name="amounts'+num+'2" class="readonly" placeholder="自動計算" readonly> '+
            '<button type="button" class="add">－</button> '+
          '</div>');
	$('#employedTable'+num+'2').find('.add').click(function(){
		$('#employedTable'+num+'2').parent().find('.add').show();
		$('#employedTable'+num+'2').remove();
	})	
	
	$('input[name^="count"]').change(function(){
		
		if($(this).parent().parent().find('select[name^="frequency"]').val()==1){
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*13000);
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*70);
			}
		}else{
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*15000);
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*80);
			}
		}
	})
	
	$('#employmentStartTime'+num+'2').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        }  
	});
	
	$('#employmentEndTime'+num+'2').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#employmentStartTime'+$(this).attr('id').replace('employmentEndTime','')).val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
}

function listAdd(){
		maxNum = 1;
	let countli = $('#employedTable ol li').length;
	if (countli > 0) {
		maxNum = Number($('#employedTable').find('li').last().find('input[name^="name"]').attr('id').replace('name', '')) + 1;
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
	$('#employedTable').find('ol').append('<li id="employedTable'+maxNum+'"> '+
          '<div class="ss"> '+
          '<label for="name'+maxNum+'">勞工姓名</label> '+
		  '<input type="text" id="name'+maxNum+'" name="name'+maxNum+'"> '+
          '</div> '+
          
		  '<div class="ss"> '+
          '<label for="birthday'+maxNum+'">出生日期</label> '+
          '<input type="text" id="birthday'+maxNum+'" name="birthday'+maxNum+'" placeholder="yyymmdd" readonly readonly> '+
          '</div> '+

          '<div class="ss"> '+
          '<label for="identification'+maxNum+'">身分證字號</label> '+
          '<input type="text" id="identification'+maxNum+'" name="identification'+maxNum+'" maxlength="10"> '+
          '</div> '+
        
          '<div class="ss"> '+
            '<label for="salary'+maxNum+'">本期請領<br>平均薪資</label> '+
            '<input type="text" id="salary'+maxNum+'" name="salary'+maxNum+'" placeholder="每月平均薪資" pattern="[0-9]*"> '+
          '</div> '+
          
          '<div class="ss"> '+
          '<label for="insuranceType'+maxNum+'">退保(離職)</label> '+
          '<select id="insuranceType'+maxNum+'" name="insuranceType'+maxNum+'"> '+
            '<option value>請選擇</option> '+
            '<option value="1">勞工保險</option> '+
            '<option value="2">職災保險</option> '+
          '</select> '+
          '<img src="images/icon_qu.png" class="icon_qu" title="仍加保中免填"> '+
          '</div> '+
        
          '<div class="ss"> '+
          '<label for="insuranceTime'+maxNum+'">退保日期</label> '+
          '<input type="text" id="insuranceTime'+maxNum+'" name="insuranceTime'+maxNum+'" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')" readonly readonly> '+
          '</div> '+
        
          '<div class="m"> '+
            '<label for="salaryMethod'+maxNum+'">計薪方式 '+
            '</label> '+
            '<select id="salaryMethod'+maxNum+'" name="salaryMethod'+maxNum+'"> '+
              '<option value>請選擇</option> '+
              '<option value="M">按月計</option> '+
              '<option value="H">非按月</option> '+
              '<option value="MH">部分按月，部分非按月</option> '+
            '</select> '+
            '<input type="text" class="w-50" id="salaryMethodRemark'+maxNum+'" name="salaryMethodRemark'+maxNum+'" placeholder="例：7月95小時, 8月106小時..."> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【按月計】免填備註\n '+
'【非按月】請敘明每月時數\n'+
' 如：7月95小時, 8月106小時..."> '+
          '</div> '+
        
          '<div class="ss"> '+
          '<label for="frequency'+maxNum+'">請領期數</label> '+
          '<select id="frequency'+maxNum+'" name="frequency'+maxNum+'"> '+
            '<option value>請選擇</option> '+
            '<option value="1">第1期</option> '+
            '<option value="2">第2期</option> '+
            '<option value="3">第3期</option> '+
            '<option value="4">第4期</option> '+
            '<option value="5">第5期</option> '+
          '</select> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【第1期】請領期間為前6個月\n '+
'，未滿6個月不予發給。\n\n '+
'【第2~5期】請領申請期間，\n '+
'為第7~18個月，最長12個月。"> '+
          '</div> '+
        
          '<div class="px-4">（以下請領若有2種計薪方式，請按右方 <kbd>+</kbd> 按鈕增加欄位）</div> '+ 

          '<div class="m patmant"> '+
            '<label for="salaryType'+maxNum+'1">請領補助</label> '+
            '<select id="salaryType'+maxNum+'1" name="salaryType'+maxNum+'1"> '+
              '<option value>請選擇</option> '+
              '<option value="M">按月計</option> '+
              '<option value="H">按時計</option> '+
            '</select> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【按月計酬】\n '+
'第1-6個月每人每月補助 13,000 元。\n '+
'第7-18個月每人每月補助 15,000 元。\n\n '+
'【非按月計酬】\n '+
'第1-6個月每人每小時補助 70 元，\n '+
'每月最高補助 13,000 元。\n '+
'第7-18個月每人每小時補助 80 元，\n '+
'每月最高補有 15,000 元。"> '+

            '<label for="">申請期間</label> '+
            '<input type="text" class="short-2" id="employmentStartTime'+maxNum+'1" name="employmentStartTime'+maxNum+'1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\') " readonly> 至 '+
            '<input type="text" class="short-2" id="employmentEndTime'+maxNum+'1" name="employmentEndTime'+maxNum+'1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')" readonly> '+

            '<label for="">月數 / 時數</label> '+
            '<input type="number" class="short" step="1" min="0" id="count'+maxNum+'1" name="count'+maxNum+'1"> '+
            '<label for="">請領金額</label> '+
            '<input type="text" id="amounts'+maxNum+'1" name="amounts'+maxNum+'1" class="readonly" placeholder="自動計算" readonly> '+
            '<button type="button" class="add" onclick="showNewSalaryType('+maxNum+')">＋</button> '+
          '</div> '+
          
          '<div class="close"><button type="button" onclick="delEmploymentList(this);" class="close" title="移除此筆資料">X</button></li>');

	if(maxNum==1){
		$('#identification1').parent().parent('li').find('input').attr('required',true);
		$('#identification1').parent().parent('li').find('select').attr('required',true);
		$('select[name^="insuranceType"]').attr('required',false);
		$('input[name^="insuranceTime"]').attr('required',false);
		$('input[name^="salaryMethodRemark"]').attr('required',false);
	}
	$('input[name^="count"]').change(function(){
		if($(this).parent().parent().find('select[name^="frequency"]').val()==1){
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*13000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*70));
			}
		}else{
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*15000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*80));
			}
		}
	});
	
	$('input[name="birthday'+maxNum+'"]').datepicker({ 
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
	
	$('input[name="insuranceTime'+maxNum+'"]').datepicker({ 
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
	
	$('input[name^="employmentStartTime'+maxNum+'1"]').datepicker({ 
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
	$('input[name^="employmentEndTime'+maxNum+'1"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#employmentStartTime'+$(this).attr('id').replace('employmentEndTime','')).val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + dateText.toString().substr(3, 2) + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
	$('input[name^="identification"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
		}
		else
		{
			if($(this).attr('id')!='identification1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('select').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass('error');
				$(this).parent().parent('li').find('select').removeClass('error');
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
}

function delEmploymentList(item){
	if(confirm('是否確定要移除？'))
	{
		let path=$(item).parent().parent('li');
		$.ajax({
		    type: "POST",
		    url: 'delAdvancedAgeEmploymentListReceipt',
		    data: {
				advancedAgeBaseId : $('#baseId').val(),
				identification : $(item).parent().parent('li').find('input[name^="identification"]').val(),
				frequency : $(item).parent().parent('li').find('select[name^="frequency"]').val(),
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
}

function listSave(){
	
	let data={},list=[],totalAmount=0;
	$('#loader-container').show();
	$('#employedTable').find('li').each(function(){
		data={};
		if($(this).find('input[name^="identification"]').val()!='')
		{
			data.seq=$('#seq').val();
			data.advancedAgeBaseId=$('#baseId').val();
			data.name=$(this).find('input[name^="name"]').val();
			data.birthday=$(this).find('input[name^="birthday"]').val();
			data.identification=$(this).find('input[name^="identification"]').val();
			if($(this).find('select[name^="insuranceType"]').val()==1){
				data.laborProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
			}else if($(this).find('select[name^="insuranceType"]').val()==2){
				data.occupationalAccidentProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
			}
			data.salary=$(this).find('input[name^="salary"]').val();
			data.salaryMethod=$(this).find('select[name^="salaryMethod"]').val();
			data.salaryMethodRemark=$(this).find('input[name^="salaryMethodRemark"]').val().replaceAll(',',';');
			data.frequency=$(this).find('select[name^="frequency"]').val();
			data.baseAllowanceFrequency=$('#baseAllowanceFrequencyTime').val();
			$(this).find('input[name^="count"]').each(function(){
				if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
					data.employmentMonthStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
					data.employmentMonthEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
					if(data.frequency=='1'){
						data.lowMonthNumber=$(this).parent().find('input[name^="count"]').val();
					}else{
						data.highMonthNumber=$(this).parent().find('input[name^="count"]').val();
					}
				}
				if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
					data.employmentHourStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
					data.employmentHourEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
					if(data.frequency=='1'){
						data.lowHoursNumber=$(this).parent().find('input[name^="count"]').val();
					}else{
						data.highHoursNumber=$(this).parent().find('input[name^="count"]').val();
					}
				}
			})
			totalAmount=0;
			$(this).find('input[name^="amounts"]').each(function(){
				if(totalAmount==0){
					totalAmount=Number($(this).val());
				}else{
					totalAmount=totalAmount+Number($(this).val());
				}
			})
			data.amounts=totalAmount;
		}
		list.push(data);
	});
	$.ajax({
	    type: "POST",
	    url: 'addAdvancedAgeEmploymentListReceipt',
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
}

function fileUpload(){
	if($('#uploadFile').val() != '')
	{
		let file = new FormData();
		file.append('uploadFile',$('#uploadFile').get(0).files[0]);
		file.append('baseId',$('#baseId').val());
		file.append('baseAllowanceFrequencyTime',$('#baseAllowanceFrequencyTime').val());
		$.confirm({
		    title: '上傳前確認',
		    animation: 'zoom',
		    closeAnimation: 'scale',
		    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
		    buttons: {
		      確認: function() {
				$('#loader-container').show();
		        $.ajax({
				   	type: 'post',
					url: 'addAdvancedAgeEmploymentListReceiptFromFile',// 資料不需要編碼
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
	}
}
function next(){
	if($('#listForm').valid()){
		$('#loader-container').show();
		let data={},list=[],totalAmount=0;
		$('#employedTable').find('li').each(function(){
			data={};
			if($(this).find('input[name^="identification"]').val()!='')
			{
				data.seq=$('#seq').val();
				data.advancedAgeBaseId=$('#baseId').val();
				data.name=$(this).find('input[name^="name"]').val();
				data.birthday=$(this).find('input[name^="birthday"]').val();
				data.identification=$(this).find('input[name^="identification"]').val();
				if($(this).find('select[name^="insuranceType"]').val()==1){
					data.laborProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
				}else if($(this).find('select[name^="insuranceType"]').val()==2){
					data.occupationalAccidentProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
				}
				data.salary=$(this).find('input[name^="salary"]').val();
				data.salaryMethod=$(this).find('select[name^="salaryMethod"]').val();
				data.salaryMethodRemark=$(this).find('input[name^="salaryMethodRemark"]').val().replaceAll(',',';');
				data.frequency=$(this).find('select[name^="frequency"]').val();
				data.baseAllowanceFrequency=$('#baseAllowanceFrequencyTime').val();
				$(this).find('input[name^="count"]').each(function(){
					if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
						data.employmentMonthStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
						data.employmentMonthEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
						if(data.frequency=='1'){
							data.lowMonthNumber=$(this).parent().find('input[name^="count"]').val();
						}else{
							data.highMonthNumber=$(this).parent().find('input[name^="count"]').val();
						}
					}
					if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
						data.employmentHourStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
						data.employmentHourEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
						if(data.frequency=='1'){
							data.lowHoursNumber=$(this).parent().find('input[name^="count"]').val();
						}else{
							data.highHoursNumber=$(this).parent().find('input[name^="count"]').val();
						}
					}
				})
				totalAmount=0;
				$(this).find('input[name^="amounts"]').each(function(){
					if(totalAmount==0){
						totalAmount=Number($(this).val());
					}else{
						totalAmount=totalAmount+Number($(this).val());
					}
				})
				data.amounts=totalAmount;
			}
			list.push(data);
		});
		$.ajax({
		    type: "POST",
		    url: 'addAdvancedAgeEmploymentListReceipt',
		    data: JSON.stringify(list),
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			contentType:"application/json",
		    success: function(json){  
				location.href='employ_payment_03';
		    },
		    error: function(json){
			    alert('稍等5秒再試');
				$('#loader-container').hide();
		    }
	    });
		
	}
}