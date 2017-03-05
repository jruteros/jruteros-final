package rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoordenadaService {

	public CoordenadaService() {
	
	}
	
	//Elimina una coordenada y devuelva la anterior (para que quede centrada)
	public Coordenada eliminarCoordenada(Map<String,Coordenada> coordenadas,String idCoordenada){
		Coordenada anteriorCoordenadaALaEliminada = this.getAnteriorCoordenada(coordenadas, idCoordenada);
		coordenadas.remove(idCoordenada);
		return anteriorCoordenadaALaEliminada;
	}
	
	private Coordenada getAnteriorCoordenada(Map<String,Coordenada> coordenadas,String idCoordenada){
		Coordenada coordenadaAEliminar = coordenadas.get(idCoordenada);
		List<Coordenada> coordenadasAsList = this.recuperarTodos(coordenadas);
		//Si ya no hay mas coordenadas, devuelvo null
		Coordenada coordenadaARetornar = null; 
		//Si no es la ultima coordenada
		if(coordenadas.size() > 1){
			int posicionCoordenadaABorrar = coordenadasAsList.indexOf(coordenadaAEliminar);
			//Si no es la ultima, devuelvo la anterior coordenada
			if (posicionCoordenadaABorrar >0){
				coordenadaARetornar = coordenadasAsList.get(posicionCoordenadaABorrar -1); 
			}
			//Si es la ultima, devuelvo la coordenada siguiente
			if(posicionCoordenadaABorrar == 0){
				coordenadaARetornar = coordenadasAsList.get(1);
			}
		}
		return coordenadaARetornar;
	}
	
	public List<Coordenada> recuperarTodos(Map<String,Coordenada> coordenadas) {
		List<Coordenada> listaCoordenadas = new ArrayList<Coordenada>();
		listaCoordenadas.addAll(coordenadas.values());
		return listaCoordenadas;
	}
	
	public void agregarCoordenada (Map<String,Coordenada> coordenadas,Coordenada coordenada){
		coordenadas.put(coordenada.getId(), coordenada);
	}
	
	
	
}
