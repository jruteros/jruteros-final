package hibernateJPA;


import misClases.Sexo;
import interfacesDAO.SexoDAO;

public class SexoDAOHibernateJPA extends GenericDAOHibernateJPA<Sexo> implements SexoDAO {
	public SexoDAOHibernateJPA(){
		super(Sexo.class);
	}
}
