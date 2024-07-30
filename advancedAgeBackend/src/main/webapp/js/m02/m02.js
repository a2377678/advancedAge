function edit(seq,year,dataId){
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
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