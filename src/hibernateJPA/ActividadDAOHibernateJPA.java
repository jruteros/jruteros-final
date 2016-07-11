package hibernateJPA;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clasesUtiles.EMF;
import interfacesDAO.ActividadDAO;



import misClases.Actividad;
import misClases.Administrador;







public class ActividadDAOHibernateJPA extends GenericDAOHibernateJPA<Actividad> implements ActividadDAO {


	public ActividadDAOHibernateJPA(){
		super(Actividad.class);
	}
	
	@Override
	public boolean existeActividad(String actividad) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("SELECT a FROM Actividad a WHERE a.nombre =?1");
		consulta.setParameter(1, actividad);
		Actividad resultado = null;
		try{
			resultado = (Actividad)consulta.getSingleResult();
			}catch(NoResultException nre){}
		 
		if(resultado!=null)
			return true;
		else return false;
	}

	


}
