package interfacesDAO;

import java.util.List;

import misClases.Coordenada;

public interface CoordenadaDAO extends GenericDAO<Coordenada> {
	public List<Coordenada> recuperarTodos (Long idRuta);
	public void eliminarCoordenadasParaEstaRuta (Long idRuta);
	
}
