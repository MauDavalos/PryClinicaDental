function load(){
    $.ajax({
        url: "/insumo/loadData/",
        method : 'GET',
        dataType : 'json',
        contentType : 'application/json',
        success : function (response) {
            console.log(response);
            
            //var INSUMOS = ["Meloxicam", "Morfina", "Diclofenaco"];
            let opc;

            var toData1 = [];
            var toData2 = [];
            //var toData3 = [];
            var toLabels = [];
            var toLabelsProducts = [];
            var toColors1 = [];
            var toColors2 = [];
            var toColors3 = [];

            $.each(response, function(i, item){
            	if(toLabels.indexOf(item.valorB)==-1){
            		toLabels.push(item.valorB);                    
            	}
            });
            
            $.each(response, function(i, item){
            	if(toLabelsProducts.indexOf(item.valorA)==-1){
            		toLabelsProducts.push(item.valorA);                    
            	}
            });
            
            $.each(toLabels, function(i, mes){
            	$.each(toLabelsProducts, function(j, prods){
            		var valor = 0;
            		$.each(response, function(k, item){
                    	if(item.valorB == prods[j] && item.valorA == mes[i] && prods[j] == "Diclofenaco"){
                    		toData1.push(item.llave)
                    	}
                    	else if(item.valorB == prods[j] && item.valorA == mes[i] && prods[j] == "Meloxicam"){
                    		toData2.push(item.llave)
                    	}
                    });
                    
                });
            });
            
            
            
            
            	console.log(toData1);
            	console.log(toData2);
            	//console.log(toData3);
            var config = {
                type: 'bar',
                data : {
                    datasets:[{
                        label : "Meloxicam",
                        data: toData1,
                        backgroundColor: toColors1
                    },
            
                    {
                            label : "Diclofenaco",
                            data: toData2,
                            backgroundColor: toColors2
                        }],
                    labels: toLabels
                },
                options:{
                    responsive: true,
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Reporte 2'
                    },
                    animation:{
                        animateScale: true,
                        animateRotate: true
                    }
                }
            };


            var ctx = document.getElementById('chart-area').getContext('2d');
            window.myBar = new Chart(ctx, config);

        },
        error: function(err){
            console.log(err);
        }
    });
}

$(document).ready(function () {
    load();
});