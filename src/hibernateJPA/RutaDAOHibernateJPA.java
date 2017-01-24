package hibernateJPA;


import misClases.Actividad;
import misClases.Perfil;
import misClases.Ruta;

import java.util.List;

import javax.persistence.Query;

import clasesUtiles.EMF;
import interfacesDAO.RutaDAO;

public class RutaDAOHibernateJPA extends GenericDAOHibernateJPA<Ruta> implements RutaDAO{
	public RutaDAOHibernateJPA(){
		super(Ruta.class);
	}

	@Override
	public List<Ruta> getRutasAsociadas(Long idActividad) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select r from Ruta r where r.actividad.id_actividad = ?1");
		consulta.setParameter(1, idActividad);
		List<Ruta> resultado = (List<Ruta>) consulta.getResultList();
		return resultado;
		
	}
	
	/*
	 @Override
	public List<Perfil> recuperarNombre(String nombre ) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select p from " + getPersistentClass().getSimpleName()+" p where p.nombre=?1");
		consulta.setParameter(1, nombre);
		List<Perfil> resultado = (List<Perfil>)consulta.getResultList();
		if (resultado!=null)
		  return resultado;
		else return null;
	}
	 */
}
