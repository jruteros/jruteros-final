package rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoordenadaService {
	CoordenadaDAO coordenadaDAO;

	public CoordenadaService() {
		coordenadaDAO = new CoordenadaDAO();
	}

	public void crearCoordenada(Coordenada coordenada) {
		coordenadaDAO.agregar(coordenada);
	}

	public List<Coordenada> getCoordenadasList() {
		return coordenadaDAO.recuperarTodos();
	}

	public void eliminarTodo() {
		coordenadaDAO.eliminarTodo();
	}

	public void eliminarCoordenada(String id) {
		coordenadaDAO.eliminar(id);
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
		int posicionCoordenadaABorrar = coordenadasAsList.indexOf(coordenadaAEliminar);
		//Si es la ultima, devuelvo la coordenada siguiente
		Coordenada coordenadaARetornar = coordenadasAsList.get(1); 
		//Si no es la ultima, devuelvo la anterior coordenada
		if (posicionCoordenadaABorrar >0){
			coordenadaARetornar = coordenadasAsList.get(posicionCoordenadaABorrar -1); 
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
