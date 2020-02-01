function load(){
	$.ajax({
		url: "/doctor/loadData",
		method : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		success : function(response){

			console.log(response);	

			var toData = [];
			var toLabels = [];
			var toColors = [];

			$.each(response, function(i, item){
				console.log(item);
				toData.push(item.valor);
				toLabels.push(item.llave);
				var color  = getRandomColor();							
				toColors.push(color);
			});

			var config = {
					type: 'doughnut',
					data: {
						datasets: [{
							data: toData,
							backgroundColor: toColors
						}],
						labels: toLabels
					},
					options: {
						responsive: true,
						legend: {
							position: 'top',
						},
						title: {
							display: true,
							text: 'Citas por Doctor'
						},
						animation: {
							animateScale: true,
							animateRotate: true
						}
					}
				};
			


			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myDoughnut = new Chart(ctx, config);




		},
		error : function(err){
			console.log(err);
		}		
	});
}

$(document).ready(function(){
	load();
});