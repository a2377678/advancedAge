function saveData(){
	$.ajax({
	    type: "POST",
	    url: 'changeFileStatus3',
	    data: {
			aaid : $('#baseAaid').val(),
			allowanceFileRemark : $('#otherRemark').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			allowanceEmailContent : $('#mailContent').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				alert('儲存成功');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}