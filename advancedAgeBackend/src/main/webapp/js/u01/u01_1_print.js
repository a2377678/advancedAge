$(function(){
	bdhtml=window.document.body.innerHTML;
	sprnstr="<!--startprint-->";
	eprnstr="<!--endprint-->";
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
	window.document.body.innerHTML=prnhtml;
	window.print();
	window.document.body.innerHTML=bdhtml
})

function exportExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportPersonnelExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function personnelList(seq,year,dataId){
	$('#dataForm').attr('action','personnelList');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function expenditure(seq,year,dataId){
	$('#dataForm').attr('action','u01Expenditure');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function exportExpenditureExcel(seq,year,dataId){
	$('#dataForm').attr('action','u01exportExpenditureExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function jointUnit(seq,year,dataId){
	$('#dataForm').attr('action','jointUnit');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function exportJointUnitExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportJointUnitExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function blackList(id){
	$('#dataForm').attr('action','w01_1');
	$('#dataId').val(id);
	$('#dataForm').submit();
}

function siteInspection(id){
	$('#dataForm').attr('action','w02_1');
	$('#dataId').val(id);
	$('#dataForm').submit();
}