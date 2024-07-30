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
