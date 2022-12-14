$(function(){
	$('#checkEmploymentPercentage').html((Number($('#employmenyListReceiptNumber').html().replace('人',''))/Number($('#nearHighEmploymentNumber').html().replace('人',''))*100).toFixed(1)+'%');
	if((Number($('#employmenyListReceiptNumber').html().replace('人',''))/Number($('#nearHighEmploymentNumber').html().replace('人',''))*100).toFixed(1)>=30){
		$('#checkEmploymentPerson').html('合格');
	}else{
		$('#checkEmploymentPerson').html('不合格');
	}
	
	$('#gpdf').click(function(){
		html2canvas(document.getElementById('export_content')).then(canvas => {
	        //返回图片dataURL，参数：图片格式和清晰度(0-1)
	        var pageData = canvas.toDataURL('image/jpeg', 1.0);
	        //方向默认竖直，尺寸ponits，格式a4[595.28,841.89]
	        var doc = new jsPDF('', 'pt', 'a4');
	        //addImage后两个参数控制添加图片的尺寸，此处将页面高度按照a4纸宽高比列进行压缩
	        doc.addImage(pageData, 'JPEG', 30, 30, 595.28*0.9, 592.28/canvas.width * canvas.height );
	        doc.save('補助名單清冊.pdf');
	    });
	})
})

function doPrint(){
	bdhtml=window.document.body.innerHTML;
	sprnstr="<!--startprint-->";
	eprnstr="<!--endprint-->";
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
	window.document.body.innerHTML=prnhtml;
	window.print();
	window.document.body.innerHTML=bdhtml
}

function save(){
	let list=[];
	$('#listStaff').find('td[name^="identification"]').each(function(index,value){
		
		let data={"identification" : $(this).text(),
				"frequency" : $(this).parent().find('td[name^="frequency"]').text(),
				"advancedAgeBaseId" : $('#baseId').val(),
				"seq" : $('#seq').text(),
				"adjustAmounts" : $(this).parent().find('input[name^="adjustAmounts"]').val()};
		if($(this).parent().find('select[name^="approveStatus"]').val()!='')
		{
			data.approveStatus=$(this).parent().find('select[name^="approveStatus"]').val();
		}
		list.push(data);
			
	});
	$.ajax({
	    type: "POST",
	    url: 'editAdvancedAgeEmploymentListReceipt',
	    data: JSON.stringify(list),
	    dataType:"text", //ajax返回值text（json格式也可用這返回，也可設成json）
		contentType:"application/json",
	    success: function(json){
			if(json=='success'){  
				alert('資料已儲存');
				window.location.reload();
			}
	    },
	    error: function(json){
		    alert('稍等5秒再試');
	    }
    });
}