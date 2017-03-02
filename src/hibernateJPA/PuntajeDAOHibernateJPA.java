package hibernateJPA;

import misClases.Puntaje;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import clasesUtiles.EMF;
import interfacesDAO.PuntajeDAO;


public class PuntajeDAOHibernateJPA extends GenericDAOHibernateJPA<Puntaje> implements PuntajeDAO {
	
	public PuntajeDAOHibernateJPA(){
		super(Puntaje.class);
	}

	@Override
	public boolean hizoEsteUsuarioEstaRuta(Long idUsuario, Long idRuta) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		List<Puntaje> resultado = null;
		try{
			Query consulta = emf.createQuery("select p from Puntaje p where p.usuario.id_perfil = ?1 AND p.ruta.id_ruta = ?2 AND p.puntuacion IS NULL");
			consulta.setParameter(1, idUsuario);
			consulta.setParameter(2, idRuta);
			resultado = (List<Puntaje>) consulta.getResultList();
		}finally {
			emf.close();
		}
		return !resultado.isEmpty();
	}

	@Override
	public Puntaje obtenerPuntajeConPuntuacionNull(Long idUsuario, Long idRuta) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		Puntaje resultado = null;
		try{
			Query consulta = emf.createQuery("select p from Puntaje p where p.usuario.id_perfil = ?1 AND p.ruta.id_ruta = ?2 AND p.puntuacion IS NULL");
			consulta.setParameter(1, idUsuario);
			consulta.setParameter(2, idRuta);
			try{
			  resultado = (Puntaje)consulta.getSingleResult();
			  }catch(NoResultException nre){}
		}finally{
			emf.close();
		}
			return resultado;
	}

	@Override
	public boolean esteUsuarioPuntuoEstaRuta(Long idUsuario, Long idRuta) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		List<Puntaje> resultado = null;
		try{
			Query consulta = emf.createQuery("select p from Puntaje p where p.usuario.id_perfil = ?1 AND p.ruta.id_ruta = ?2 AND p.puntuacion IS NOT NULL");
			consulta.setParameter(1, idUsuario);
			consulta.setParameter(2, idRuta);
			resultado = (List<Puntaje>) consulta.getResultList();
		}finally {
			emf.close();
		}
		return !resultado.isEmpty();
	}
	
	@Override
	public Puntaje obtenerPuntaje(Long idUsuario, Long idRuta) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		Puntaje resultado = null;
		try{
			Query consulta = emf.createQuery("select p from Puntaje p where p.usuario.id_perfil = ?1 AND p.ruta.id_ruta = ?2 AND p.puntuacion IS NOT NULL");
			consulta.setParameter(1, idUsuario);
			consulta.setParameter(2, idRuta);
			try{
			  resultado = (Puntaje)consulta.getSingleResult();
			  }catch(NoResultException nre){}
		}finally{
			emf.close();
		}
		return resultado;
	}


}
