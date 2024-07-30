$(function() {
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
//	saveForm('N');
	
	presentCheckBoxStatus();

	if ($('#excel').find('a').attr('class') != '' && $('#excel').find('a').attr('class') != undefined) {
		$('#listStaff').hide();
		$('#listFile').show();
	}
	$('#employed').click(function() {
		$('#excel').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').show();
		$('#listFile').hide();
		$('#uploadFile').val('');
	})

	$('#excel').click(function() {
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').hide();
		$('#listFile').show();
	})

	$('input[name^="identification"]').change(function() {
		if ($(this).val().length > 0) {
			$(this).parent().parent('li').find('input').attr('required', true);
			$(this).parent().parent('li').find('select').attr('required', true);
		}
	});

	$('input[name="CheckboxGroup1"]').change(function() {
		var total = 0;
		if ($('input#CheckboxGroup1_0').is(':checked')) {
			total += 1;
		}
		if ($('input#CheckboxGroup1_1').is(':checked')) {
			total += 2;
		}
		if ($('input#CheckboxGroup1_2').is(':checked')) {
			total += 4;
		}
		if (total != 0) {
			$('input#subsidyType').val(total);
		} else {
			$('input#subsidyType').val('');
		}
	});
	
	$('input[name^="planStartTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		yearRange: "-100:+0",
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
			if(dateText.toString().length==6){
				dateText = '0'+dateText.toString().substr(0, 2) + dateText.toString().substr(2, 2) + dateText.toString().substr(4);
			}else if(dateText.toString().length==7){
            	dateText = dateText.toString().substr(0, 3)+ dateText.toString().substr(3, 2) + dateText.toString().substr(5);
			}
            $(this).val(dateText);
        } 
	});
	
	$('input[name^="planEndTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		yearRange: "-100:+0",
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
			if(dateText.toString().length==6){
				dateText = '0'+dateText.toString().substr(0, 2) + dateText.toString().substr(2, 2) + dateText.toString().substr(4);
			}else if(dateText.toString().length==7){
            	dateText = dateText.toString().substr(0, 3)+ dateText.toString().substr(3, 2) + dateText.toString().substr(5);
			}
            $(this).val(dateText);
        } 
	});
	
	$('input[name^="birthday"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		yearRange: "-100:+0",
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
			if(dateText.toString().length==6){
				dateText = '0'+dateText.toString().substr(0, 2) + dateText.toString().substr(2, 2) + dateText.toString().substr(4);
			}else if(dateText.toString().length==7){
            	dateText = dateText.toString().substr(0, 3)+ dateText.toString().substr(3, 2) + dateText.toString().substr(5);
			}
            $(this).val(dateText);
        } 
	});
	
	$('input[name^="insuranceTime"]').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		yearRange: "-100:+0",
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
			if(dateText.toString().length==6){
				dateText = '0'+dateText.toString().substr(0, 2) + dateText.toString().substr(2, 2) + dateText.toString().substr(4);
			}else if(dateText.toString().length==7){
            	dateText = dateText.toString().substr(0, 3)+ dateText.toString().substr(3, 2) + dateText.toString().substr(5);
			}
            $(this).val(dateText);
        } 
	});
})

function saveForm(showMsg) {
	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			workContent: $('#workContent').val(),
			friendlyMeasures: $('#friendlyMeasures').val(),
			employeeNumber: $('#employeeNumber').val(),
			beneficiaryNumber: $('#beneficiaryNumber').val(),
			subsidyType: $('#subsidyType').val(),
			amounts: $('#amounts').val(),
			multipleApplications: $('input[name="multipleApplications"]:checked').val(),
			multipleApplicationsDescription: $('#multipleApplicationsDescription').val(),
			applySameYear: $('input[name="applySameYear"]:checked').val(),
			applySameYearDescription: $('#applySameYearDescription').val(),
			planGoal: $('#planGoal').val(),
			planContent: $('#planContent').val(),
			planStartTime: $('#planStartTime').val(),
			planEndTime: $('#planEndTime').val(),
			executionCity: dealExecutionCity(),
			executionCityAddress: dealExecutionCityAddress(),
			qualityBenefit: $('#qualityBenefit').val(),
			quantifyBenefit: $('#quantifyBenefit').val(),
			planExecutionSituation: $('#planExecutionSituation').val(),
		},
		dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
		success: function(json) {
			if (showMsg == 'Y') {
				alert('資料已暫存');
			}
		},
		error: function(json) {
			alert(json);
		}
	});
}

