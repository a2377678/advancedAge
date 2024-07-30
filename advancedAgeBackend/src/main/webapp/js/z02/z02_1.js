function saveData(){
	let reg=/^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\W]).{12,}$/;
	if(reg.test($('#password').val())){
		$('#editForm').submit();
	}
	else
	{
		alert('密碼格式錯誤');
	}
}