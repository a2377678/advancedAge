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
		$('#list').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').show();
		$('#listTable').hide();
		$('#situationTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#listTable').show();
		$('#situationTable').hide();
	})
	
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
	
	$('#checkEmploymentPerson').change(function(){
		$('#checkEmploymentPercentage').html((Number($('#checkEmploymentPerson').val())/Number($('#employmenyListSize').html())*100).toFixed(1));
		if($('#checkEmploymentPercentage').html().replace('%')>30){
			$('#employmentCheck').attr('class','text_pass');
			$('#employmentCheck').html('合格');
		}else{
			$('#employmentCheck').attr('class','text_warn');
			$('#employmentCheck').html('不合格');
		}
	})
})

function exportExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function list(seq,year,dataId){
	$('#dataForm').attr('action','employmentList');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function attachment(seq,year,dataId){
	$('#dataForm').attr('action','file');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function downloadFile(applyId){
	$.ajax({
	    type: "post",
	    url: 'saveRarAll',
		data: {
			fileBelongId : applyId,
//			date : date,
//			fileFrequency : $(this).val()
	    },
		success: function(json){  
			window.open('downloadRar?path=/A/'+applyId+'/allFile.rar');
	    },
	    error: function(json){
		    alert(json);
	    }
	});
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

function save(){
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			checkMultipleCompany : $('input[name="checkMultipleCompany"]:checked').val()!=undefined?$('input[name="checkMultipleCompany"]:checked').val():null,
			checkWorkersEmployment : $('input[name="checkWorkersEmployment"]:checked').val()!=undefined?$('input[name="checkWorkersEmployment"]:checked').val():null,
			checkRelatives : $('input[name="checkRelatives"]:checked').val()!=undefined?$('input[name="checkRelatives"]:checked').val():null,
			checkRelatedAmounts : $('input[name="checkRelatedAmounts"]:checked').val()!=undefined?$('input[name="checkRelatedAmounts"]:checked').val():null,
			checkNotMandatory : $('input[name="checkNotMandatory"]:checked').val()!=undefined?$('input[name="checkNotMandatory"]:checked').val():null,
			checkEmploymentPerson : $('#checkEmploymentPerson').val(),
			checkEmploymentRemark : $('#checkEmploymentRemark').val(),
			checkAttachmentRemark : $('#checkAttachmentRemark').val(),
			checkBlacklistStatus : $('#checkBlacklistStatus').text()=='合格'?'Y':$('#checkBlacklistStatus').text()=='合格'?'N':null,
			checkBlacklistRemark : $('#checkBlacklistRemark').val(),
			checkSiteinspectionStatus : $('#checkSiteinspectionStatus').text()=='合格'?'Y':$('#checkSiteinspectionStatus').text()=='不合格'?'N':null,
			checkSiteinspectionRemark : $('#checkSiteinspectionRemark').val(),
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
				location.href='b02?account='+$('input[name="account"]').val();
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function cancel(){
	location.href='b02?account='+$('input[name="account"]').val();
}