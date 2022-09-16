$(function(){
	if($('#jurisdiction').val()!=undefined)
	{
		jurisdiction();
	}
	$('#jurisdiction').change(function(){
		jurisdiction();
	});
})

function jurisdiction(){
	$('input[name^="functionCode"]').prop('checked',false);
	$.ajax({
	    type: "POST",
	    url: 'selectFunctionPermission',
	    data: {
			jurisdiction : $('#jurisdiction').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(text){ 
			let json=jQuery.parseJSON(text);
			if(json.status=='success'){
				let json_spl=json.code.split("、");
				$('input[name^="functionCode"]').each(function(){
					if(json.code.indexOf($(this).val())!=-1)
					{
						$(this).prop('checked',true);
					}
				})
			}
	    }
    });
}

function resetData(){
	jurisdiction();
}

function saveData(){
	let functionCode='';
	$('input[name^="functionCode"]').each(function(){
		if($(this).prop('checked'))
		{
			if(functionCode=='')
			{
				functionCode=$(this).val();
			}
			else
			{
				functionCode=functionCode+'、'+$(this).val();
			}
		}
	});
	$.ajax({
	    type: "POST",
	    url: 'editFunctionPermission',
	    data: {
			jurisdiction : $('#jurisdiction').val(),
			functionCode : functionCode
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(text){ 
			let json=jQuery.parseJSON(text);
			if(json.status=='success'){
				alert('儲存成功');
			}
	    }
    });
}