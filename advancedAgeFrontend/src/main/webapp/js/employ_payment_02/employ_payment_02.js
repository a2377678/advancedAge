$(function(){
	$('#listForm').validate();
	let oj={},ar=[];
	oj.abc="qwe";
	oj.qqq="bbb";
	ar.push(oj)
//	alert(JSON.stringify(ar));
	
	$('input[name^="count"]').change(function(){
		if($(this).parent().parent().find('select[name^="frequency"]').val()==1){
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*13000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*70));
			}
		}else{
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*15000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*80));
			}
		}
	});
	
	$('button.add').click(function(){
		if($(this).html()=="－")
		{
			$(this).parent().parent().find('.add').show();
			$(this).parent().remove();
		}
	})	
	
	$('button.close').click(function(){
		if(confirm('是否確定要移除？'))
		{
			let path=$(this).parent().parent('li');
			$.ajax({
			    type: "POST",
			    url: 'delAdvancedAgeEmploymentListReceipt',
			    data: {
					identification : $(this).parent().parent('li').find('input[name^="identification"]').val(),
					frequency : $(this).parent().parent('li').find('select[name^="frequency"]').val(),
					advancedAgeBaseId : $('#baseId').val() ,
					seq : $('#seq').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){
					if(json=='success'){
						path.remove();
					}
				}
			})
		}
		return false;
	});
	
	$('input[name^="identification"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
		}
	})
	$('input[name^="identification"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
		}
	})
	
})
function showNewSalaryType(num){
	$('#employedTable'+num).find('.add').hide();
	$('#employedTable'+num).find('.px-4').before('<div class="m w-100 point-2" id="employedTable'+num+'2"> '+
            '<label for="salaryType'+num+'2">請領補助 </label> '+
            '<select id="salaryType'+num+'2" name="salaryType'+num+'2"> '+
              '<option value>請選擇</option> '+
              '<option value="M">按月計</option> '+
              '<option value="H">按時計</option> '+
            '</select> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【按月計酬】\n '+
' 第1-6個月每人每月補助 13,000 元。\n '+
' 第7-18個月每人每月補助 15,000 元。\n\n '+
'【非按月計酬】\n '+
' 第1-6個月每人每小時補助 70 元，\n '+
' 每月最高補助 13,000 元。\n '+
' 第7-18個月每人每小時補助 80 元，\n '+
' 每月最高補有 15,000 元。">\n '+
            '<label for="">申請期間 </label> '+
           	'<input type="text" class="short-2" id="employmentStartTime'+num+'2" name="employmentStartTime'+num+'2" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')"> 至  '+
            '<input type="text" class="short-2" id="employmentEndTime'+num+'2" name="employmentEndTime'+num+'2" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')>"> '+
            '<label for="">月數 / 時數 </label> '+
            '<input type="number" class="short" step="1" min="0" id="count'+num+'2" name="count'+num+'2"> '+
            '<label for="">請領金額 </label> '+
            '<input type="text" id="amounts'+num+'2" name="amounts'+num+'2" class="readonly" placeholder="自動計算" readonly> '+
            '<button class="add">－</button> '+
          '</div>');
	$('#employedTable'+num+'2').find('.add').click(function(){
		$('#employedTable'+num+'2').find('.add').show();
		$('#employedTable'+num+'2').remove();
	})	
	
	$('input[name^="count"]').change(function(){
		
		if($(this).parent().parent().find('select[name^="frequency"]').val()==1){
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*13000);
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*70);
			}
		}else{
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*15000);
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val())*80);
			}
		}
	})
}

