package hibernateJPA;

import java.util.List;

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
}
