$(function(){
	$('#registerCity').change(function(){
		if($('#checkbox').prop('checked')){
			$('#contactCity').val($(this).val());
			$('#registerArea').html('<option value="null">請選擇</option>');
			$('#contactArea').html('<option value="null">請選擇</option>');
			if($('#registerCity').val()!='')
			{
				$.ajax({
				    type: "POST",
				    url: 'getAreaList',
				    data: {
				    	cityCode : $('#registerCity').val()
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						let areaSplit=json.split(";");
						for(let a=0;a<areaSplit.length;a++)
						{
							let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
		                    let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
							$('#registerArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
		                    $('#contactArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//							$('#registerArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
//							$('#contactArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
						}
				    },
				    error: function(json){
//					    alert(json);
				    }
			    });
			}
			
		}else{
			$('#registerArea').html('<option value="null">請選擇</option>');
			if($('#registerCity').val()!='')
			{
				$.ajax({
				    type: "POST",
				    url: 'getAreaList',
				    data: {
				    	cityCode : $('#registerCity').val()
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						let areaSplit=json.split(";");
						for(let a=0;a<areaSplit.length;a++)
						{
							let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
		                    let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
							$('#registerArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//							$('#registerArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
						}
				    },
				    error: function(json){
					    alert(json);
				    }
			    });
			}
		}
	});
	
	$('#registerArea').change(function(){
		if($('#checkbox').prop('checked')){
			$('#contactArea').val($('#registerArea').val());
		}
	});
	$('#registerAddress').change(function(){
		if($('#checkbox').prop('checked')){
			$('#contactAddress').val($('#registerAddress').val());
		}
	});
	
	$('#contactCity').change(function(){
		$('#contactArea').html('<option value="null">請選擇</option>');
		if($('#contactCity').val()!='')
		{
			$.ajax({
			    type: "POST",
			    url: 'getAreaList',
			    data: {
			    	cityCode : $('#contactCity').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					let areaSplit=json.split(";");
					for(let a=0;a<areaSplit.length;a++)
					{
						let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
	                    let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
	                    $('#contactArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//						$('#contactArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
					}
			    },
			    error: function(json){
				    alert(json);
			    }
		    });
		}
	});
	
	$('#checkbox').click(function(){
		if($('#checkbox').prop('checked')){
			$('#contactCity').val($('#registerCity').val());
			$('#contactArea').html('<option value="null">請選擇</option>');
			if($('#contactCity').val()!='')
			{
				$.ajax({
				    type: "POST",
				    url: 'getAreaList',
				    data: {
				    	cityCode : $('#contactCity').val()
				    },
				    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
				    success: function(json){  
						let areaSplit=json.split(";");
						for(let a=0;a<areaSplit.length;a++)
						{
							let optionValue = $('<div>').text(areaSplit[a].split(",")[0]).html();
		                    let optionText = $('<div>').text(areaSplit[a].split(",")[1]).html();
		                    $('#contactArea').append('<option value="' + optionValue + '">' + optionText + '</option>');
//							$('#contactArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
						}
						$('#contactArea').val($('#registerArea').val());
				    },
				    error: function(json){
					    alert(json);
				    }
			    });
			}
			$('#contactAddress').val($('#registerAddress').val());
		}
	})
	
})

function addGuarantee(num){
	$('button[onclick^="addGuarantee"]').hide();
	$('.file_box').append('<div class="full"> '+
	    	'<label for="guaranteeNumber'+(Number(num)+1)+'"></label> '+
			'<input type="text" id="guaranteeNumber'+(Number(num)+1)+'" name="guaranteeNumber"> '+
			'<button type="button" class="add" onclick="delGuarantee('+(Number(num)+1)+')">－</button> '+
	      	'<button type="button" class="add" onclick="addGuarantee('+(Number(num)+1)+')" style>＋</button>'+
	      '</div>');
}

function delGuarantee(num){
//	alert($('input[id="guaranteeNumber'+num+'"]').parent().find('button[onclick^="add"]').attr('display').html());
	if($('input[id="guaranteeNumber'+num+'"]').parent().find('button[onclick^="add"]').attr('style')==''){
		$('input[id="guaranteeNumber'+num+'"]').parent().remove();
		$('input[id^="guaranteeNumber"]').parent().last().find('button[onclick^="add"]').show();
	}
	else
	{
		$('input[id="guaranteeNumber'+num+'"]').parent().remove();
	}
	
}
function save(){
	let guarantee='';
	$('input[name="guaranteeNumber"]').each(function(){
		if(guarantee=='')
		{
			guarantee=$(this).val();
		}
		else
		{
			guarantee=guarantee+';'+$(this).val();
		}
	});
	if($('#seq').val().length==8){
		$.ajax({
		    type: "POST",
		    url: 'addAdvancedAgeRetirementReemploymentApply',
		    data: {
				companyName : $('#companyName').val(),
		    	seq : $('#seq').val(),
				industry : $('#industry').val(),
				companyAttributes : $('#companyAttributes').val(),
				registerCity : $('#registerCity').val(), 
				registerArea : $('#registerArea').val(),
				registerAddress : $('#registerAddress').val(),
				contactCity : $('#contactCity').val(), 
				contactArea : $('#contactArea').val(),
				contactAddress : $('#contactAddress').val(),
				contactName : $('#contactName').val(),
				contactJobtitle : $('#contactJobtitle').val(),
				contactWorkPhoneAreaCode : $('#contactWorkPhoneAreaCode').val(),
				contactWorkPhone : $('#contactWorkPhone').val(),
				contactWorkPhoneExtension : $('#contactWorkPhoneExtension').val(),
				contactPhone : $('#contactPhone').val(),
				faxAreaCode : $('#faxAreaCode').val(),
				fax : $('#fax').val(),
				email : $('#email').val(),
				multipleCompany : $('input[name="multipleCompany"]:checked').val(),
				relatedAmounts : $('input[name="relatedAmounts"]:checked').val(),
				guaranteeNumber : guarantee
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if(json=='success'){
					alert('資料已暫存');
				}
		    },
		    error: function(json){
			    alert(json);
		    }
	    });
	}
	else{
		alert('請先輸入 統一編號');
	}
}
function next(){
	$('#form').validate({
//		rules:{
//			companyName:{required:true},
//			industry:{required:true},
//		},
		errorPlacement: function(error, element) 
        {
            if ( element.is(":radio") ) 
            {
                error.appendTo( element.parents('li') );
            }
			else if(element.attr('name')=='guaranteeNumber')
			{
				error.appendTo( element.parent('div'));
			}
            else 
            { // This is the default behavior 
                error.insertAfter( element );
            }
         }
	});
	if($('#form').valid()){
		let guarantee='';
		$('input[name="guaranteeNumber"]').each(function(){
			if(guarantee=='')
			{
				guarantee=$(this).val();
			}
			else
			{
				guarantee=guarantee+';'+$(this).val();
			}
		});
		$.ajax({
		    type: "POST",
		    url: 'addAdvancedAgeRetirementReemploymentApply',
		    data: {
				companyName : $('#companyName').val(),
		    	seq : $('#seq').val(),
				industry : $('#industry').val(),
				companyAttributes : $('#companyAttributes').val(),
				registerCity : $('#registerCity').val(), 
				registerArea : $('#registerArea').val(),
				registerAddress : $('#registerAddress').val(),
				contactCity : $('#contactCity').val(), 
				contactArea : $('#contactArea').val(),
				contactAddress : $('#contactAddress').val(),
				contactName : $('#contactName').val(),
				contactJobtitle : $('#contactJobtitle').val(),
				contactWorkPhoneAreaCode : $('#contactWorkPhoneAreaCode').val(),
				contactWorkPhone : $('#contactWorkPhone').val(),
				contactWorkPhoneExtension : $('#contactWorkPhoneExtension').val(),
				contactPhone : $('#contactPhone').val(),
				faxAreaCode : $('#faxAreaCode').val(),
				fax : $('#fax').val(),
				email : $('#email').val(),
				multipleCompany : $('input[name="multipleCompany"]:checked').val(),
				relatedAmounts : $('input[name="relatedAmounts"]:checked').val(),
				guaranteeNumber : guarantee
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if(json=='success'){
					location.href='career_03';
				}
		    },
		    error: function(json){
			    alert(json);
		    }
	    });
	}
}