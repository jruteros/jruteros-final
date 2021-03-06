var l = window.location;
var myURI = l.protocol+ '//'+l.hostname+':'+l.port+'/'+l.pathname.split('/')[1]+ "/rest/rutas/"; //Original

var mapProp = {
	center : new google.maps.LatLng(-34.9038055, -57.9392111, 18),
	zoom : 14,
	mapTypeId : google.maps.MapTypeId.ROADMAP
};

var puntos = [];
var map;
var origenRuta;
var finRuta;

google.maps.event.addDomListener(window, 'load', initialize);

/**
 * Inicializa el mapa
 */
function initialize() {
	map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
	puntos = [];
	obtenerMarkersDeLaBd();
}

// Obtiene markers y los dibuja
function obtenerMarkersDeLaBd() {
	var id_ruta = $("#formu\\:id_ruta").val();
	// or
	//var id_ruta2 = $("[id='formu:id_ruta']").val();
	$.ajax({
		dataType : "json",
		url : myURI + "coordenadas" + "/"+ id_ruta,
		success : function(result) {
			if (result && result.length >0){
				origenRuta = new google.maps.LatLng(result[0].lat, result[0].lon);
				finRuta = new google.maps.LatLng(result[result.length -1].lat, result[result.length - 1].lon);
				irAlOrigen();
			}
			puntos = [];
			$.each(result, function(i, dato) {
				dibujarMarker(dato);
			});
			dibujarRecorrido();
			
			
		}
	});
}

$('#ir_al_origen').click(irAlOrigen);
$('#ir_al_fin').click(irAlFinal);


function irAlOrigen(){
	map.setCenter(origenRuta);
}

function irAlFinal(){
	map.setCenter(finRuta);
}

function calcularDistancia() {
	  var distancia = (google.maps.geometry.spherical.computeDistanceBetween(origenRuta, finRuta) / 1000).toFixed(2);
	  $("#formu\\:distancia").val(distancia);
	  
}

function dibujarMarker(dato) {

	var position = new google.maps.LatLng(dato.lat, dato.lon);

	var marker = new google.maps.Marker({
		position : position,
		icon : {
			path : google.maps.SymbolPath.CIRCLE,
			scale : 3
		},
		id : dato.id
	});

	puntos[puntos.length] = position;

	marker.setMap(map);
}

function dibujarRecorrido() {

	var flightPath = new google.maps.Polyline({
		path : puntos,
		strokeColor : "#0000FF",
		strokeOpacity : 0.8,
		strokeWeight : 2
	});

	flightPath.setMap(map);
}



