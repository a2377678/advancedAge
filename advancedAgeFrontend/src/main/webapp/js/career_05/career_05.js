$(function() {

	if ($('#list').find('a').attr('class') != '' && $('#list').find('a').attr('class') != undefined) {
		$('#listStaff').hide();
		$('#listTable').show();
	}
	$('#employed').click(function() {
		$('#list').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').show();
		$('#listTable').hide();
	})

	$('#list').click(function() {
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').hide();
		$('#listTable').show();
	})
	
	$('input[name="hasJointUnit"]').change(function() {
		switch($(this).val()) {
		    case 'N':
		    	inputDisabled()
		      break
		    case 'Y':
		    	$('input[name^="companyName"]').removeAttr("disabled")
				$('input[name^="seq"]').removeAttr("disabled")
				$('select[name^="industry"]').removeAttr("disabled")
				$('select[name^="unitSize"]').removeAttr("disabled")
				$('input[name^="guaranteeNumber"]').removeAttr("disabled")
				$('button.add').removeAttr("disabled")
				$('input[name^="principal"]').removeAttr("disabled")
				$('input[name^="contactName"]').removeAttr("disabled")
				$('input[name^="contactWorkPhoneAreaCode"]').removeAttr("disabled")
				$('input[name^="contactWorkPhone"]').removeAttr("disabled")
				$('input[name^="contactWorkPhoneExtension"]').removeAttr("disabled")
				$('input[name^="contactPhone"]').removeAttr("disabled")
				$('input[name^="email"]').removeAttr("disabled")
				$('textarea[name^="businessItem"]').removeAttr("disabled")
				$('input[name^="employeeNumber"]').removeAttr("disabled")
				$('input[name^="participateNumber"]').removeAttr("disabled")
				$('input[name^="uploadFile"]').removeAttr("disabled")
				$('button.upload').removeAttr("disabled")
		      break
		}
	})
	if($('input[id="hasJointUnit1"]').attr('checked') == 'checked') {
		inputDisabled()
	}
})

function inputDisabled() {
	$('input[name^="companyName"]').attr("disabled", "disabled")
	$('input[name^="seq"]').attr("disabled", "disabled")
	$('select[name^="industry"]').attr("disabled", "disabled")
	$('select[name^="unitSize"]').attr("disabled", "disabled")
	$('input[name^="guaranteeNumber"]').attr("disabled", "disabled")
	$('button.add').attr("disabled", "disabled")
	$('input[name^="principal"]').attr("disabled", "disabled")
	$('input[name^="contactName"]').attr("disabled", "disabled")
	$('input[name^="contactWorkPhoneAreaCode"]').attr("disabled", "disabled")
	$('input[name^="contactWorkPhone"]').attr("disabled", "disabled")
	$('input[name^="contactWorkPhoneExtension"]').attr("disabled", "disabled")
	$('input[name^="contactPhone"]').attr("disabled", "disabled")
	$('input[name^="email"]').attr("disabled", "disabled")
	$('textarea[name^="businessItem"]').attr("disabled", "disabled")
	$('input[name^="employeeNumber"]').attr("disabled", "disabled")
	$('input[name^="participateNumber"]').attr("disabled", "disabled")
	$('input[name^="uploadFile"]').attr("disabled", "disabled")
	$('button.upload').attr("disabled", "disabled")
}

function addGuarantee(item, num) {
	$(item).hide();
	var n = Number($(item).parent().find('input[name^="guaranteeNumber"]').attr('name').replace('guaranteeNumber', ''));
	$('#file_box' + n).append('<div class="full"> ' +
		'<label for="guaranteeNumber' + n + '_' + (Number(num) + 1) + '"></label> ' +
		'<input type="text" id="guaranteeNumber' + n + '_' + (Number(num) + 1) + '" name="guaranteeNumber' + n + '"> ' +
		'<button type="button" class="add" onclick="delGuarantee(this,' + (Number(num) + 1) + ')">－</button> ' +
		'<button type="button" class="add" onclick="addGuarantee(this,' + (Number(num) + 1) + ')" style>＋</button>' +
		'</div>');
}

function delGuarantee(item, num) {
	if ($(item).next().attr('style') == '') {
		var fileBox = $(item).parent().parent();
		$(item).parent().remove();
		fileBox.find('div').last().find('button[onclick^="add"]').show();
	}
	else {
		$(item).parent().remove();
	}

}

function listAdd() {
	maxNum = 1;
	let countli = $('#listStaff ol li').length;
	if (countli > 0) {
		maxNum = Number($('#listStaff').find('li').last().find('input[name^="seq"]').attr('id').replace('seq', '')) + 1;
	}
	if (countli < 2 && countli != 0) {
		listAddContent();
	}
	if (countli == 0) {
		maxNum = 1;
		listAddContent();
	}
}

