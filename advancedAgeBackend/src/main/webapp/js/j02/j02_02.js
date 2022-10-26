function addData(){
	let a = /[0-9]/i; 
	let b = /[a-zA-Z]/i;
	let reg=/^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\W]).{12,}$/;
	if(a.test($('#userAccount').val()) && b.test($('#userAccount').val()) &&$('#userAccount').val().length>=6){
		if(reg.test($('#password').val())){
		$('#addForm').submit();
		}
		else
		{
			alert('密碼格式錯誤');
		}
	}
	else
	{
		alert('帳號格式錯誤');
	}
	
	
}