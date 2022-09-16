// JavaScript Documentvar ctx;
var pieChart;
var labels;
var barChart;
$(function(){
	
    //繼續雇用
	//原有薪資級距
	ctx = document.getElementById('canvasBar').getContext('2d');
	barChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['2萬～2.9萬', 
			         '3萬～3.9萬', 
					 '4萬～4.9萬', 
					 '5萬～5.9萬', 
					 '6萬(含)以上'],
	        datasets: [
			    {
	            label: '男性',
	            data: [110, 129, 93, 65, 32],
	            backgroundColor: [
	                'rgba(0, 74, 131, 0.6)',//藏青
	                'rgba(0, 74, 131, 0.7)',//藏青
	                'rgba(0, 74, 131, 0.8)',//藏青
	                'rgba(0, 74, 131, 0.9)',//藏青
	                'rgba(0, 74, 131, 1)',//藏青
	            ],
	            borderWidth: 0
	            },
			    {
	            label: '女性',
	            data: [106, 110, 48, 15, 10,],
	            backgroundColor: [
	                'rgba(219, 102, 0, 0.6)',//橘
	                'rgba(219, 102, 0, 0.7)',//橘
	                'rgba(219, 102, 0, 0.8)',//橘
	                'rgba(219, 102, 0, 0.9)',//橘
	                'rgba(219, 102, 0, 1)',//橘
	            ],
	            borderWidth: 0
	            }
			]
	    },
	    options: {
	        scales: {
	            y: {
	                beginAtZero: true
	            }
	        }
	    }
	});
	
	
	//繼續雇用行業別
	labels= ['農林漁牧',//紅咖
	         '礦業及土石採取',//黃
			 '製造業',//藏青
			 '電力及然氣供應',//淺灰
			 '用水供應汙染整治',//橘紅
			 '營建工程',//中灰
			 '批發零售',//淺灰藍
			 '運輸倉儲',//灰藍
			 '住宿餐飲',//橘
			 ];
			 

    ctx = document.getElementById('canvasPie').getContext('2d');
    pieChart = new Chart(ctx, {
      type: 'doughnut',
	  options: {
       legend: {
        position: 'right'
        }
      },
      data : {
        labels:labels,
        datasets: [{
            //預設資料
            data:[5,8,22,5,7,10,18,12,28,],
            backgroundColor: [
            //資料顏色
	                'rgba(102, 38, 13, 1)',//紅咖
	                'rgba(250, 196, 0, 1)',//黃
	                'rgba(0, 74, 131, 1)',//藏青
	                'rgba(170, 172, 176, 1)',//淺灰
	                'rgba(170, 62, 24, 1)',//橘紅
	                'rgba(124, 124, 126, 1)',//中灰
	                'rgba(174, 198, 217, 1)',//淺灰藍
	                'rgba(68, 84, 107, 1)',//深灰藍
	                'rgba(219, 102, 0, 1)',//橘
            ],
        }],
      }
    });
	
	
	
	//傳承專業技術
	//傳承技術項目
	labels= ['金融科技',
	         '傳統產業',
			 '醫療科技',
			 '建築經營及再生',
			 '能源科技',
			 ];
			 

    ctx = document.getElementById('canvasPie-2').getContext('2d');
    pieChart = new Chart(ctx, {
      type: 'polarArea',
	  options: {
       legend: {
        position: 'right'
        }
      },
      data : {
        labels:labels,
        datasets: [{
            //預設資料
            data:[5,22,25,11,17],
            backgroundColor: [
            //資料顏色
	                'rgba(140, 142, 146, 0.7)',//淺灰
	                'rgba(219, 102, 0, 0.7)',//橘
	                'rgba(250, 196, 0, 0.7)',//黃
	                'rgba(170, 62, 24, 0.7)',//橘紅
	                'rgba(0, 74, 131, 0.7)',//藏青
            ],
        }],
      }
    });
	
		
	
	//講師年齡區間
	ctx = document.getElementById('canvasBar-2').getContext('2d');
	barChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['40歲～49歲', 
			         '50歲～59歲', 
					 '60歲～69歲', 
					 '70歲～79歲', 
					 '80歲～89歲', 
					 '90歲(含)以上'],
	        datasets: [{
	            label: '人數',
				
	            data: [25, 82, 125, 105, 42, 3],
	            backgroundColor: [
	                'rgba(174, 198, 217, 0.9)',//淺灰藍
	                'rgba(250, 196, 0, 0.9)',
	                'rgba(219, 102, 0, 0.9)',
	                'rgba(170, 62, 24, 0.9)',
	                'rgba(68, 84, 107, 0.9)',//深灰藍
	                'rgba(64, 64, 66, 0.9)'
	            ],
	            borderColor: [
	                'rgba(174, 198, 217, 1)',//淺灰藍
	                'rgba(250, 196, 0, 1)',
	                'rgba(219, 102, 0, 1)',
	                'rgba(170, 62, 24, 1)',
	                'rgba(68, 84, 107, 1)',//深灰藍
	                'rgba(64, 64, 66, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            y: {
	                beginAtZero: true
	            }
	        }
	    }
	});
	

	
	
	
	
	
	//再就業準備
	//再就業訓練人數
	ctx = document.getElementById('canvasBar-3').getContext('2d');
	barChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: ['106年',  
					 '107年', 
					 '108年',
					 '109年', 
					 '110年'],
	        datasets: [
			
			{
	            label: '女性',
				data: [101, 136, 63, 117, 400,],
	            backgroundColor: ['rgba(255, 99, 132, 0.3)',],
	            borderColor: ['rgba(255, 99, 132, 1)',],
	            borderWidth: 2
	        },
			{
	            label: '男性',
				data: [26, 110, 113, 320, 280,],
	            backgroundColor: ['rgba(54, 162, 235, 0.2)',],
	            borderColor: ['rgba(54, 162, 235, 1)',],
	            borderWidth: 2
	        }
			]
	    },
	    options: {
	        scales: {
	            y: {
	                beginAtZero: true
	            }
	        }
	    }
	});
	


	
	//申請類型
	labels= ['職涯發展',
	         '就業諮詢',
			 '創業諮詢',
			 ];
			 

    ctx = document.getElementById('canvasPie-3').getContext('2d');
    pieChart = new Chart(ctx, {
      type: 'radar',
	  options: {
       legend: {
        position: 'right',
		display: false
        }
      },
      data : {
        labels:labels,
        datasets: [
		{
            data:[45,50,35],
            backgroundColor: [
            "rgba(54, 162, 235, 0.5)",
            ],
        },
		{
            data:[30,45,40],
            backgroundColor: [
            "rgba(255, 99, 132, 0.5)",
            ],
        }
		
		],
      }
    });
	
	
	
	
})