function listAdd(){
	maxNum=Number($('#employedTable').find('li').last().find('input[name^="name"]').attr('id').replace('name',''))+1;
	$('#employedTable').find('ol').append('<li id="employedTable'+maxNum+'"> '+
          '<div class="ss"> '+
          '<label for="name'+maxNum+'">勞工姓名</label> '+
		  '<input type="text" id="name'+maxNum+'" name="name'+maxNum+'"> '+
          '</div> '+
          
          '<div class="ss"> '+
          '<label for="identification1">身分證字號</label> '+
          '<input type="text" id="identification'+maxNum+'" name="identification'+maxNum+'"> '+
          '</div> '+
        
          '<div class="ss"> '+
          '<label for="insuranceType'+maxNum+'">退保(離職)</label> '+
          '<select id="insuranceType'+maxNum+'" name="insuranceType'+maxNum+'"> '+
            '<option value>請選擇</option> '+
            '<option value="1">勞工保險</option> '+
            '<option value="2">職災保險</option> '+
          '</select> '+
          '<img src="images/icon_qu.png" class="icon_qu" title="仍加保中免填"> '+
          '</div> '+
        
          '<div class="ss"> '+
          '<label for="insuranceTime'+maxNum+'">退保日期</label> '+
          '<input type="text" id="insuranceTime'+maxNum+'" name="insuranceTime'+maxNum+'" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')"> '+
          '</div> '+
        
          '<div class="ss"> '+
            '<label for="salary'+maxNum+'">平均薪資</label> '+
            '<input type="text" id="salary'+maxNum+'" name="salary'+maxNum+'" placeholder="每月平均薪資" pattern="[0-9]"> '+
          '</div> '+
          
          '<div class="m"> '+
            '<label for="salaryMethod'+maxNum+'">計薪方式 '+
            '</label> '+
            '<select id="salaryMethod'+maxNum+'" name="salaryMethod'+maxNum+'"> '+
              '<option value>請選擇</option> '+
              '<option value="M">按月計</option> '+
              '<option value="H">非按月</option> '+
              '<option value="MH">部分按月，部分非按月</option> '+
            '</select> '+
            '<input type="text" class="w-50" id="salaryMethodRemark'+maxNum+'" name="salaryMethodRemark'+maxNum+'" placeholder="例：7月95小時, 8月106小時..."> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【按月計】免填備註\n '+
'【非按月】請敘明每月時數\n '+
' 如：7月95小時, 8月106小時..."> '+
          '</div> '+
        
          '<div class="ss"> '+
          '<label for="frequency'+maxNum+'">請領次數</label> '+
          '<select id="frequency'+maxNum+'" name="frequency'+maxNum+'"> '+
            '<option value>請選擇</option> '+
            '<option value="1">第1次</option> '+
            '<option value="2">第2次</option> '+
            '<option value="3">第3次</option> '+
            '<option value="4">第4次</option> '+
            '<option value="5">第5次</option> '+
          '</select> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【第1次】請領期間為前6個月\n '+
 '，未滿6個月不予發給。\n\n '+
'【第2~5次】請領申請期間，\n '+
 '為第7~18個月，最長12個月。"> '+
          '</div> '+
        
          '<div class="m w-100 point-2"> '+
            '<label for="">請領補助</label> '+
            '<select id="salaryType'+maxNum+'1" name="salaryType'+maxNum+'1"> '+
              '<option value>請選擇</option> '+
              '<option value="M">按月計</option> '+
              '<option value="H">按時計</option> '+
            '</select> '+
            '<img src="images/icon_qu.png" class="icon_qu" title=" '+
'【按月計酬】\n '+
 '第1-6個月每人每月補助 13,000 元。\n '+
 '第7-18個月每人每月補助 15,000 元。\n\n '+
'【非按月計酬】\n '+
 '第1-6個月每人每小時補助 70 元，\n '+
 '每月最高補助 13,000 元。\n '+
 '第7-18個月每人每小時補助 80 元，\n '+
 '每月最高補有 15,000 元。"> '+

            '<label for="">申請期間</label> '+
            '<input type="text" class="short-2" id="employmentStartTime'+maxNum+'1" name="employmentStartTime'+maxNum+'1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')"> 至 '+
            '<input type="text" class="short-2" id="employmentEndTime'+maxNum+'1" name="employmentEndTime'+maxNum+'1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^0-9]/g,\'\')"> '+

            '<label for="">月數 / 時數</label> '+
            '<input type="number" class="short" step="1" min="0" id="count'+maxNum+'1" name="count'+maxNum+'1"> '+
            '<label for="">請領金額</label> '+
            '<input type="text" id="amounts'+maxNum+'1" name="amounts'+maxNum+'1" class="readonly" placeholder="自動計算" readonly> '+
            '<button type="button" class="add" onclick="showNewSalaryType('+maxNum+')">＋</button> '+
          '</div> '+
          
          '<div class="px-4">（請領若有2種計薪方式，請按右方+按鈕增加欄位）</div>   '+ 
          '<div class="close"><button class="close" title="移除此筆資料">X</button></div></li>');

	$('input[name^="count"]').change(function(){
		if($(this).parent().parent().find('select[name^="frequency"]').val()==1){
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*13000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*70));
			}
		}else{
			if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*15000));
			}else if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
				$(this).parent().find('input[name^="amounts"]').val(Number($(this).val()*80));
			}
		}
	});
	
	$('button.close').click(function(){
		$.ajax({
		    type: "POST",
		    url: 'delAdvancedAgeEmploymentListReceipt',
		    data: {
				advancedAgeBaseId : $('#baseId').val(),
				identification : $(this).parent().parent('li').find('input[name^="identification"]').val(),
				frequency : $(this).parent().parent('li').find('select[name^="frequency"]').val(),
				seq : $('#seq').val()
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){
				
			}
		})
		$(this).parent().parent('li').remove();
	});
	
	$('input[name^="identification"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('select').attr('required',true);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
		}
		else
		{
			$(this).parent().parent('li').find('input').attr('required',false);
			$(this).parent().parent('li').find('select').attr('required',false);
			$('select[name^="insuranceType"]').attr('required',false);
			$('input[name^="insuranceTime"]').attr('required',false);
			$('input[name^="salaryMethodRemark"]').attr('required',false);
			$(this).parent().parent('li').find('input').removeClass('error');
			$(this).parent().parent('li').find('select').removeClass('error');
			$(this).parent().parent('li').find('label.error').remove();
		}
	});
}

