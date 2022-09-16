//var pdfdoc = new jsPDF();
//var specialElementHandlers = {
//
//	'#ignoreContent': function (element, renderer) {
//	
//	return true;
//	
//	}
//
//};
$(function(){
//	$('#gpdf').click(function(){
//
//	pdfdoc.fromHTML($('#export_content').html(), 10, 10, {
//	
//		'width': 200,
//		
//		'elementHandlers': specialElementHandlers
//	
//		});
//	
//	pdfdoc.save('First.pdf');
//	});
	$('#gpdf').click(function(){
		generatePdf(); 
	})
  
})

function generatePdf() {
  		var canvas = document.getElementById("canvas");
  		var context = canvas.getContext('2d')
  		var fileContent = document.getElementById("export_content").outerHTML;
  		var options = {
           width: window.innerWidth,
    	     height: window.innerHeight          
        };
		rasterizeHTML.drawHTML(fileContent, canvas, options).then(function (renderResult) {          	
		    context.drawImage(renderResult.image, 0, 0);
        console.log(canvas.toDataURL("image/png"));	
        var imgData = canvas.toDataURL("image/png");
        var pdf = new jsPDF(); //2.X版的寫法 var pdf = new jspdf.jsPDF()
        pdf.addImage(imgData, 'JPEG', 0, 0);
        //console.log(pdf);	
        pdf.save("download.pdf");
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
