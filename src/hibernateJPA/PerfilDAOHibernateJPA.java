package hibernateJPA;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clasesUtiles.EMF;
import misClases.Perfil;
import interfacesDAO.PerfilDAO;


public class PerfilDAOHibernateJPA<T> extends GenericDAOHibernateJPA<T> implements PerfilDAO<T>{
  
	public PerfilDAOHibernateJPA(){
		 super((Class<T>)Perfil.class);
		
	}
	
	public PerfilDAOHibernateJPA(Class<T> clase){
		 super(clase);
		
	}
	


	@Override
	public Perfil recuperarNombreUsuario(String nombreUsuario) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select p from Perfil p where p.nombreUsuario =?1");
		consulta.setParameter(1, nombreUsuario);
		Perfil resultado = null;
		try{
		  resultado = (Perfil)consulta.getSingleResult();
		  }catch(NoResultException nre){}
		return resultado;
		
	}

	@Override
	public List<Perfil> recuperarNombre(String nombre ) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select p from " + getPersistentClass().getSimpleName()+" p where p.nombre=?1");
		consulta.setParameter(1, nombre);
		List<Perfil> resultado = (List<Perfil>)consulta.getResultList();
		if (resultado!=null)
		  return resultado;
		else return null;
	}


	
	

}
