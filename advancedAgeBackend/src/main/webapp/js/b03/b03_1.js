$(function(){
	
	$('#banStartDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	let banStartDate;
	$('#banEndDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			banStartDate=$('#banStartDate').val();
			$(this).datepicker('option','minDate',(Number(banStartDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	

	$('#saveBanStartDate').datepicker({ 
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
	$('#saveBanEndDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#saveBanStartDate').val();
			$(this).datepicker('option','minDate',(Number(startDate.replaceAll('-',''))+19110001).toString());
		},
		onSelect : function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
})
function addBlackListFile(num){
	$('button[onclick^="addBlackListFile"]').hide();
	$('#listFile').append('<div>'+
                '<input type="file" id="blackListFile'+(Number(num)+1)+'" name="blackListFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff"> '+
				'<button type="button" class="add" onclick="delBlackListFile('+(Number(num)+1)+')"> ???</button> '+
                '<button type="button" class="add" onclick="addBlackListFile('+(Number(num)+1)+')" style>???</button> '+
              '</div>');
}

function delBlackListFile(num){
	$('input[id="blackListFile'+num+'"]').parent().remove();
	$('input[id^="blackListFile"]').parent().last().find('button[onclick^="add"]').show();
}

function save(){
	$.ajax({
	    type: "POST",
	    url: 'editBlackListData',
	    data: {
			id : $('#id').val(),
			officialDocumentNumber : $('#officialDocumentNumber').val(),
			description : $('#description').val(),
			banStartDate : $('#saveBanStartDate').val(),
			banEndDate : $('#saveBanEndDate').val(),
			updator : $('#updator').val()
	    },
	    dataType:"text", //ajax?????????text???json???????????????????????????????????????json???
	    success: function(text){
			let json=jQuery.parseJSON(text);
			if(json.status=='success'){
				upload(json.id);
			}
		}
	})
}

function upload(id){
	let blackListFiles = new FormData();
		$('input[name^="blackListFile"]').each(function(){
			blackListFiles.append('blackListFiles',$(this)[0].files[0]);
	});
		blackListFiles.append('id',id);
		$.ajax({
		   	type: 'post',
			url: 'blackListFileUplolad',// ?????????????????????
			enctype: 'multipart/form-data',	   	
			contentType: false,// ?????????????????????????????????????????????
		   	processData: false,
			data: blackListFiles,
			success: function(result) {
				location.href='b03';
			}
		});
	
}