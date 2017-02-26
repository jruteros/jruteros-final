package interfacesDAO;

import java.util.List;

import misClases.Actividad;

public interface ActividadDAO extends GenericDAO<Actividad> {
	public boolean existeActividad(String actividad);
	public List<Actividad> recuperarHabilitadas();
}