function saveList(saveType, inputType) {
	
	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			workContent: $('#workContent').val(),
			friendlyMeasures: $('#friendlyMeasures').val(),
			employeeNumber: $('#employeeNumber').val(),
			beneficiaryNumber: $('#beneficiaryNumber').val(),
			subsidyType: $('#subsidyType').val(),
			amounts: $('#amounts').val(),
			multipleApplications: $('input[name="multipleApplications"]:checked').val(),
			multipleApplicationsDescription: $('#multipleApplicationsDescription').val(),
			applySameYear: $('input[name="applySameYear"]:checked').val(),
			applySameYearDescription: $('#applySameYearDescription').val(),
			planGoal: $('#planGoal').val(),
			planContent: $('#planContent').val(),
			planStartTime: $('#planStartTime').val(),
			planEndTime: $('#planEndTime').val(),
			executionCity: dealExecutionCity(),
			executionCityAddress: dealExecutionCityAddress(),
			qualityBenefit: $('#qualityBenefit').val(),
			quantifyBenefit: $('#quantifyBenefit').val(),
			planExecutionSituation: $('#planExecutionSituation').val(),
			attachBenefitList: inputType
		},
		dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
		beforeSend: function() {
			$('#loader-container').show();
		},
		success: function(json) {
			let list = [];
			$('#listStaff').find('li').each(function(index, value) {
				if ($(this).find('input[name^="identification"]').val() != '') {
					let data = {
						"name": $(this).find('input[name^="name"]').val(),
						"birthday": $(this).find('input[name^="birthday"]').val(),
						"identification": $(this).find('input[name^="identification"]').val(),
						"insuranceType": $(this).find('select[name^="insuranceType"]').val(),
						"insuranceTime": $(this).find('input[name^="insuranceTime"]').val(),
						"manager": $(this).find('select[name^="manager"]').val(),
						"workingHours": $(this).find('select[name^="workingHours"]').val()
					}
					list.push(data);
				}

			});
			$.ajax({
				type: "POST",
				url: 'addAdvancedAgeRetirementReemploymentBenefitList',
				data: JSON.stringify(list),
				dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
				contentType: "application/json",
				success: function(json) {
					if(saveType == 'temp' || saveType == 'total') {
						alert('資料已暫存');
						window.location.reload();
					}
					if(saveType == 'totalNext' && json=='success') {
						location.href='career_04';
					}
				},
				error: function(json) {
					alert('稍等5秒再試');
				},
				complete: function() {
					$('#loader-container').hide();
				}
			});
		},
		error: function(json) {
			alert(json);
		}
	});
}

function switchRequired() {
	if ($('#employed').find('a').attr('class') != '' && $('#employed').find('a').attr('class') != undefined) {
		$('input[name^="identification"]').parent().parent('li').find('input').attr('required', true);
		$('input[name^="identification"]').parent().parent('li').find('select').attr('required', true);
	} else {
		$('input[name^="identification"]').parent().parent('li').find('input').attr('required', false);
		$('input[name^="identification"]').parent().parent('li').find('select').attr('required', false);
	}
}

function fileUploadValid() {
	if ($('#excel').find('a').attr('class') != '' && $('#excel').find('a').attr('class') != undefined) {
		if($('#alreadyExist').attr('class') != undefined) {
			return true;
		} else {
			return false;
		}
	} else {
		return true;
	}	
}

function totalSave(saveType) {
	if ($('#employed').find('a').attr('class') != '' && $('#employed').find('a').attr('class') != undefined) {
		saveList(saveType, 'N');
	} else {
		saveList(saveType, 'Y');
	}
}

function next() {
	$('#form').validate();
	$('#listForm').validate();
	switchRequired();
	if($('#form').valid() && $('#listForm').valid() && fileUploadValid()){
		totalSave('totalNext');
	} else {
		alert('請確認資料是否填妥');
	}
}

