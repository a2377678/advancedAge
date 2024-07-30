function save(){
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritanceResult',
	    data: {
			contactName : $('#contactName').val(),
			contactJobtitle : $('#contactJobtitle').val(),
			contactWorkPhoneAreaCode : $('#contactWorkPhoneAreaCode').val(),
			contactWorkPhone : $('#contactWorkPhone').val(),
			contactWorkPhoneExtension : $('#contactWorkPhoneExtension').val(),
			contactPhone : $('#contactPhone').val(),
			faxAreaCode : $('#faxAreaCode').val(),
			fax : $('#fax').val(),
			email : $('#email').val(),
			approveAmounts : $('#approveAmounts').val(),
			realAmounts : $('#realAmounts').val(),
			planExecutionSituation : $('#planExecutionSituation').val(),
			result : $('#result').val(),
			suggestion : $('#suggestion').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				alert('資料已暫存');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function wordsLimit(e,limitLength){
	let words=$(e).val();
	if(words.length>limitLength){
		$(e).val(words.slice(0,limitLength));
	}
}

function next(){
	if($('#form').valid()){
		$.ajax({
		    type: "POST",
		    url: 'addRetirementAdvancedAgeExperienceInheritanceResult',
		    data: {
				contactName : $('#contactName').val(),
				contactJobtitle : $('#contactJobtitle').val(),
				contactWorkPhoneAreaCode : $('#contactWorkPhoneAreaCode').val(),
				contactWorkPhone : $('#contactWorkPhone').val(),
				contactWorkPhoneExtension : $('#contactWorkPhoneExtension').val(),
				contactPhone : $('#contactPhone').val(),
				faxAreaCode : $('#faxAreaCode').val(),
				fax : $('#fax').val(),
				email : $('#email').val(),
				approveAmounts : $('#approveAmounts').val(),
				realAmounts : $('#realAmounts').val(),
				planExecutionSituation : $('#planExecutionSituation').val(),
				result : $('#result').val(),
				suggestion : $('#suggestion').val()
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if(json=='success'){
					location.href='teach_payment_03';
				}
		    },
		    error: function(json){
			    alert(json);
		    }
	    });
	}
}