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

function finish(){
	$.ajax({
	    type: "POST",
	    url: 'editAdvancedAgeBaseBType',
	    data: {
			id : $('#baseId').val(),
			caseStatus : 5
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){
			if(json=='success'){
				location.href='teach_payment_05';
			}
		}
	})
}