function addExecutionCity(num) {
	$('button[onclick^="addExecutionCity"]').hide();
	$('.file_box.site').append(
			'<div class="full site">'+
	    	'<label for="executionCity'+(Number(num)+1)+'"></label> '+
			'<select name="executionCity" id="executionCity'+(Number(num)+1)+'" required>'+
	          '<option value>請選擇</option>'+
	          '<option value="A">臺北市</option>'+
			  '<option value="B">臺中市</option>'+
			  '<option value="C">基隆市</option>'+
			  '<option value="D">臺南市</option>'+
			  '<option value="E">高雄市</option>'+
			  '<option value="F">新北市</option>'+
			  '<option value="G">宜蘭縣</option>'+
			  '<option value="H">桃園市</option>'+
			  '<option value="I">嘉義市</option>'+
			  '<option value="J">新竹縣</option>'+
			  '<option value="K">苗栗縣</option>'+
			  '<option value="M">南投縣</option>'+
			  '<option value="N">彰化縣</option>'+
			  '<option value="O">新竹市</option>'+
			  '<option value="P">雲林縣</option>'+
			  '<option value="Q">嘉義縣</option>'+
			  '<option value="T">屏東縣</option>'+
			  '<option value="U">花蓮縣</option>'+
			  '<option value="V">臺東縣</option>'+
			  '<option value="W">金門縣</option>'+
			  '<option value="X">澎湖縣</option>'+
			  '<option value="Z">連江縣</option>'+
	        '</select>'+
			' <input type="text" id="executionCityAddress'+(Number(num)+1)+'" name="executionCityAddress'+(Number(num)+1)+'" size="61%" placeholder="請填寫詳細地址" required>'+
			' <button type="button" class="add" onclick="delExecutionCity('+(Number(num)+1)+')">－</button> '+
	      	'<button type="button" class="add" onclick="addExecutionCity('+(Number(num)+1)+')" style>＋</button>'+
	      	'</div>'
	      );
}

function delExecutionCity(num) {
	if($('select[id="executionCity'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('select[id="executionCity'+num+'"]').parent().remove();
		$('.full.site').last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('select[id="executionCity'+num+'"]').parent().remove();
	}
}

function dealExecutionCity() {
	let executionCity='';
	$('select[id^="executionCity"]').each(function(){
		if(executionCity=='')
		{
			executionCity=$(this).val();
		}
		else
		{
			executionCity=executionCity+';'+$(this).val();
		}
	});
	return executionCity;
}

function dealExecutionCityAddress() {
	let executionCityAddress='';
	$('input[id^="executionCityAddress"]').each(function(){
		if(executionCityAddress=='')
		{
			executionCityAddress=$(this).val();
		}
		else
		{
			executionCityAddress=executionCityAddress+';'+$(this).val();
		}
	});
	return executionCityAddress;
}

function listAdd() {
	maxNum = 1;
	let countli = $('#listStaff ol li').length;
	if (countli > 0) {
		maxNum = Number($('#listStaff').find('li').last().find('input[name^="name"]').attr('id').replace('name', '')) + 1;
	}
	if (countli < 5 && countli != 0) {
		listAddContent();
	}
	if (countli == 0) {
		maxNum = 1;
		listAddContent();
	}
}

function listAddContent() {
	$('#listStaff').find('ol').append('<li>' +
		'<div class="ss">' +
		'<label for="name' + maxNum + '">勞工姓名</label>  ' +
		'<input type="text" id="name' + maxNum + '" name="name">' +
		'</div>' +
		'<div class="ss">' +
		'<label for="birthday' + maxNum + '">出生日期</label>  ' +
		'<input type="text" id="birthday' + maxNum + '" name="birthday" placeholder="yyymmdd" readonly>' +
		'</div>' +
		'<div class="ss">' +
		'<label for="identification' + maxNum + '">身分證字號</label>  ' +
		'<input type="text" id="identification' + maxNum + '" name="identification">' +
		'</div>' +
		'<div class="ss">' +
		'<label for="insuranceType' + maxNum + '">保險類型</label>  ' +
		'<select id="insuranceType' + maxNum + '" name="insuranceType">' +
		'  <option value>請選擇</option>' +
		'  <option value="1">勞工保險</option>' +
		'  <option value="2">職災保險</option>' +
		'</select>' +
		'</div>' +
		'<div class="ss">' +
		'<label for="insuranceTime' + maxNum + '">加保日期</label>  ' +
		'<input type="text" id="insuranceTime' + maxNum + '" name="insuranceTime" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')" readonly>' +
		'</div>' +
		'<div class="ss">'+
	    '<label for="manager'+maxNum+'">職務類型</label>  '+
	    '<select id="manager'+maxNum+'" name="manager">'+
	    '  <option value>請選擇</option>'+
	    '  <option value="Y">主管</option>'+
	    '  <option value="N">非主管</option>'+
	    '</select>'+
	    '</div>'+
	    '<div class="ss">'+
	    '<label for="workingHours'+maxNum+'">工時類型</label>  '+
	    '<select id="workingHours'+maxNum+'" name="workingHours">'+
	    '  <option value>請選擇</option>'+
	    '  <option value="A">全時</option>'+
	    '  <option value="P">部分工時</option>'+
	    '</select>'+
	    '</div>'+
		'<div class="close"><button type="button" onclick="delBenefitList(this)" class="close" title="移除此筆資料">X</button></div>' +
		'</li>');

	$('input[name^="identification"]').change(function() {
		if ($(this).val().length > 0) {
			$(this).parent().parent('li').find('input').attr('required', true);
			$(this).parent().parent('li').find('select').attr('required', true);
		}
		else {
			$(this).parent().parent('li').find('input').attr('required', false);
			$(this).parent().parent('li').find('select').attr('required', false);
			$(this).parent().parent('li').find('input').removeClass();
			$(this).parent().parent('li').find('select').removeClass();
			$(this).parent().parent('li').find('label.error').remove();
		}
	});
}

