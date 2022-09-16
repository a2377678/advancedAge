function openData(dataId,dataSeq){
	$('#searchSeq').val($('#seq').val());
	$('#searchCompanyName').val($('#companyName').val());
	$('#dataSeq').val(dataSeq);
	$('#id').val(dataId);
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
	$('#companyName').val('');
}