package servicios;

import java.util.List;

import clasesUtiles.DAOFactory;
import interfacesDAO.RutaDAO;
import misClases.Ruta;

public class RutaService {
	private RutaDAO rutaDAO;
	
	public RutaService(){
		this.rutaDAO = DAOFactory.getRutaDAO();
	}
	
	public List<Ruta >getRutasAsociadas (Long idActividad){
		return rutaDAO.getRutasAsociadas(idActividad);
	}
	
	public List<Ruta> recuperarTodas(){
		return rutaDAO.recuperarTodos();
	}
	
	public List<Ruta> recuperarTodasMisRutas(Long idUsuario){
		return rutaDAO.recuperarTodasMisRutas(idUsuario);
	}
	
	public boolean esRutaDeEsteUsuario(Long idRuta,Long idUsuario){
		return rutaDAO.esRutaDeEsteUsuario(idRuta, idUsuario);
	}
	
	public void guardarRuta(Ruta ruta){
		this.rutaDAO.persistir(ruta);
	}
	
	public Ruta recuperar (Long idRuta){
		return rutaDAO.recuperar(idRuta);
	}
	
	public void actualizar (Ruta ruta){
		this.rutaDAO.actualizar(ruta);
	}
	
	public void eliminar (Ruta ruta){
		this.rutaDAO.borrar(ruta);
	}
}