function delBenefitList(item) {
	if (confirm('是否確定要移除？')) {
		let path = $(item).parent().parent('li');
		$.ajax({
			type: "POST",
			url: 'delAdvancedAgeRetirementReemploymentBenefitList',
			data: {
				identification: $(item).parent().parent('li').find('input[name^="identification"]').val()
			},
			dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
			success: function(json) {
				if (json == 'success') {
					path.remove();
				}
			}
		})
	}
	return false;
}

function fileUpload(showMsg) {
	
	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			workContent: $('#workContent').val(),
			attachBenefitList: 'Y'
			//			attachFriendlyMeasures : $('#attachFriendlyMeasures').val()==''?'N':'Y',
			//			friendlyMeasures : $('#friendlyMeasures').val(),
			//			attachAssistanceMeasures : $('#attachAssistanceMeasures').val()==''?'N':'Y',
			//			assistanceMeasures : $('#assistanceMeasures').val(),
			//			attachExpectedMeasuresEffectiveness : $('#attachExpectedMeasuresEffectiveness').val()==''?'N':'Y',
			//			expectedMeasuresEffectiveness : $('#expectedMeasuresEffectiveness').val()
		},
		dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
		success: function(json) {
			if ($('#uploadFile').val() != '') {
				let file = new FormData();
				file.append('uploadFile', $('#uploadFile').get(0).files[0]);
				$.confirm({
					title: '上傳前確認',
					animation: 'zoom',
					closeAnimation: 'scale',
					content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
					buttons: {
						確認: function() {
							$.ajax({
								type: 'post',
								url: 'addAdvancedAgeRetirementReemploymentBenefitListFromFile',// 資料不需要編碼
								enctype: 'multipart/form-data',
								contentType: false,// 資料物件不需要轉換成鍵值對格式
								processData: false,
								data: file,
								beforeSend: function() {
									$('#loader-container').show();
								},
								success: function(res) {
									// 判斷是否接收成功
									if (res == 'success') {
										alert('檔案已上傳');
										window.location.reload();
									} else {
										alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
										
									}
								},
								complete: function() {
									$('#loader-container').hide();
								}
							});
						},
						取消: function() {
//							$('#loader-container').hide();
						}
					}
				});

			}
			else {
				alert('請選擇上傳檔案');
//				$('#loader-container').hide();
			}
		},
		error: function(json) {
			alert(json);
//			$('#loader-container').hide();
		}
	});

}

function presentCheckBoxStatus() {
	var subsidyType = $('#subsidyType').val();
	if (subsidyType != '') {
		subsidyType = Number(subsidyType);
	}
	switch (subsidyType) {
		case 1:
			$('#CheckboxGroup1_0').attr('checked', true);
			break;
		case 2:
			$('#CheckboxGroup1_1').attr('checked', true);
			break;
		case 4:
			$('#CheckboxGroup1_2').attr('checked', true);
			break;
		case 3:
			$('#CheckboxGroup1_0').attr('checked', true);
			$('#CheckboxGroup1_1').attr('checked', true);
			break;
		case 5:
			$('#CheckboxGroup1_0').attr('checked', true);
			$('#CheckboxGroup1_2').attr('checked', true);
			break;
		case 6:
			$('#CheckboxGroup1_1').attr('checked', true);
			$('#CheckboxGroup1_2').attr('checked', true);
			break;
		case 7:
			$('#CheckboxGroup1_0').attr('checked', true);
			$('#CheckboxGroup1_1').attr('checked', true);
			$('#CheckboxGroup1_2').attr('checked', true);
			break;
	}
}
