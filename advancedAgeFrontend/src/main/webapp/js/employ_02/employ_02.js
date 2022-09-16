$(function(){
	
	// Initialize select2
//	$("#city").select2();
//	$.validator.setDefaults({
//	    submitHandler: function() {
//	    }
//	});
	$('#contactCity').change(function(){
		$('#contactArea').html('<option value="null">請選擇</option>');
		if($('#contactCity').val()!='')
		{
			$.ajax({
			    type: "GET",
			    url: 'getAreaList',
			    data: {
			    	cityCode : $('#contactCity').val()
			    },
			    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
			    success: function(json){  
					let areaSplit=json.split(";");
					for(let a=0;a<areaSplit.length;a++)
					{
						$('#contactArea').append('<option value="'+areaSplit[a].split(",")[0]+'">'+areaSplit[a].split(",")[1]+'</option>');
					}
			    },
			    error: function(json){
				    alert(json);
			    }
		    });
		}
	});
	
	
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
		    url: 'addAdvancedAgeApply',
		    data: {
				companyName : $('#companyName').val(),
		    	seq : $('#seq').val(),
				industry : $('#industry').val(),
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
				workersEmployment : $('input[name="workersEmployment"]:checked').val(),
				relatives : $('input[name="relatives"]:checked').val(),
				relatedAmounts : $('input[name="relatedAmounts"]:checked').val(),
				notMandatory : $('input[name="notMandatory"]:checked').val(),
				guaranteeNumber : guarantee,
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
		    url: 'addAdvancedAgeApply',
		    data: {
				companyName : $('#companyName').val(),
		    	seq : $('#seq').val(),
				industry : $('#industry').val(),
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
				workersEmployment : $('input[name="workersEmployment"]:checked').val(),
				relatives : $('input[name="relatives"]:checked').val(),
				relatedAmounts : $('input[name="relatedAmounts"]:checked').val(),
				notMandatory : $('input[name="notMandatory"]:checked').val(),
				guaranteeNumber : guarantee
		    },
		    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		    success: function(json){  
				if(json=='success'){
					location.href='employ_03?seq='+$('#seq').val();
				}
		    },
		    error: function(json){
			    alert(json);
		    }
	    });
	}
}