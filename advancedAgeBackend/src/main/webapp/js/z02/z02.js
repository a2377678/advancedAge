function openData(account){
	$('#editAccount').val(account);
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

function clearData(){
	$('#unit').val('');
	$('#jurisdiction').val('');
	$('#status').prop('checked',true);
	$('#userAccount').val('');
	$('#name').val('');
}