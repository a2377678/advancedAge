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
	let startDate;
	$('#banEndDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		beforeShow : function(input_html,init){
			startDate=$('#banStartDate').val();
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
				'<button class="add" onclick="delBlackListFile('+(Number(num)+1)+')">－</button> '+
                '<button class="add" onclick="addBlackListFile('+(Number(num)+1)+')" style>＋</button>'+
              '</div>');
}

function delBlackListFile(num){
	$('input[id="blackListFile'+num+'"]').parent().remove();
	$('input[id^="blackListFile"]').parent().last().find('button[onclick^="add"]').show();
}

function add(){
	$.ajax({
	    type: "POST",
	    url: 'addBlackList',
	    data: {
			companyName : $('#companyName').text(),
			seq : $('#seq').val(),
			officialDocumentNumber : $('#officialDocumentNumber').val(),
			description : $('#description').val(),
			banStartDate : $('#banStartDate').val(),
			banEndDate : $('#banEndDate').val(),
			unit : $('#unit').val(),
			creator : $('#creator').val(),
			updator : $('#updator').val()
	    },
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
	    success: function(text){
			let json = JSON.parse(text);
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
		url: 'blackListFileUplolad',// 資料不需要編碼
		enctype: 'multipart/form-data',	   	
		contentType: false,// 資料物件不需要轉換成鍵值對格式
	   	processData: false,
		data: blackListFiles,
		success: function(res) {
			if(res=='success')
			{
		   		location.href='w01';
			}else{
				alert('請確認檔案格式');
			}
		}
	});
}

function reset(){
	window.location.reload();
}