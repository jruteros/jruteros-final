package hibernateJPA;


import misClases.Ruta;
import interfacesDAO.RutaDAO;

public class RutaDAOHibernateJPA extends GenericDAOHibernateJPA<Ruta> implements RutaDAO{
	public RutaDAOHibernateJPA(){
		super(Ruta.class);
	}
}
