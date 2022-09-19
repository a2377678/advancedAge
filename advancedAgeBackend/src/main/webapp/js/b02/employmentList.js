var pdfdoc = new jsPDF();

$(function(){
	$('#gpdf').click(function(){
		html2canvas(document.getElementById('export_content')).then(canvas => {
	        //返回图片dataURL，参数：图片格式和清晰度(0-1)
	        var pageData = canvas.toDataURL('image/jpeg', 1.0);
	        //方向默认竖直，尺寸ponits，格式a4[595.28,841.89]
	        var doc = new jsPDF('', 'pt', 'a4');
	        //addImage后两个参数控制添加图片的尺寸，此处将页面高度按照a4纸宽高比列进行压缩
	        doc.addImage(pageData, 'JPEG', 30, 30, 595.28*0.9, 592.28/canvas.width * canvas.height );
	        doc.save('補助名單清冊.pdf');
	    });
	})

//	var doc = new jsPDF();
//	doc.addFileToVFS('msjh-normal.ttf', font);
//	doc.addFont('msjh-normal.ttf', 'msjh', 'normal');
//	doc.setFont("msjh");
//  doc.text('中文', 10, 10);
//  doc.save('helloworld.pdf');

//	$('#gpdf').click(function(){
//
//		pdfdoc.setFont('msjh');
//		pdfdoc.autoTable({
//			html: '#export_content',
//			styles:{
//				font:'msjh'
//			}
//		});
//		pdfdoc.save('First.pdf');
//	  
//	})
})


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
