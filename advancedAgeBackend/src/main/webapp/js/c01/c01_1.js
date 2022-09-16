function openData(seq,baseId,year,frequency){
	$('#dataSeq').val(seq);
	$('#advancedAgeBaseId').val(baseId);
	$('#baseAllowanceFrequency').val(frequency);
	$('#year').val(year);
	$('#dataForm').submit();
}