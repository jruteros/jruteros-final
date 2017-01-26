package servicios;

import java.util.List;

import clasesUtiles.DAOFactory;
import interfacesDAO.ActividadDAO;
import interfacesDAO.UsuarioDAO;
import misClases.Actividad;


public class ActividadService {
	private ActividadDAO actividadDAO;
	
	public ActividadService (){
		this.actividadDAO = DAOFactory.getActividadDAO();
	}
	
	public List<Actividad> recuperarTodos() {
		return actividadDAO.recuperarTodos();
	}

	public void habilitarActividad(Actividad actividad) {
		actividad.setHabilitada(true);
		actividadDAO.actualizar(actividad);
	}
	
	public void deshabilitarActividad(Actividad actividad) {
		actividad.setHabilitada(false);
		actividadDAO.actualizar(actividad);
	}

	public void guardarActividad(Actividad actividad) {
		actividadDAO.persistir(actividad);
		
	}

	public Actividad recuperar(Long id_actividad) {
		return actividadDAO.recuperar(id_actividad);
	}

	public void guardarActividadEditada(Actividad actividad) {
	    actividadDAO.actualizar(actividad);
		
	}

}
