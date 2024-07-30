var today = new Date();
var date = (today.getFullYear()-1911)+ "" + (today.getMonth()+1) + "" + today.getDate()
function employ(){
	if(date>'1121231'){
		alert('『113年度繼續僱用高齡者補助計畫 申請已於112/12/31截止』');
	}else{
		location.href='employ';
	}
}

function teach(){
	if(date<='1121231'){
		alert('『113年度僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 申請將於113/01/01開始』');
	}else{
		location.href='teach';
	}
}

function career(){
	if(date<='1121231'){
		alert('『113年度中高齡者退休後再就業準備協助措施 申請將於113/01/01開始』');
	}else{
		location.href='career';
	}
}