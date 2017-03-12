package servicios;

import clasesUtiles.DAOFactory;
import interfacesDAO.CoordenadaDAO;

public class CoordenadaBeanService {
	
	private CoordenadaDAO coordenadaDAO;
	
	public CoordenadaBeanService (){
		coordenadaDAO = DAOFactory.getCoordenadaDAO();
	}
	
	public void eliminarCoordenadasParaEstaRuta(Long idRuta){
		coordenadaDAO.eliminarCoordenadasParaEstaRuta (idRuta);
	}
	
}
