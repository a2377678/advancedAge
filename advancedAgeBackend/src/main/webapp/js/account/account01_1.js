function clearSearchData(){
	$('#seq').val('');
	$('#companyName').val('');
}

function cancel(){
	$('#searchForm').submit();
}

function sendMail(){
	$.ajax({
	    type: "POST",
	    url: 'editCompanyInfo',
	    data: {
	    	seq : $('#dataSeq').val(),
			accountStatus : 2,
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			$.ajax({
			   	type: 'post',
				url: 'sendMail',// 資料不需要編碼
				data: {
					email: $('#email').val(),
				},
				success: function(res) {
//			   	// 判斷是否接收成功
				   	location.href='account01?account='+$('input[name="account"]').val();
				}
			});
			
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}