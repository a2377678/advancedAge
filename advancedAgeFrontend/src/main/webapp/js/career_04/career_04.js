$(function(){
	
	if ($('#list').find('a').attr('class') != '' && $('#list').find('a').attr('class') != undefined) {
		$('#listStaff').hide();
		$('#listTable').show();
	}
	$('#employed').click(function(){
		$('#list').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').show();
		$('#listTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#listStaff').hide();
		$('#listTable').show();
	})
	
	$('#listStaff').find('li').each(function() {
		var li_el = $(this);
		var unitPrice_input_el = li_el.find('input[name^="unitPrice"]');
		var quantity_input_el = li_el.find('input[id^="quantity"]');
		var toatl_input_el = li_el.find('input[name^="total"]');
		if(unitPrice_input_el.val() != '' && quantity_input_el.val() != '') {
			toatl_input_el.val(Number(unitPrice_input_el.val()) * Number(quantity_input_el.val()));
		}
	});
	
	console.log($('#alreadyExist').attr('class'));
})

function listAdd() {
	maxNum = 1;
	let countli = $('#listStaff ol li').length;
	if (countli > 0) {
		maxNum = Number($('#listStaff').find('li').last().find('select[name^="planName"]').attr('id').replace('planName', '')) + 1;
	}
	if (countli < 10 && countli != 0) {
		listAddContent();
	}
	if (countli == 0) {
		maxNum = 1;
		listAddContent();
	}
}

function listAddContent() {
	$('#listStaff').find('ol').append(
				'<li>'+
		          '<div class="s">'+
			          '<label for="planName'+maxNum+'">編列項目</label>'+
			          '<select name="planName'+maxNum+'" id="planName'+maxNum+'" class="planName">'+
			            '<option value>請選擇</option>'+
			            '<option value="個別職涯諮商及輔導費">1. 諮詢費</option>'+
			            '<option value="講師鐘點費">2. 講師鐘點費</option>'+
			            '<option value="講師交通費">3. 講師交通費</option>'+
			            '<option value="非自有場地費">4. 場地租借費</option>'+
			            '<option value="場地公共意外險">5. 公共意外險</option>'+
			            '<option value="資料印製費">6. 資料印製費</option>'+
			            '<option value="行政費">7. 行政費</option>'+
			          '</select>'+
		          '</div>'+
		          '<div class="s">'+
			          '<label for="unitPrice'+maxNum+'">單價</label>'+
			          '<input type="number" name="unitPrice'+maxNum+'" id="unitPrice'+maxNum+'" step="1" min="0" onchange="calTotal(this);"> 元'+
		          '</div>'+
		          '<div class="s">'+
			          '<label for="amount'+maxNum+'">數量</label>'+
			          '<input type="number" name="amount'+maxNum+'" id="quantity'+maxNum+'" step="1" min="0" onchange="calTotal(this);">'+
		          '</div>'+
		          '<div class="s">'+
			          '<label for="total'+maxNum+'">總價</label>'+
			          '<input type="text" name="total'+maxNum+'" id="total'+maxNum+'" class="readonly" placeholder="填寫完自動計算" readonly> 元'+
		          '</div>'+
		          '<div class="s">'+
			          '<label for="amounts'+maxNum+'">申請本計畫補助</label>'+
			          '<input type="number" name="amounts'+maxNum+'" id="amounts'+maxNum+'"  step="1" min="0"> 元'+
		          '</div>'+
		          '<div class="s">'+
			          '<label for="other_amounts'+maxNum+'">申請其他單位補助</label>'+
			          '<input type="number" name="otherAmounts'+maxNum+'" id="otherAmounts'+maxNum+'" step="1" min="0" placeholder=" ( 無則免填 )"> 元'+
		          '</div>'+
		          '<div class="full">'+
		          '<label for="description'+maxNum+'">備註與說明</label>'+
		          '<textarea class="s" name="description'+maxNum+'" id="description'+maxNum+'" rows="2" placeholder=" ( 輸入框可拖曳加大範圍 )"></textarea>'+
		          '</div>'+
		          '<div class="close"><button type="button" class="close" onclick="delItem(this);" title="移除此筆資料">X</button></div>'+
		        '</li>'
		        );
}

function delItem(item) {
	if (confirm('是否確定要移除？')) {
		let path = $(item).parent().parent('li');
		$.ajax({
			type: "POST",
			url: 'delAdvancedAgeRetirementReemploymentExpenditure',
			data: {
				id: $(item).parent().parent('li').find('input[name^="id"]').val()
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

function calTotal(item) {
	var li_el = $(item).parent().parent();
	var unitPrice_input_el = li_el.find('input[name^="unitPrice"]');
	var quantity_input_el = li_el.find('input[id^="quantity"]');
	var toatl_input_el = li_el.find('input[name^="total"]');
	if(unitPrice_input_el.val() != '' && quantity_input_el.val() != '') {
		toatl_input_el.val(Number(unitPrice_input_el.val()) * Number(quantity_input_el.val()));
	}
}

function saveList(saveType, inputType) {
	$.ajax({
		type: "POST",
		url: 'addAdvancedAgeRetirementReemploymentPlan',
		data: {
			attachExpenditure: inputType
		},
		dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
		beforeSend: function() {
			$('#loader-container').show();
		},
		success: function(json) {
			let list = [];
			$('#listStaff').find('li').each(function(index, value) {
				if ($(this).find('select[name^="planName"]').val() != '') {
					let data = {
						"id": $(this).find('input[name^="id"]').val(),
						"planName": $(this).find('select[name^="planName"]').val(),
						"unitPrice": $(this).find('input[name^="unitPrice"]').val(),
						"amount": $(this).find('input[id^="quantity"]').val(),
						"amounts": $(this).find('input[name^="amounts"]').val(),
						"otherAmounts": $(this).find('input[name^="otherAmounts"]').val(),
						"description": $(this).find('textarea[name^="description"]').val()
					}
					list.push(data);
				}

			});
			$.ajax({
				type: "POST",
				url: 'addAdvancedAgeRetirementReemploymentExpenditure',
				data: JSON.stringify(list),
				dataType: "text", //ajax返回值text（json格式也可用這返回，也可設成json）
				contentType: "application/json",
				success: function(json) {
					if(saveType == 'temp' || saveType == 'total') {
						alert('資料已暫存');
						window.location.reload();
					}
					if(saveType == 'totalNext' && json=='success') {
						location.href='career_05';
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
			attachExpenditure: 'Y'
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
								url: 'addAdvancedAgeRetirementReemploymentExpenditureFromFile',// 資料不需要編碼
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

function switchRequired() {
	if ($('#employed').find('a').attr('class') != '' && $('#employed').find('a').attr('class') != undefined) {
		$('select[name^="planName"]').attr('required', true);
		$('input[name^="unitPrice"]').attr('required', true);
		$('input[name^="amount"]').attr('required', true);
		$('input[name^="amounts"]').attr('required', true);
	} else {
		$('select[name^="planName"]').attr('required', false);
		$('input[name^="unitPrice"]').attr('required', false);
		$('input[name^="amount"]').attr('required', false);
		$('input[name^="amounts"]').attr('required', false);
	}
}

function fileUploadValid() {
	if ($('#list').find('a').attr('class') != '' && $('#list').find('a').attr('class') != undefined) {
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
	$('#listForm').validate();
	switchRequired();
	if($('#listForm').valid() && fileUploadValid()){
		totalSave('totalNext');
	} else {
		alert('請確認資料是否填妥');
	}
}