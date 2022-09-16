function addData(){
	let a = /[0-9]/i; 
	let b = /[a-zA-Z]/i;
	if(a.test($('#userAccount').val()) && b.test($('#userAccount').val()) &&$('#userAccount').val().length>=6){
		if(a.test($('#password').val()) && b.test($('#password').val()) && $('#password').val().length>=6){
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