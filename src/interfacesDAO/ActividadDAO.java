package interfacesDAO;

import misClases.Actividad;

public interface ActividadDAO extends GenericDAO<Actividad> {
	public boolean existeActividad(String actividad);
}
