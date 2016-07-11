package hibernateJPA;


import misClases.Privacidad;
import interfacesDAO.PrivacidadDAO;

public class PrivacidadDAOHibernateJPA extends GenericDAOHibernateJPA<Privacidad> implements PrivacidadDAO {
	
	public PrivacidadDAOHibernateJPA(){
		super(Privacidad.class);
	}
}
