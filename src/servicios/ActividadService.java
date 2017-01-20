package servicios;

import java.util.List;

import clasesUtiles.DAOFactory;
import interfacesDAO.ActividadDAO;
import misClases.Actividad;


public class ActividadService {
	
	public List<Actividad> recuperarTodos() {
		ActividadDAO actividadDAO = DAOFactory.getActividadDAO();
		return actividadDAO.recuperarTodos();
	}

}
