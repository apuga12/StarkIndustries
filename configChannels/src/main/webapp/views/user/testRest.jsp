<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<title>Test :: REST</title>
	<style>
		table{
			font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
			width: 100%;
			border-collapse:collapse;
		}
		table td, #customers th{
			font-size: 1em;
			border: 1px solid #98bf21;
			padding: 3px 7px 2px 7px;
		}
		table th{
			font-size: 1.1em;
			text-align: left;
			padding-top: 5px;
			padding-bottom: 4px;
			background-color: #A7C942;
			color: #ffffff;
		}
		table tr.alt td{
			color: #000000;
			background-color: #EAF2D3;
		}
		footer{
			margin-top: 2em;
			border-top: 1px solid #98bf21;
		}
	</style>
</head>
<body>
	<h1> DEMO Consulta gu�a de programaci�n:</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Empresa</th>
				<th>Ciudad</th>
				<th>Num Canal</th>
				<th>Descripci�n</th>	
				<th>Paquete</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
	
	<script>
		$.get('http://localhost:8080/springapp/series/TC/Tequila',
				function(data){
			var tableData = $('table tbody');
		$.each(data, function(idx, elm){
			tableData.append('<tr><td>'+elm.id+'</td><td>'+elm.msoEmpresa+
					'</td><td>'+elm.ciudad+
					'</td><td>'+elm.numCanal+
					'</td><td>'+elm.descCanal+
					'</td><td>'+elm.flagMiniBasico+'</td></tr>'
					)
		});
		});	
		
	</script>
<!-- 	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script> -->
</body>
</html>