function listSave(){
	
	let data={},list=[],totalAmount=0;
	if($('#listForm').valid()){
		$('#loader-container').show();
	$('#employedTable').find('li').each(function(){
		data={};
		if($(this).find('input[name^="identification"]').val()!='')
		{
			data.seq=$('#seq').val();
			data.advancedAgeBaseId=$('#baseId').val();
			data.name=$(this).find('input[name^="name"]').val();
			data.identification=$(this).find('input[name^="identification"]').val();
			if($(this).find('select[name^="insuranceType"]').val()==1){
				data.laborProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
			}else if($(this).find('select[name^="insuranceType"]').val()==2){
				data.occupationalAccidentProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
			}
			data.salary=$(this).find('input[name^="salary"]').val();
			data.salaryMethod=$(this).find('select[name^="salaryMethod"]').val();
			data.salaryMethodRemark=$(this).find('input[name^="salaryMethodRemark"]').val().replaceAll(',',';');
			data.frequency=$(this).find('select[name^="frequency"]').val();
			$(this).find('input[name^="count"]').each(function(){
				if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
					data.employmentMonthStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
					data.employmentMonthEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
					if(data.frequency=='1'){
						data.lowMonthNumber=$(this).parent().find('input[name^="count"]').val();
					}else{
						data.highMonthNumber=$(this).parent().find('input[name^="count"]').val();
					}
				}
				if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
					data.employmentHourStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
					data.employmentHourEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
					if(data.frequency=='1'){
						data.lowHoursNumber=$(this).parent().find('input[name^="count"]').val();
					}else{
						data.highHoursNumber=$(this).parent().find('input[name^="count"]').val();
					}
				}
			})
			totalAmount=0;
			$(this).find('input[name^="amounts"]').each(function(){
				if(totalAmount==0){
					totalAmount=Number($(this).val());
				}else{
					totalAmount=totalAmount+Number($(this).val());
				}
			})
			data.amounts=totalAmount;
		}
		list.push(data);
	});
	$.ajax({
	    type: "POST",
	    url: 'addAdvancedAgeEmploymentListReceipt',
	    data: JSON.stringify(list),
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		contentType:"application/json",
	    success: function(json){  
			alert('資料已暫存');
			window.location.reload();
	    },
	    error: function(json){
		    alert('稍等5秒再試');
	    }
    });
	}
}

