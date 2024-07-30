$(function(){
	var preText,changeAaid,changeUnit;
	$('select[name^="changeUnit"]').focus(function(){
		preText=$(this).find(':selected').text();
	}).change(function(){
		changeAaid=$(this).parent().find('input[id^="baseAaid"]').val();
		changeUnit=$(this).val();
		$.confirm({
			title: $(this).parent().parent().find('.company_name').text(),
			content : '承辦單位從 『'+preText+'』分到 『'+$(this).find(':selected').text()+'』',
			confirmButton: '確定', // 修改確認按鈕的文字
    		cancelButton: '取消', // 修改取消按鈕的文字
			buttons: {
				確認: function() {
					$.ajax({
					    type: "POST",
					    url: 'fileStatusSave',
					    data: {
							aaid : changeAaid,
							unit : changeUnit
					    },
					    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
					    success: function(json){  
							if(json=='success'){
								alert('更改成功');
								searchList();
							}
					    }
			    	});
				},
				取消: function() {
					searchList();
		    	}
			}
		})
	})
})

function searchList(){
	$('#page').val('1');
	$('#searchForm').submit();
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