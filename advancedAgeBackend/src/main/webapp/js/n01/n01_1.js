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
	$('#allowanceApprovedTime').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
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

function attachment(seq,year,dataId){
	$('#dataForm').attr('action','n01File');
	$('#dataSeq').val(seq);
	$('#applyYear').val(year);
	$('#dataId').val(dataId);
	$('#dataForm').submit();
}

function save(){
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			checkAllowanceAttachmentRemark : $('#checkAllowanceAttachmentRemark').val(),
			allowanceApprovedAmounts : $('#allowanceApprovedAmounts').val(),
			allowanceApprovedId : $('#allowanceApprovedId').val(),
			allowanceApprovedTime : $('#allowanceApprovedTime').val(),
			caseStatus : $('input[name="caseStatus"]:checked').val(),
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			updator : $('#updator').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				location.href='n01';
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
}

function verify(record,frequency){
	let record_spl=record.split(';');
	let finalRecord='';
	record_spl[Number(frequency)-1]=record_spl[Number(frequency)-1].substring(0,record_spl[Number(frequency)-1].length-1)+"1";
	for(var i=0;i<record_spl.length-1;i++){
		finalRecord+=record_spl[i]+';';
	}
	
	$.ajax({
	    type: "POST",
	    url: 'saveBase',
	    data: {
			aaid : $('#aaid').val(),
			allowanceFrequencyRecord : finalRecord,
			verifyUnit : $('#verifyUnit').val(),
			verifyPerson : $('#verifyPerson').val(),
			updator : $('#updator').val(),
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(json){  
			if(json=='success'){
				location.reload();
			}
	    },
	    error: function(json){
		    alert(json);
	    }
    });
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

function cancel(){
	location.href='n01';
}