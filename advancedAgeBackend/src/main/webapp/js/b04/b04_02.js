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
	$('#inspectDate').datepicker({ 
		changeMonth: true,
	    changeYear: true,
		dateFormat: "yymmdd",
		onSelect: function (dateText, inst) {
            dateText = dateText - 19110000;
            dateText = dateText.toString().substr(0, 3) + '-' + dateText.toString().substr(3, 2) + '-' + dateText.toString().substr(5, 2);
            $(this).val(dateText);
        } 
	});
	$('input[name^="result"]').click(function(){
		$('input[id^="reason"]').val('');
	});
})

function addSiteInspectionFile(num){
	$('button[onclick^="addSiteInspectionFile"]').hide();
	$('#siteInspection').append('<div>'+
                '<input type="file" id="siteInspectionFile'+(Number(num)+1)+'" name="siteInspectionFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff"> '+
				'<button class="add" onclick="delSiteInspectionFile('+(Number(num)+1)+')">－</button> '+
                '<button class="add" onclick="addSiteInspectionFile('+(Number(num)+1)+')" style>＋</button>'+
              '</div>');
}

function delSiteInspectionFile(num){
	$('input[id="siteInspectionFile'+num+'"]').parent().remove();
	$('input[id^="siteInspectionFile"]').parent().last().find('button[onclick^="add"]').show();
}

function addSiteInspectionOtherFile(num){
	$('button[onclick^="addSiteInspectionOtherFile"]').hide();
	$('#siteInspectionOther').append('<div>'+
                '<input type="file" id="siteInspectionOtherFile'+(Number(num)+1)+'" name="siteInspectionOtherFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff"> '+
				'<button class="add" onclick="delSiteInspectionOtherFile('+(Number(num)+1)+')">－</button> '+
                '<button class="add" onclick="addSiteInspectionOtherFile('+(Number(num)+1)+')" style>＋</button>'+
              '</div>');
}

function delSiteInspectionOtherFile(num){
	$('input[id="siteInspectionOtherFile'+num+'"]').parent().remove();
	$('input[id^="siteInspectionOtherFile"]').parent().last().find('button[onclick^="add"]').show();
}

function add(){
	if(fileUploadCheck()){
		$.ajax({
		    type: "POST",
		    url: 'addSiteInspection',
		    data: {
				companyName : $('#companyName').text(),
				seq : $('#seq').val(),
				caseType : 'A',
				inspectDate : $('#inspectDate').val(),
				inspector : $('#inspector').val(),
				result : $('input[name="result"]:checked').val(),
				reason : $('input[name="result"]:checked').val()==2?$('#reason2').val():$('input[name="result"]:checked').val()==3?$('#reason3').val():'',
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
	}else{
		alert('請確認檔案是否上傳');
	}
}

function fileUploadCheck(){
	let checkFile=1;
	if($('#siteInspectionFile1').val()!='' &&
		$('#siteInspectionOtherFile1').val()!=''){
	}else{
		checkFile=0;
	}
	if(checkFile==0)
	{
		return false;
	}
	else
	{
		return true;
	}
}

function upload(id){
	let siteInspectionFiles = new FormData();
	let siteInspectionOtherFiles = new FormData();
	$('input[name^="siteInspectionFile"]').each(function(){
		siteInspectionFiles.append('siteInspectionFiles',$(this)[0].files[0]);
	});
	$('input[name^="siteInspectionOtherFile"]').each(function(){
		siteInspectionOtherFiles.append('siteInspectionOtherFiles',$(this)[0].files[0]);
	});
	siteInspectionFiles.append('id',id);
	siteInspectionOtherFiles.append('id',id);
	$.ajax({
	   	type: 'post',
		url: 'siteInspectionFileUplolad',// 資料不需要編碼
		enctype: 'multipart/form-data',	   	
		contentType: false,// 資料物件不需要轉換成鍵值對格式
	   	processData: false,
		data: siteInspectionFiles,
		success: function(res) {
			if(res=='success')
			{
		   		$.ajax({
				   	type: 'post',
					url: 'siteInspectionOtherFileUplolad',// 資料不需要編碼
					enctype: 'multipart/form-data',	   	
					contentType: false,// 資料物件不需要轉換成鍵值對格式
				   	processData: false,
					data: siteInspectionOtherFiles,
					success: function(res) {
						if(res=='success')
						{
					   		location.href='b04';
						}else{
							alert('請確認檔案格式');
						}
						
					}
				});
			}else{
				alert('請確認檔案格式');
			}
			
		}
	});
	
}
function reset(){
	window.location.reload();
}