function listAddContent() {
	$('#listStaff').find('ol').append(
		'<li>' +
		'<div>' +
		'<label for="companyName' + maxNum + '">單位名稱</label>' +
		'<input type="text" name="companyName' + maxNum + '" id="companyName' + maxNum + '">' +
		'</div>' +
		'<div>' +
		'<label for="seq' + maxNum + '">統一編號</label>' +
		'<input type="text" name="seq' + maxNum + '" id="seq' + maxNum + '">' +
		'</div>' +
		'<div class="full">' +
		'<label for="businessItem' + maxNum + '">主要營業項目</label>' +
		'<textarea class="s" name="businessItem' + maxNum + '" id="businessItem' + maxNum + '" rows="1" placeholder="主要業務、產品、服務項目 ( 輸入框可拖曳加大範圍 )"></textarea>' +
		'</div>' +
		'<div>' +
		'<label for="industry' + maxNum + '">行業別</label>' +
		'<select name="industry' + maxNum + '" id="industry' + maxNum + '">' +
		'<option value>請選擇</option>' +
		'<option value="A">農、林、漁、牧業</option>' +
		'<option value="B">礦業及土石採取業</option>' +
		'<option value="C">製造業</option>' +
		'<option value="D">電力及燃氣供應業</option>' +
		'<option value="E">用水供應及污染整治業</option>' +
		'<option value="F">營建工程業</option>' +
		'<option value="G">批發及零售業</option>' +
		'<option value="H">運輸及倉儲業</option>' +
		'<option value="I">住宿及餐飲業</option>' +
		'<option value="J">出版、影音製作、傳播及資通訊服務業</option>' +
		'<option value="K">金融及保險業</option>' +
		'<option value="L">不動產業</option>' +
		'<option value="M">專業、科學及技術服務業</option>' +
		'<option value="N">支援服務業</option>' +
		'<option value="O">公共行政及國防；強制性社會安全</option>' +
		'<option value="P">教育業</option>' +
		'<option value="Q">醫療保健及社會工作服務業</option>' +
		'<option value="R">藝術、娛樂及休閒服務業</option>' +
		'<option value="S">其他服務業</option>' +
		'</select>' +
		'<a href="https://mobile.stat.gov.tw/StandardIndustrialQuery.aspx" target="_blank" title="(另開新視窗)"><img src="images/icon_qu.png" alt="行業別分類說明"></a>' +
		'</div>' +
		'<div>' +
		'<label for="unitSize' + maxNum + '">單位規模</label>' +
		'<select name="unitSize' + maxNum + '" id="unitSize' + maxNum + '">' +
		'<option value>請選擇</option>' +
		'<option value="29人以下">29人以下</option>' +
		'<option value="30~99人">30~99人</option>' +
		'<option value="100~499人">100~499人</option>' +
		'<option value="500人以上">500人以上</option>' +
		'<option value="不明">不明</option>' +
		'</select>' +
		'</div>' +
		'<div class="file_box" id="file_box' + maxNum + '">' +
		'<div class="full">' +
		'<label for="guaranteeNumber' + maxNum + '_1">勞保投保證號</label>' +
		'<input type="text" id="guaranteeNumber' + maxNum + '_1" name="guaranteeNumber' + maxNum + '" required>' +
		'<button type="button" class="add" onclick="addGuarantee(this,1)" style>＋</button>' +
		'</div>' +
		'</div>' +
		'<div>' +
		'<label for="principal' + maxNum + '">負責人</label>' +
		'<input type="text" name="principal' + maxNum + '" id="principal' + maxNum + '">' +
		'</div>' +
		'<div>' +
		'<label for="contactName' + maxNum + '">聯絡人</label>' +
		'<input type="text" name="contactName' + maxNum + '" id="contactName' + maxNum + '">' +
		'</div>' +
		'<div>' +
		'<label for="contactWorkPhone' + maxNum + '">聯絡電話</label>' +
		'<input type="tel" maxlength="3" id="contactWorkPhoneAreaCode' + maxNum + '" name="contactWorkPhoneAreaCode' + maxNum + '" size="2" placeholder="區碼"> -' +
		'<input type="tel" maxlength="8" id="contactWorkPhone' + maxNum + '" name="contactWorkPhone' + maxNum + '" size="12" placeholder="電話號碼"> #' +
		'<input type="tel" maxlength="6" id="contactWorkPhoneExtension' + maxNum + '" name="contactWorkPhoneExtension' + maxNum + '" size="3" placeholder="分機">' +
		'</div>' +
		'<div>' +
		'<label for="contactPhone' + maxNum + '">聯絡手機</label>' +
		'<input type="tel" name="contactPhone' + maxNum + '" id="contactPhone' + maxNum + '" pattern="09\\d{8}" placeholder="聯絡手機號碼">' +
		'</div>' +
		'<div class="full">' +
		'<label for="email' + maxNum + '">電子信箱</label>' +
		'<input type="tel" name="email' + maxNum + '" id="email' + maxNum + '">' +
		'</div>' +
		'<div>' +
		'<label for="employeeNumber' + maxNum + '">員工人數</label>' +
		'<input type="number" name="employeeNumber' + maxNum + '" id="employeeNumber' + maxNum + '" step="1" min="0">' +
		'</div>' +
		'<div>' +
		'<label for="participateNumber' + maxNum + '">預計參與人數</label>' +
		'<input type="number" name="participateNumber' + maxNum + '" id="participateNumber' + maxNum + '" step="1" min="0">' +
		'</div>' +
		'<div class="close"><button type="button" class="close" onclick="delItem(this);" title="移除此筆資料">X</button></div>' +
		'</li>'
	);
}

