$(function(){
	$.datepicker.regional['zh-TW']={
   dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
   dayNamesMin:["日","一","二","三","四","五","六"],
   monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
   monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
   prevText:"上月",
   nextText:"次月",
   weekHeader:"週"
};
	$.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
	$.ajax({
	    type: "POST",
	    url: 'getTsbApplyData',
	    data: {
			allowanceId : $('#allowanceId').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			let jsonData = JSON.parse(json);
			if(jsonData.status=='success'){
				$('#allowanceApplyTime').val(jsonData.tsbWorkDate);
				$('#allowanceApplyStartTime').val(jsonData.tsbSDate);
				$('#allowanceApplyEndTime').val(jsonData.tsbEDate);
				$('#allowanceTotalAmounts').val(jsonData.tsbTotalMoney);
				$('#allowanceAmounts').val(jsonData.tsbApplyMoney);
				$('#allowanceApproveAmounts').val(jsonData.tsbDecMoney);
				$('#allowanceApproveId').val(jsonData.tsbApprovedNo);
				$('#allowanceApproveTime').val(jsonData.tsbApprovedDate);
			}
	    },
	    error: function(json){
	    }
    });
	$('#allowanceApplyTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
	$('#allowanceApproveTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
	$('#allowanceApplyStartTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	let startDate;
	$('#allowanceApplyEndTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#allowanceApplyStartTime').val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	
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

function speakerList(seq,year,dataId){
	$('#dataForm').attr('action','speakerList');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function exportSpeakerExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportSpeakerExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function schedule(seq,year,dataId){
	$('#dataForm').attr('action','schedule');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function exportScheduleExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportScheduleExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function participate(seq,year,dataId){
	$('#dataForm').attr('action','participate');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function exportParticipateExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportParticipateExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function expenditure(seq,year,dataId){
	$('#dataForm').attr('action','expenditure');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function exportExpenditureExcel(seq,year,dataId){
	$('#dataForm').attr('action','exportExpenditureExcel');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function attachment(seq,year,dataId){
	$('#dataForm').attr('action','l01File');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function blackList(id){
	$('#dataForm').attr('action','o01_1');
	$('#dataId').val(id);
	$('#dataForm').submit();
}

function siteInspection(id){
	$('#dataForm').attr('action','o02_1');
	$('#dataId').val(id);
	$('#dataForm').submit();
}

function save(){
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			allowanceId : $('#allowanceId').val(),
			allowanceApplyTime : $('#allowanceApplyTime').val(),
			allowanceApplyStartTime : $('#allowanceApplyStartTime').val(),
			allowanceApplyEndTime : $('#allowanceApplyEndTime').val(),
			allowanceTotalAmounts : $('#allowanceTotalAmounts').val(),
			allowanceAmounts : $('#allowanceAmounts').val(),
			allowanceApproveAmounts : $('#allowanceApproveAmounts').val(),
			allowanceApproveId : $('#allowanceApproveId').val(),
			allowanceApproveTime : $('#allowanceApproveTime').val(),
			allowanceRemark : $('#allowanceRemark').val(),
			caseStatus : 4,
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			updator : $('#updator').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				location.href='m02';
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function notSubsidy(){
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			allowanceId : $('#allowanceId').val(),
			allowanceApplyTime : $('#allowanceApplyTime').val(),
			allowanceApplyStartTime : $('#allowanceApplyStartTime').val(),
			allowanceApplyEndTime : $('#allowanceApplyEndTime').val(),
			allowanceTotalAmounts : $('#allowanceTotalAmounts').val(),
			allowanceAmounts : $('#allowanceAmounts').val(),
			allowanceApproveAmounts : $('#allowanceApproveAmounts').val(),
			allowanceApproveId : $('#allowanceApproveId').val(),
			allowanceApproveTime : $('#allowanceApproveTime').val(),
			allowanceRemark : $('#allowanceRemark').val(),
			caseStatus : 8,
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			updator : $('#updator').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				location.href='m02';
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function cancel(){
	location.href='m02';
}