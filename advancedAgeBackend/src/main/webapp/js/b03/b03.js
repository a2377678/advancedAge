$(function(){
	

	$('#banStartDate').datepicker({ 
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
	$('#banEndDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			if($('#banStartDate').val()!='')
			{
				startDate=$('#banStartDate').val();
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
function edit(id){
	$('#id').val(id);
	$('#searchSeq').val($('#seq').val());
	$('#searchUnit').val($('#unit').val());
	$('#searchBanStartDate').val($('#banStartDate').val());
	$('#searchBanEndDate').val($('#banEndDate').val());
	$('#dataForm').submit();
}

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

function clearSearchData(){
	$('#seq').val('');
	$('#banStartDate').val('');
	$('#banEndDate').val('');
	$('#unit').val('');
}