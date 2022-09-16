function edit(id){
	$('#id').val(id);
	$('#searchSeq').val($('#seq').val());
	$('#searchResult').val($('input[name="result"]:checked').val());
	$('#searchUnit').val($('#unit').val());
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