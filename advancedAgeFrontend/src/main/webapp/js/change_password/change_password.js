function checkPassword(password){
	let reg=/^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\W]).{12,}$/;
	return reg.test(password);
}

function changePassword(){
	if($('#newPassword').val()==$('#checkNewPassword').val()){
		if($('#newPassword').val()!=''){
			if(checkPassword($('#newPassword').val())){
				change();
			}else{
				alert('密碼格式錯誤');
			}
		}else{
			change();
		}
	}else{
		alert('請確認新密碼是否一致');
	}
}

function change(){
	$.ajax({
    	type: "POST",
	    url: 'changePassword',
	    data: {
			seq : $('#seq').val(),
			email : $('#email').val(),
//			password : $('#password').val(),
			newPassword : $('#newPassword').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				alert('更改完成');
			}
			else if(json=='fail'){
				alert('密碼錯誤');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
	});
}