package interfacesDAO;



import java.util.List;
import misClases.Ruta;

public interface RutaDAO extends GenericDAO<Ruta> {
	public List<Ruta> getRutasAsociadas (Long idActividad);
	
}
