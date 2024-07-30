$(function(){
	
})
function sendMail(){
	$.ajax({
	    type: "POST",
	    url: 'sendMail',
	    data: {
			mailContent : $('#mailHeader').text()+$('#mailContent').val()+$('#mailFooter').text(),
			email : $('#email').val(),
			advancedAgeBaseId : $('#baseId').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			mailType : 'C'
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			
			if(json=='success'){
				$.ajax({
				    type: "POST",
				    url: 'changeFileStatus2',
				    data: {
						aaid : $('#baseAaid').val(),
						reviewStatus : 2,
						reviewRemark : $('#otherRemark').val(),
						verifyUnit : $('#verifyUnit').val(),
						verifyPerson : $('#verifyPerson').val(),
						reviewEmailContent : $('#mailContent').val(),
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						if(json=='success'){
							alert('信件已發送');
						}
				    },
				    error: function(json){
					    alert(json);
				    }
			    });
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function saveData(){
	$.ajax({
	    type: "POST",
	    url: 'changeFileStatus2',
	    data: {
			aaid : $('#baseAaid').val(),
			reviewRemark : $('#otherRemark').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			reviewEmailContent : $('#mailContent').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				alert('暫存成功');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

//function finish(){
//	$.ajax({
//	    type: "POST",
//	    url: 'changeFileStatus',
//	    data: {
//			aaid : $('#baseAaid').val(),
//			reviewRemark : $('#otherRemark').val(),
//			verifyUnit : $('#verifyUnit').val(),
//			verifyPerson : $('#verifyPerson').val(),
//			reviewEmailContent : $('#mailContent').val(),
//	    },
//	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
//	    success: function(json){  
//			if(json=='success'){
//				window.close();
//			}
//	    },
//	    error: function(json){
//		    alert(json);
//	    }
//    });
//}