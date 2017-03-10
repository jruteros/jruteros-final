package interfacesDAO;

import java.util.List;

import misClases.Puntaje;

public interface PuntajeDAO extends GenericDAO<Puntaje> {

	public boolean hizoEsteUsuarioEstaRuta (Long idUsuario, Long idRuta);
	public Puntaje obtenerPuntajeConPuntuacionNull (Long idUsuario, Long idRuta);
	public Puntaje obtenerPuntaje (Long idUsuario, Long idRuta);
	public boolean esteUsuarioPuntuoEstaRuta(Long idUsuario,Long idRuta);
	public Integer getCantidadUsuariosHicieronEstaRuta(Long idRuta);
	public List<Puntaje> obtenerPuntajesDeEstaRuta(Long idRuta);
	
}
