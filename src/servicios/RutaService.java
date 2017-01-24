package servicios;

import java.util.List;

import clasesUtiles.DAOFactory;
import interfacesDAO.RutaDAO;
import misClases.Ruta;

public class RutaService {
	private RutaDAO rutadDAO;
	
	public RutaService(){
		this.rutadDAO = DAOFactory.getRutaDAO();
	}
	
	public List<Ruta >getRutasAsociadas (Long idActividad){
		return rutadDAO.getRutasAsociadas(idActividad);
	}
}
