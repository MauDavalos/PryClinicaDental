var toData=[0,0,0,0]
function ordenar(va){
	switch (va) {
	  case 'entre 0 y 3':
		  return 0;				    
		  break;
	  case 'entre 4 y 12':
		  return 1;					    
		  break;
	  case 'entre 13 y 18':
		  return 2;			    
		  break;
	  case 'más de 18':
		  return 3;				    
		  break;
	    
	  default:
	    console.log('esta mal escrito el mes');
	}
};
	
function load() {

	

	$.ajax({
		url: "/cita/loadData",
		method : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		success : function(response){
			var toLabels = [];
			var num=0;
			$.each(response, function(i, item){
				toLabels.push(item.llave);
				num=ordenar(item.llave);
				toData[num]=item.valor;
			});
			var barChartData = {
					labels: ['0-3','4-12', '13-18', '+18'],
					datasets: [{
						label: 'Edades',
						backgroundColor: getRandomColor(),
						yAxisID: 'y-axis-1',
						data:toData
					}]

					};
			$('#chart-area').replaceWith('<canvas id="chart-area"></canvas>');
			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
			data: barChartData,
			options: {
			responsive: true,
			title: {
				display: true,
				text: 'Reporte por Mes'
			},
			tooltips: {
				mode: 'index',
				intersect: true
			},
			scales: {
				yAxes: [{
					type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
					display: true,
					position: 'left',
					id: 'y-axis-1',
				}],
					}
				}
			});
			

	
			
		},
		error : function(err){
			console.log(err);
		}
		
	});
};

function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}
$(document).ready(function(){
	load();

});
	