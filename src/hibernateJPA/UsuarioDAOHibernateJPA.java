package hibernateJPA;

import java.util.List;


import javax.persistence.Query;



import misClases.Usuario;
import clasesUtiles.EMF;
import interfacesDAO.UsuarioDAO;


public class UsuarioDAOHibernateJPA extends PerfilDAOHibernateJPA<Usuario> implements UsuarioDAO  {

	public UsuarioDAOHibernateJPA(){
		super(Usuario.class);
	}
	
	

	

}
