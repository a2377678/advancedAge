$(function(){
	$('#checkEmploymentPercentage').html((Number($('#employmenyListReceiptNumber').html().replace('人',''))/Number($('#nearHighEmploymentNumber').html().replace('人',''))*100).toFixed(1)+'%');
	if((Number($('#employmenyListReceiptNumber').html().replace('人',''))/Number($('#nearHighEmploymentNumber').html().replace('人',''))*100).toFixed(1)>=30){
		$('#checkEmploymentPerson').html('合格');
	}else{
		$('#checkEmploymentPerson').html('不合格');
	}
	
})