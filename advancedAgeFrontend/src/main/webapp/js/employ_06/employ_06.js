function downloadPdf(){
	$.ajax({
	    type: "POST",
	    url: 'pdf',
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(text){
			let json=jQuery.parseJSON(text);
			if(json.status=='success'){
				window.open('downloadPdf?path='+json.path);
			}
		}
	})
}