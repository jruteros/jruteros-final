package hibernateJPA;


import misClases.Administrador;
import interfacesDAO.AdministradorDAO;


public class AdministradorDAOHibernateJPA extends PerfilDAOHibernateJPA<Administrador> implements AdministradorDAO {
	
	public AdministradorDAOHibernateJPA(){
		super(Administrador.class);
	}
	


}
