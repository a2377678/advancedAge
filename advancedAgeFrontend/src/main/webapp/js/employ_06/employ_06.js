//function downloadPdf(){
//	$.ajax({
//	    type: "POST",
//	    url: 'pdf',
//	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
//	    success: function(text){
//			let json=jQuery.parseJSON(text);
//			if(json.status=='success'){
//				window.open('downloadPdf?path='+json.path);
//			}
//		}
//	})
//}

function doPrint() {
bdhtml=window.document.body.innerHTML;
sprnstr="<!--startprint-->";
eprnstr="<!--endprint-->";
prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
window.document.body.innerHTML=prnhtml;
window.print();
window.document.body.innerHTML=bdhtml
}