function delItem(item) {
	if (confirm('是否確定要移除？')) {
		let path = $(item).parent().parent('li');
		$.ajax({
			type: "POST",
			url: 'delAdvancedAgeRetirementReemploymentBasicData',
			data: {
				seq: $(item).parent().parent('li').find('input[name^="seq"]').val()
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

function saveList(saveType, inputType) {
	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			planID: $('#planID').val(),
			attachBasicData: inputType,
			hasJointUnit: $('input[name="hasJointUnit"]:checked').val()
		},
		dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
		beforeSend: function() {
			$('#loader-container').show();
		},
		success: function(json) {
			let list = [];
			$('#listStaff').find('li').each(function(index, value) {
				if ($(this).find('input[name^="seq"]').val() != '') {
					let guarantee = '';
					let num=$(this).find('input[name^="seq"]').attr('id').replace('seq','');
					$(this).find('input[name^="guaranteeNumber"]').each(function() {
						if (guarantee == '') {
							guarantee = $(this).val();
						}
						else {
							guarantee = guarantee + ';' + $(this).val();
						}
					});
					let data = {
						"companyName": $(this).find('input[name^="companyName"]').val(),
						"seq": $(this).find('input[name^="seq"]').val(),
						"industry": $(this).find('select[name^="industry"]').val(),
						"unitSize": $(this).find('select[name^="unitSize"]').val(),
						"guaranteeNumber": guarantee,
						"principal": $(this).find('input[name^="principal"]').val(),
						"contactName": $(this).find('input[name^="contactName"]').val(),
						"contactWorkPhoneAreaCode": $('input[name^="contactWorkPhoneAreaCode"]').val(),
						"contactWorkPhone": $('input[name^="contactWorkPhone'+num+'"]').val(),
						"contactWorkPhoneExtension": $('input[name^="contactWorkPhoneExtension"]').val(),
						"contactPhone": $(this).find('input[name^="contactPhone"]').val(),
						"email": $(this).find('input[name^="email"]').val(),
						"businessItem": $(this).find('textarea[name^="businessItem"]').val(),
						"employeeNumber": $(this).find('input[name^="employeeNumber"]').val(),
						"participateNumber": $(this).find('input[name^="participateNumber"]').val(),
					}
					list.push(data);
				}

			});
			$.ajax({
				type: "POST",
				url: 'addAdvancedAgeRetirementReemploymentBasicData',
				data: JSON.stringify(list),
				dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
				contentType: "application/json",
				success: function(json) {
					if (saveType == 'temp' || saveType == 'total') {
						alert('資料已暫存');
						window.location.reload();
					}
					if (saveType == 'totalNext' && json == 'success') {
						location.href = 'career_06';
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

function fileUpload(showMsg) {

	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			planID: $('#planID').val(),
			attachBasicData: 'Y',
			hasJointUnit: 'Y'
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
								url: 'addAdvancedAgeRetirementReemploymentBasicDataFromFile',// 資料不需要編碼
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

function noJointUnitAction() {
	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			planID: $('#planID').val(),
			hasJointUnit: 'N'
		},
		dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
		success: function(json) {
			if (json == 'success') {
				location.href = 'career_06';
			}
		},
		error: function(json) {
			alert(json);
			//			$('#loader-container').hide();
		}
	});
}

function switchRequired() {
	if ($('#employed').find('a').attr('class') != '' && $('#employed').find('a').attr('class') != undefined) {
		$('input[name^="seq"]').parent().parent('li').find('input').attr('required', true);
		$('input[name^="seq"]').parent().parent('li').find('select').attr('required', true);
		$('input[name^="seq"]').parent().parent('li').find('textarea').attr('required', true);
		$('input[name^="contactWorkPhoneExtension"]').attr('required', false);
	} else {
		$('input[name^="seq"]').parent().parent('li').find('input').attr('required', false);
		$('input[name^="seq"]').parent().parent('li').find('select').attr('required', false);
		$('input[name^="seq"]').parent().parent('li').find('textarea').attr('required', false);
		$('input[name^="contactWorkPhoneExtension"]').attr('required', false);
	}
}

function fileUploadValid() {
	if ($('#list').find('a').attr('class') != '' && $('#list').find('a').attr('class') != undefined) {
		if ($('#alreadyExist').attr('class') != undefined) {
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
	if($('input[name="hasJointUnit"]:checked').val() == 'Y') {
		$('#listForm').validate();
		switchRequired();
		if ($('#listForm').valid() && fileUploadValid()) {
			totalSave('totalNext');
		} else {
			alert('請確認資料是否填妥');
		}
	}else {
		noJointUnitAction();
	}
}