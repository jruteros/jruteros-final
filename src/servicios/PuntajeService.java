package servicios;

import java.util.List;

import clasesUtiles.DAOFactory;
import interfacesDAO.PuntajeDAO;
import misClases.Puntaje;

public class PuntajeService {
	private PuntajeDAO puntajeDAO;
	
	public PuntajeService (){
		puntajeDAO = DAOFactory.getPuntajeDAO();
	}
	
	public boolean hizoEsteUsuarioEstaRuta(Long idUsuario,Long idRuta){
		return puntajeDAO.hizoEsteUsuarioEstaRuta(idUsuario, idRuta);
	}
	
	public void guardarPuntaje (Puntaje puntaje){
		puntajeDAO.persistir(puntaje);
	}
	
	public void eliminarPuntaje (Puntaje puntaje){
		puntajeDAO.borrar(puntaje);
	}
	
	//Usada cuando un usuario marca como hecha a una ruta
	public Puntaje obtenerPuntajeConPuntuacionNull (Long idUsuario,Long idRuta){
		return puntajeDAO.obtenerPuntajeConPuntuacionNull(idUsuario, idRuta);
	}
	
	public Puntaje obtenerPuntaje (Long idUsuario,Long idRuta){
		return puntajeDAO.obtenerPuntaje(idUsuario, idRuta);
	}
	
	public boolean esteUsarioPuntuoEstaRuta (Long idUsuario, Long idRuta){
		return puntajeDAO.esteUsuarioPuntuoEstaRuta(idUsuario, idRuta);
	}
	
	public Integer getCantidadUsuariosHicieronEstaRuta(Long idRuta){
		return puntajeDAO.getCantidadUsuariosHicieronEstaRuta(idRuta);
	}
	
	public Double getPromedioParaEstaRuta(Long idRuta){
		List<Puntaje> puntajes = puntajeDAO.obtenerPuntajesDeEstaRuta(idRuta);
		if (!puntajes.isEmpty()){
			Double sum = new Double(0);
			for (Puntaje p:puntajes){
				sum = sum + p.getPuntuacion();
			}
			return sum/puntajes.size();
		}
		return Double.valueOf(0);
	}
}