function fileUpload(){
	if($('#uploadFile').val() != '')
	{
		let file = new FormData();
		file.append('uploadFile',$('#uploadFile').get(0).files[0]);
		file.append('baseId',$('#baseId').val());
		$.confirm({
		    title: '請領名單上傳前確認',
		    animation: 'zoom',
		    closeAnimation: 'scale',
		    content: '提醒您上傳會先清除此次的請領名單',
		    buttons: {
		      確認: function() {
				$('#loader-container').show();
		        $.ajax({
				   	type: 'post',
					url: 'addAdvancedAgeEmploymentListReceiptFromFile',// 資料不需要編碼
					enctype: 'multipart/form-data',	   	
					contentType: false,// 資料物件不需要轉換成鍵值對格式
				   	processData: false,
					data: file,
					success: function(res) {
				   	// 判斷是否接收成功
						if(res='success')
						{
					   		alert('檔案已上傳');
							window.location.reload();
						}
					}
				});
		      },
		      取消: function() {
		      }
		    }
		  });
		
	}
	else
	{
		alert('請選擇上傳檔案');
	}
}
function next(){
	if($('#listForm').valid()){
		$('#loader-container').show();
		let data={},list=[],totalAmount=0;
		$('#employedTable').find('li').each(function(){
			data={};
			if($(this).find('input[name^="identification"]').val()!='')
			{
				data.seq=$('#seq').val();
				data.advancedAgeBaseId=$('#baseId').val();
				data.name=$(this).find('input[name^="name"]').val();
				data.identification=$(this).find('input[name^="identification"]').val();
				if($(this).find('select[name^="insuranceType"]').val()==1){
					data.laborProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
				}else if($(this).find('select[name^="insuranceType"]').val()==2){
					data.occupationalAccidentProtectionExpiredTime=$(this).find('input[name^="insuranceTime"]').val()
				}
				data.salary=$(this).find('input[name^="salary"]').val();
				data.salaryMethod=$(this).find('select[name^="salaryMethod"]').val();
				data.salaryMethodRemark=$(this).find('input[name^="salaryMethodRemark"]').val().replaceAll(',',';');
				data.frequency=$(this).find('select[name^="frequency"]').val();
				$(this).find('input[name^="count"]').each(function(){
					if($(this).parent().find('select[name^="salaryType"]').val()=='M'){
						data.employmentMonthStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
						data.employmentMonthEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
						if(data.frequency=='1'){
							data.lowMonthNumber=$(this).parent().find('input[name^="count"]').val();
						}else{
							data.highMonthNumber=$(this).parent().find('input[name^="count"]').val();
						}
					}
					if($(this).parent().find('select[name^="salaryType"]').val()=='H'){
						data.employmentHourStartTime=$(this).parent().find('input[name^="employmentStartTime"]').val();
						data.employmentHourEndTime=$(this).parent().find('input[name^="employmentEndTime"]').val();
						if(data.frequency=='1'){
							data.lowHoursNumber=$(this).parent().find('input[name^="count"]').val();
						}else{
							data.highHoursNumber=$(this).parent().find('input[name^="count"]').val();
						}
					}
				})
				totalAmount=0;
				$(this).find('input[name^="amounts"]').each(function(){
					if(totalAmount==0){
						totalAmount=Number($(this).val());
					}else{
						totalAmount=totalAmount+Number($(this).val());
					}
				})
				data.amounts=totalAmount;
			}
			list.push(data);
		});
		$.ajax({
		    type: "POST",
		    url: 'addAdvancedAgeEmploymentListReceipt',
		    data: JSON.stringify(list),
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			contentType:"application/json",
		    success: function(json){  
				location.href='employ_payment_03';
		    },
		    error: function(json){
			    alert('稍等5秒再試');
				$('#loader-container').hide();
		    }
	    });
		
	}
}