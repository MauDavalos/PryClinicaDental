function addDetail(){
	var detail = {
		
			nombreGenerico : $("#txtnombreGenerico").val(),
			nombreComercial : $("#txtnombreComercial").val(),
			componenteActivo : $("#txtcomponenteActivo").val(),
			dosis : $("#txtdosis").val(),
			indicaciones : $("#txtindicaciones").val()
	}
	console.log(detail);
	
	$.ajax({
		url : "/receta/addDetail/",
		method : 'POST',
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(detail),
		success : function(response){
			$("#tblDetalle").html("");
			console.log(response);
			$.each(response, function(i, item){
				console.log(item);
				$("#tblDetalle").append("<tr>");
				$("#tblDetalle").append("<td>" + item.nombreGenerico + "</td>");
				$("#tblDetalle").append("<td>" + item.nombreComercial + "</td>");
				$("#tblDetalle").append("<td>" + item.componenteActivo + "</td>");
				$("#tblDetalle").append("<td>" + item.dosis + "</td>");
				$("#tblDetalle").append("<td>" + item.indicaciones + "</td>");
				$("#tblDetalle").append("</tr>");				
			});						
		},
		error : function(err){
			console.log(err);
		}		
	});
}

$(document).ready(function(){
	$("#btnAgregar").click(function(){
		addDetail();
	});
});