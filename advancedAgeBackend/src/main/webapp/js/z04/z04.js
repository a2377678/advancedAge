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

	$('#loginStartDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	let startDate;
	$('#loginEndDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			if($('#loginStartDate').val()!='')
			{
				startDate=$('#loginStartDate').val();
				$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
			}
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
})

function changePage(page){
	if(page=='-1')
	{
		$('#page').val((Number($('#page').val())-1));
	}
	else if(page=='+1')
	{
		$('#page').val((Number($('#page').val())+1));
	}
	else
	{
		$('#page').val(page);
	}
	$('#searchForm').submit();
}

function clearData(){
	$('#unit').val('');
	$('#jurisdiction').val('');
	$('#username').val('');
	$('#loginStartDate').val('');
	$('#loginEndDate').val('');
}