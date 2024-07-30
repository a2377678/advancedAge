var pdfdoc = new jsPDF();

function pdf(){
	html2canvas(document.getElementById('export_content')).then(canvas => {
	        //返回图片dataURL，参数：图片格式和清晰度(0-1)
	        var pageData = canvas.toDataURL('image/jpeg', 1.0);
	        //方向默认竖直，尺寸ponits，格式a4[595.28,841.89]
	        var doc = new jsPDF('', 'pt', 'a4');
	        //addImage后两个参数控制添加图片的尺寸，此处将页面高度按照a4纸宽高比列进行压缩
	        doc.addImage(pageData, 'JPEG', 30, 30, 595.28*0.9, 592.28/canvas.width * canvas.height );
	        doc.save('規劃課程清冊.pdf');
	    });
}

function doPrint(){
	bdhtml=window.document.body.innerHTML;
	sprnstr="<!--startprint-->";
	eprnstr="<!--endprint-->";
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
	window.document.body.innerHTML=prnhtml;
	window.print();
	window.document.body.innerHTML=bdhtml
}
