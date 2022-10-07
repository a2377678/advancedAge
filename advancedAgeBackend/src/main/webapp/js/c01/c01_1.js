function openData(seq,baseId,year,frequency,action){
	$('#dataSeq').val(seq);
	$('#advancedAgeBaseId').val(baseId);
	$('#baseAllowanceFrequency').val(frequency);
	$('#year').val(year);
	if(action==2)
	{
		$('#dataForm').attr('action','c01_result')
	}else if(action==1){
		$('#dataForm').attr('action','c01_list')
	}
	$('#dataForm').submit();
}

function verify(record,frequency){
	let record_spl=record.split(';');
	let finalRecord='';
	record_spl[Number(frequency)-1]=record_spl[Number(frequency)-1].substring(0,record_spl[Number(frequency)-1].length-1)+"1";
	for(var i=0;i<record_spl.length-1;i++){
		finalRecord+=record_spl[i]+';';
	}
	
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			allowanceFrequencyRecord : finalRecord,
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			updator : $('#updator').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				location.reload();
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function cancel(){
	location.href='c01?account='+$('input[name="account"]').val();
}