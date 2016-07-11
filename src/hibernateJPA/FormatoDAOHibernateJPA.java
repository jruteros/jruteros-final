package hibernateJPA;

import interfacesDAO.FormatoDAO;
import misClases.Formato;

public class FormatoDAOHibernateJPA extends GenericDAOHibernateJPA<Formato> implements FormatoDAO {

	public FormatoDAOHibernateJPA(){
		super(Formato.class);
	}
}
