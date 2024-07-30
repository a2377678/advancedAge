$(function(){
	$('#condition').click(function(){
		$('#unitData').find('a').removeClass();
		$(this).find('a').addClass('in');
		$('#unitDataTable').hide();
		$('#conditionTable').show();
	})
	
	$('#unitData').click(function(){
		$('#condition').find('a').removeClass();
		$(this).find('a').addClass('in');
		$('#unitDataTable').show();
		$('#conditionTable').hide();
	})
	
	$('#employed').click(function(){
		$('#situation').find('a').removeClass();
		$('#list').find('a').removeClass();
		$('#class').find('a').removeClass();
		$('#outlay').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').show();
		$('#situationTable').hide();
		$('#listTable').hide();
		$('#classTable').hide();
		$('#outlayTable').hide();
	})
	
	$('#situation').click(function(){
		$('#employed').find('a').removeClass();
		$('#list').find('a').removeClass();
		$('#class').find('a').removeClass();
		$('#outlay').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#situationTable').show();
		$('#listTable').hide();
		$('#classTable').hide();
		$('#outlayTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$('#class').find('a').removeClass();
		$('#outlay').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#situationTable').hide();
		$('#listTable').show();
		$('#classTable').hide();
		$('#outlayTable').hide();
	})
	
	$('#class').click(function(){
		$('#employed').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$('#list').find('a').removeClass();
		$('#outlay').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#situationTable').hide();
		$('#listTable').hide();
		$('#classTable').show();
		$('#outlayTable').hide();
	})
	
	$('#outlay').click(function(){
		$('#employed').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$('#list').find('a').removeClass();
		$('#class').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#situationTable').hide();
		$('#listTable').hide();
		$('#classTable').hide();
		$('#outlayTable').show();
	})

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


function attachment(seq,year,dataId){
	$('#dataForm').attr('action','t01File');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function checkData(seq,year,dataId){
	$('#dataForm').attr('action','u01_file_text');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function print(seq,year,dataId){
	$('#dataForm').attr('action','u01_1_print');
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

function save(){
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			checkMultipleCompany : $('input[name="checkMultipleCompany"]:checked').val()!=undefined?$('input[name="checkMultipleCompany"]:checked').val():null,
			checkRelatedAmounts : $('input[name="checkRelatedAmounts"]:checked').val()!=undefined?$('input[name="checkRelatedAmounts"]:checked').val():null,
			checkEmploymentPerson : $('#checkEmploymentPerson').val(),
			checkEmploymentRemark : $('#checkEmploymentRemark').val(),
			checkExpenditureAmounts: $('#checkExpenditureAmounts').val(),
			checkExpenditureRemark: $('#checkExpenditureRemark').val(),
			checkJointAuthorizeRemark: $('#checkJointAuthorizeRemark').val(),
			checkAttachmentRemark : $('#checkAttachmentRemark').val(),
			checkBlacklistStatus : $('#checkBlacklistStatus').text()=='合格'?'Y':$('#checkBlacklistStatus').text()=='合格'?'N':null,
			checkBlacklistRemark : $('#checkBlacklistRemark').val(),
			checkInsuranceStatus : $('#checkInsuranceStatus').val()=='Y'?'Y':$('#checkInsuranceStatus').val()=='N'?'N':null,
			checkInsuranceRemark : $('#checkInsuranceRemark').val(),
			checkAllowanceStatus : $('#checkAllowanceStatus').val()=='Y'?'Y':$('#checkAllowanceStatus').val()=='N'?'N':null,
			checkAllowanceRemark : $('#checkAllowanceRemark').val(),
			checkCgssStatus : $('#checkCgssStatus').val()=='Y'?'Y':$('#checkCgssStatus').val()=='N'?'N':null,
			checkCgssRemark : $('#checkCgssRemark').val(),
			checkViolationlaborlawsStatus : $('#checkViolationlaborlawsStatus').val()=='Y'?'Y':$('#checkViolationlaborlawsStatus').val()=='N'?'N':null,
			checkViolationlaborlawsRemark : $('#checkViolationlaborlawsRemark').val(),
			allowanceId : $('#allowanceId').val(),
			allowanceAmounts : $('#allowanceAmounts').val(),
			countersignId : $('#countersignId').val(),
			caseStatus : $('input[name="caseStatus"]:checked').val(),
			caseDescription : $('#caseDescription').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			updator : $('#updator').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
//				location.href='u01';
				alert('暫存成功');
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function cancel(){
	location.href='u01';
}