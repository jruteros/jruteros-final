package interfacesDAO;

import misClases.Puntaje;

public interface PuntajeDAO extends GenericDAO<Puntaje> {

	public boolean hizoEsteUsuarioEstaRuta (Long idUsuario, Long idRuta);
	public Puntaje obtenerPuntajeConPuntuacionNull (Long idUsuario, Long idRuta);
	public Puntaje obtenerPuntaje (Long idUsuario, Long idRuta);
	public boolean esteUsuarioPuntuoEstaRuta(Long idUsuario,Long idRuta);
	
}
