$(function(){
	if($('#planPercentage').html().replace('%')>30){
		$('#planCheck').attr('class','text_pass');
		$('#planCheck').html('合格');
	}else{
		$('#planCheck').attr('class','text_warn');
		$('#planCheck').html('不合格');
	}
	
	if($('#checkEmploymentPerson').val()!=''){
		$('#checkEmploymentPercentage').html((Number($('#checkEmploymentPerson').val())/Number($('#employmenyListSize').html())*100).toFixed(1));
		if($('#checkEmploymentPercentage').html().replace('%')>30){
			$('#employmentCheck').attr('class','text_pass');
			$('#employmentCheck').html('合格');
		}else{
			$('#employmentCheck').attr('class','text_warn');
			$('#employmentCheck').html('不合格');
		}
	}
	
	bdhtml=window.document.body.innerHTML;
	sprnstr="<!--startprint-->";
	eprnstr="<!--endprint-->";
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
	window.document.body.innerHTML=prnhtml;
	window.print();
	window.document.body.innerHTML=bdhtml
})

function attachment(seq,year,dataId){
	$('#dataForm').attr('action','file');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function checkData(seq,year,dataId){
	$('#dataForm').attr('action','b02_file_text');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function blackList(id){
	$('#dataForm').attr('action','b03_1');
	$('#dataId').val(id);
	$('#dataForm').submit();
}

function siteInspection(id){
	$('#dataForm').attr('action','b04_1');
	$('#dataId').val(id);
	$('#dataForm').submit();
}