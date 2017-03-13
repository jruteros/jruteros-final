var l = window.location;
var myURI = l.protocol+ '//'+l.hostname+':'+l.port+'/'+l.pathname.split('/')[1]+ "/rest/rutas/"; //Original

var mapProp = {
	center : new google.maps.LatLng(-34.9038055, -57.9392111, 18),
	zoom : 14,
	mapTypeId : google.maps.MapTypeId.ROADMAP
};

var puntos = [];
var map;
var primeraVez = 0;
var origenRuta;
var finRuta;

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
	if(primeraVez === 0){
		primeraVez ++;
		obtenerMarkersDeLaBd();
	}else {
		obtenerMarkers();
	}
	
}

// Obtiene markers y los dibuja
function obtenerMarkers(dibujar) {

	$.ajax({
		dataType : "json",
		url : myURI + "coordenadas",
		success : function(result) {
			puntos = [];
			$.each(result, function(i, dato) {
				dibujarMarker(dato);
				finRuta = new google.maps.LatLng(dato.lat, dato.lon);
			});
			dibujarRecorrido();
		}
	});
}

//Obtiene markers y los dibuja
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

function irAlOrigen(){
	map.setCenter(origenRuta);
}

function irAlFinal(){
	map.setCenter(finRuta);
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
		console.log("rigthclick");
		borrarMarker(dato.id);
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
			$("#limpiarMapa").hide();
			origenRuta = mapProp.center;
			finRuta = mapProp.center;
			initialize();
		}
	});

}
$('#limpiarMapa').click(limpiarMapa);
$('#ir_al_origen').click(irAlOrigen);
$('#ir_al_fin').click(irAlFinal);
$('#rehacer').click(rehacer);

function rehacer (){
	primeraVez=0;
	$("#limpiarMapa").show();
	initialize();
}

function borrarMarker(id) {
	console.log("borrar marker " + id);
	punto = {
		id : id
	};
	$.ajax({
		data : punto,
		dataType : "json",
		url : myURI + "coordenadas?id_coordenada=" + id + "",
		type : "DELETE",
		success : function(result) {
			if (result =="undefined" || result == null ){
				$("#limpiarMapa").hide();
				return ;
			}
			mapProp.center = new google.maps.LatLng(result.lat, result.lon);
			initialize();
		}
	});
}