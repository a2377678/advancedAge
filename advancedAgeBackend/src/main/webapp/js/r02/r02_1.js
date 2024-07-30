function saveData(){
	let reg=/^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\W]).{12,}$/;
	if($('#password').val()!=''){
		if(reg.test($('#password').val())){
			$('#editForm').submit();
		}
		else
		{
			alert('密碼格式錯誤');
		}
	}else{
		$('#editForm').submit();
	}
}