package hibernateJPA;

import misClases.Ruta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import clasesUtiles.EMF;
import interfacesDAO.RutaDAO;


public class RutaDAOHibernateJPA extends GenericDAOHibernateJPA<Ruta> implements RutaDAO{
	public RutaDAOHibernateJPA(){
		super(Ruta.class);
	}

	@Override
	public List<Ruta> getRutasAsociadas(Long idActividad) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		List<Ruta> resultado = null;
		try{
			Query consulta = EMF.getEMF().createEntityManager().createQuery("select r from Ruta r where r.actividad.id_actividad = ?1");
			consulta.setParameter(1, idActividad);
			resultado = (List<Ruta>) consulta.getResultList();
		}finally {
			emf.close();
		}
		return resultado;
		
	}

	@Override
	public boolean esRutaDeEsteUsuario(Long idRuta, Long idUsuario) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		List<Ruta> resultado = null;
		try{
			Query consulta = EMF.getEMF().createEntityManager().createQuery("select r from Ruta r where r.id_ruta = ?1 AND r.usuario.id_perfil = ?2");
			consulta.setParameter(1, idRuta);
			consulta.setParameter(2, idUsuario);
		    resultado = (List<Ruta>) consulta.getResultList();
		}finally {
			emf.close();
		}
		return !resultado.isEmpty();
	}

	@Override
	public List<Ruta> recuperarTodasMisRutas(Long idUsuario) {
		EntityManager emf = EMF.getEMF().createEntityManager();
		List<Ruta> resultado = null;
		try{
			Query consulta = EMF.getEMF().createEntityManager().createQuery("select r from Ruta r where r.usuario.id_perfil = ?1");
			consulta.setParameter(1, idUsuario);
		    resultado = (List<Ruta>) consulta.getResultList();
		}finally {
			emf.close();
		}
		return resultado;
	}
	
}
