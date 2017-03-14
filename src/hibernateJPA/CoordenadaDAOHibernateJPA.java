package hibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesUtiles.EMF;
import interfacesDAO.CoordenadaDAO;

import misClases.Coordenada;

public class CoordenadaDAOHibernateJPA extends GenericDAOHibernateJPA<Coordenada> implements CoordenadaDAO{

	public CoordenadaDAOHibernateJPA(){
		super(Coordenada.class);
	}

	@Override
	public List<Coordenada> recuperarTodos(Long idRuta) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("SELECT c FROM Coordenada c WHERE c.ruta.id_ruta =?1");
		consulta.setParameter(1, idRuta);
		List<Coordenada> resultado = (List<Coordenada>)consulta.getResultList();
		return resultado;
	}
	
	@Override
	public void eliminarCoordenadasParaEstaRuta(Long idRuta) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Query consulta = em.createQuery("DELETE FROM Coordenada c WHERE c.ruta.id_ruta =?1");
			consulta.setParameter(1, idRuta);
			consulta.executeUpdate();
			tx.commit();
		}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
		em.close();
		}
		
	}
	
	
}
