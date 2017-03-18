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
var totalRecorrido;
var distanciaTotal = parseFloat("0.00");

google.maps.event.addDomListener(window, 'load', initialize);

/**
 * Inicializa el mapa
 */
function initialize() {
	map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

	map.addListener('click', function(e) {
		agregarMarker(e.latLng);
	});
	puntos = [];
	obtenerMarkers();
}

// Obtiene markers y los dibuja
function obtenerMarkers(dibujar) {
	var aunteUltimaRuta = finRuta;
	
	$.ajax({
		dataType : "json",
		url : myURI + "coordenadas",
		success : function(result) {
			if (result && result.length >0){
				origenRuta = new google.maps.LatLng(result[0].lat, result[0].lon);
				finRuta = new google.maps.LatLng(result[result.length -1].lat, result[result.length - 1].lon);
				totalRecorrido = result;
			}
			puntos = [];
			$.each(result, function(i, dato) {
				dibujarMarker(dato);
			});
			dibujarRecorrido();
		}
	});
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

	marker.addListener("rightclick", function(point) {
		borrarMarker(dato.id,position,point);
		marker.setMap(null);
	});

	puntos[puntos.length] = position;

	marker.setMap(map);
}

function agregarMarker(latLng) {

	var punto = {
		lat : latLng.lat(),
		lon : latLng.lng()
	};
	$.ajax({
		data : punto,

		url : myURI + "coordenadas?lat=" + latLng.lat() + "&lon="
				+ latLng.lng() + "",

		type : "POST",
		success : function(result) {
			$("#limpiarMapa").show();
			obtenerMarkers();
		},
	});

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

function dibujarRecorridoCircular() {

	markers = puntos;
	markers[markers.length] = puntos[0];

	var flightPath = new google.maps.Polyline({
		path : markers,
		strokeColor : "#0000FF",
		strokeOpacity : 0.8,
		strokeWeight : 2
	});

	flightPath.setMap(map);
}

function limpiarMapa() {

	punto = {
		id : null
	};
	$.ajax({
		data : punto,
		dataType : "json",
		url : myURI + "coordenadas/eliminarTodo",
		type : "DELETE",
		success : function(result) {
			if (result =="undefined" || result == null )
				return ;
			mapProp.center = new google.maps.LatLng(result.lat, result.lon);
			origenRuta = null;
			finRuta = null;
			$("#limpiarMapa").hide();
			totalRecorrido = undefined;
			distanciaTotal = parseFloat("0.00");
			initialize();
		}
	});

}
$('#limpiarMapa').click(limpiarMapa);
$('#ir_al_origen').click(irAlOrigen);
$('#ir_al_fin').click(irAlFinal);
$("#formu\\:submit_alta_ruta").click(calcularDistancia);

function irAlOrigen(){
	map.setCenter(origenRuta);
}

function irAlFinal(){
	map.setCenter(finRuta);
}

function sumarDistancia(coordenadaActual,coordenadaSiguiente) {
  var distanciaParcial = parseFloat((google.maps.geometry.spherical.computeDistanceBetween(coordenadaActual, coordenadaSiguiente) / 1000).toFixed(2));
  distanciaTotal = parseFloat((distanciaTotal + distanciaParcial).toFixed(2));
}

function calcularDistancia(){
	if(totalRecorrido){
		recorridoSize = totalRecorrido.length;
		for (i = 0; i < recorridoSize-1; i++) {
			
			coordenadaActual =  new google.maps.LatLng(totalRecorrido[i].lat, totalRecorrido[i].lon);
			coordenadaSiguiente =  new google.maps.LatLng(totalRecorrido[i+1].lat, totalRecorrido[i+1].lon);
			sumarDistancia(coordenadaActual,coordenadaSiguiente);
		}
		$("#formu\\:distancia").val(distanciaTotal);
	}
		
}
	



function borrarMarker(id,position) {
	
	punto = {
		id : id
	};
	$.ajax({
		data : punto,
		dataType : "json",
		url : myURI + "coordenadas?id_coordenada=" + id + "",
		type : "DELETE",
		success : function(result) {
			var coordenadaActual = new google.maps.LatLng(result.lat, result.lon);
			if (result =="undefined" || result == null ){
				$("#limpiarMapa").hide();
				return;
			}
			mapProp.center = coordenadaActual;
			initialize();
		}
	});
}
