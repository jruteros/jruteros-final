package hibernateJPA;


import misClases.Puntaje;
import interfacesDAO.PuntajeDAO;

public class PuntajeDAOHibernateJPA extends GenericDAOHibernateJPA<Puntaje> implements PuntajeDAO {
	
	public PuntajeDAOHibernateJPA(){
		super(Puntaje.class);
	}

}
