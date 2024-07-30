const thirtyMin = new Date().getTime() + 25 * 60 * 1000;
function getRemaindingTime() {
	const today = new Date().getTime();
	const t = thirtyMin - today;
	const oneHour = 60 * 60 * 1000;
	const oneMinute = 60 * 1000;
	let minutes = Math.floor((t % oneHour) / oneMinute); //分鐘數
	let seconds = Math.floor((t % oneMinute) / 1000); //秒數
	let values = [minutes, seconds];
	
	
	if (t < 0) {
	    clearInterval(countdown); //結束countdown
	    $('#countDown').text("計時提醒 00:00");
	    // 跳出alert
	    $('#noticeTime').trigger("click");
	}else {
		$('#countDown').text("計時提醒 "+format(values[0])+":"+format(values[1]));
	}
}

function format(item) {
    if (item < 10) {
      return (item = `0${item}`);
    }
    return item;
};

let countdown = setInterval(getRemaindingTime, 1000);