package rest.jersey;

import java.util.List;

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
}
