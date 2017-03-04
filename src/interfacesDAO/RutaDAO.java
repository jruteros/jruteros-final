package interfacesDAO;



import java.util.List;
import misClases.Ruta;

public interface RutaDAO extends GenericDAO<Ruta> {
	public List<Ruta> getRutasAsociadas (Long idActividad);
	public boolean esRutaDeEsteUsuario (Long idRuta , Long idUsuario);
	public List<Ruta> recuperarTodasMisRutas(Long idUsuario);
	
}
