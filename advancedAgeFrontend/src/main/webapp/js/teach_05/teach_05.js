$(function(){
	$('#employed').click(function(){
		$('#list').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').show();
		$('#listTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#listTable').show();
	})
	
	$('input[name^="unitPrice"]').change(function(){
		if($(this).val()!='' && $(this).parent().parent().find('input[name^="amount"]').val()!=''){
			$(this).parent().parent().find('input[name^="totalAmount"]').val($(this).val()*$(this).parent().parent().find('input[name^="amount"]').val());
		}
	})
	
	$('input[name^="amount"]').change(function(){
		if($(this).val()!='' && $(this).parent().parent().find('input[name^="unitPrice"]').val()!=''){
			$(this).parent().parent().find('input[name^="totalAmount"]').val($(this).val()*$(this).parent().parent().find('input[name^="unitPrice"]').val());
		}
	})
	
	$('input[name^="planName"]').each(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('input[name^="description"]').attr('required',false);
		}
	});
	
	$('input[name^="planName"]').change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('input[name^="description"]').attr('required',false);
		}else{
			if($(this).attr('id')!='planName1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass('error');
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
})

function listAdd(){
	maxNum = 1;
	let countli = $('#employedTable ol li').length;
	if (countli > 0) {
		maxNum=Number($('#employedTable').find('li').last().find('input[name^="planName"]').attr('id').replace('planName',''))+1;
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
		$('#employedTable').find('ol').append('<li>'+
	      '<div class="s">' +
          '<label for="planName'+maxNum+'">項目</label>' +
          '<input type="text" id="planName'+maxNum+'" name="planName'+maxNum+'">' +
          '</div>' +
          
          '<div class="s">' +
          '<label for="unitPrice'+maxNum+'">單價</label>' +
          '<input type="number" step="1" min="0" id="unitPrice'+maxNum+'" name="unitPrice'+maxNum+'"> 元' +
          '</div>' +
        
          '<div class="s">' +
          '<label for="amount'+maxNum+'">數量</label>' +
          '<input type="number" step="1" min="0" id="amount'+maxNum+'" name="amount'+maxNum+'">' +
          '</div>' +
        
          '<div class="s">' +
          '<label for="totalAmount'+maxNum+'">總價</label>' +
          '<input type="text" id="totalAmount'+maxNum+'" name="totalAmount'+maxNum+'" class="readonly" placeholder="填寫完自動計算" readonly> 元' +
          '</div>' +
        
          '<div class="s">' +
          '<label for="applicationAmounts'+maxNum+'">申請本部補助</label>' +
          '<input type="number" id="applicationAmounts'+maxNum+'" name="applicationAmounts'+maxNum+'" step="1" min="0"> 元' +
          '</div>' +
        
          '<div class="s">' +
          '<label for="description'+maxNum+'">說明</label>' +
          '<input type="text" id="description'+maxNum+'" name="description'+maxNum+'" placeholder="">' +
          '</div>' +
          
          '<div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>' +
          
	        '</li>');
	if(maxNum==1){
		$('#planName1').parent().parent('li').find('input').attr('required',true);
		$('#planName1').parent().parent('li').find('input[name^="description"]').attr('required',false);
	}
	$('#planName'+maxNum).change(function(){
		if($(this).val().length>0)
		{
			$(this).parent().parent('li').find('input').attr('required',true);
			$(this).parent().parent('li').find('input[name^="description"]').attr('required',false);
		}else{
			if($(this).attr('id')!='planName1'){
				$(this).parent().parent('li').find('input').attr('required',false);
				$(this).parent().parent('li').find('input').removeClass('error');
				$(this).parent().parent('li').find('label.error').remove();
			}
		}
	});
	
	$('#unitPrice'+maxNum).change(function(){
		if($(this).val()!='' && $(this).parent().parent().find('input[name^="amount"]').val()!=''){
			$(this).parent().parent().find('input[name^="totalAmount"]').val($(this).val()*$(this).parent().parent().find('input[name^="amount"]').val());
		}
	})
	
	$('#amount'+maxNum).change(function(){
		if($(this).val()!='' && $(this).parent().parent().find('input[name^="unitPrice"]').val()!=''){
			$(this).parent().parent().find('input[name^="totalAmount"]').val($(this).val()*$(this).parent().parent().find('input[name^="unitPrice"]').val())
		}
	})
}

function listSave(){
	let list=[];
	$('#employedTable').find('li').each(function(index,value){
		if($(this).find('input[name^="planName"]').val()!='')
		{
			let data={"planName" : $(this).find('input[name^="planName"]').val(),
				"unitPrice" : $(this).find('input[name^="unitPrice"]').val(),
				"amount" : $(this).find('input[name^="amount"]').val(),
				"amounts" : $(this).find('input[name^="applicationAmounts"]').val(),
				"description" : $(this).find('input[name^="description"]').val()
			}
			list.push(data);
		}
	});
	$.ajax({
	    type: "POST",
	    url: 'addRetirementAdvancedAgeExperienceInheritanceExpenditure',
	    data: JSON.stringify(list),
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		contentType:"application/json",
	    success: function(json){  
			if(json=='success')
			{
				alert('資料已暫存');
				window.location.reload();
			}
	    }
    });
}

function listDelete(e){
	if(confirm('是否確定要移除？'))
	{
		$.ajax({
		    type: "POST",
		    url: 'delRetirementAdvancedAgeExperienceInheritanceExpenditure',
		    data: {
				planName : $(e).parent().parent('li').find('input[name^="planName"]').val()
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){
				if(json=='success'){
					$(e).parent().parent().remove();
				}
			}
		});
	}
}


function fileUpload(){
	$('#loader-container').show();
	 
	if($('#uploadFile').val() != '')
	{
		let file = new FormData();
		file.append('uploadFile',$('#uploadFile').get(0).files[0]);
		$.confirm({
		    title: '上傳前確認',
		    animation: 'zoom',
		    closeAnimation: 'scale',
		    content: '提醒您！再次上傳將會「覆蓋先前上傳的檔案」，以及您手動填寫的「線上填寫資料」',
		    buttons: {
		      確認: function() {
		        $.ajax({
				   	type: 'post',
					url: 'addRetirementAdvancedAgeExperienceInheritanceExpenditureFromFile',// 資料不需要編碼
					enctype: 'multipart/form-data',	   	
					contentType: false,// 資料物件不需要轉換成鍵值對格式
				   	processData: false,
					data: file,
					success: function(res) {
				   	// 判斷是否接收成功
						if(res=='success')
						{
					   		alert('檔案已上傳');
							window.location.reload();
						}else{
							alert('請確認 "檔案格式" 和 "內容欄位" 是否填寫完整與正確');
							$('#uploadFile').val('');
							$('#loader-container').hide();
						}
					}
				});
		      },
		      取消: function() {
				$('#loader-container').hide();
		      }
		    }
		  });
		
	}
	else
	{
		alert('請選擇上傳檔案');
		$('#loader-container').hide();
	}
	
}

function next(){
	if($('#listForm').valid()){
		let list=[];
		$('#employedTable').find('li').each(function(index,value){
			if($(this).find('input[name^="planName"]').val()!='')
			{
				let data={"planName" : $(this).find('input[name^="planName"]').val(),
					"unitPrice" : $(this).find('input[name^="unitPrice"]').val(),
					"amount" : $(this).find('input[name^="amount"]').val(),
					"amounts" : $(this).find('input[name^="applicationAmounts"]').val(),
					"description" : $(this).find('input[name^="description"]').val()
				}
				list.push(data);
			}
		});
		$.ajax({
		    type: "POST",
		    url: 'addRetirementAdvancedAgeExperienceInheritanceExpenditure',
		    data: JSON.stringify(list),
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			contentType:"application/json",
		    success: function(json){  
				if(json=='success')
				{
					location.href='teach_06';
				}
		    }
	    });
	}
}