package hibernateJPA;

import interfacesDAO.DificultadDAO;
import misClases.Dificultad;

public class DificultadDAOHibernateJPA extends GenericDAOHibernateJPA<Dificultad> implements DificultadDAO{


	public DificultadDAOHibernateJPA(){
		super(Dificultad.class);
	}
}
