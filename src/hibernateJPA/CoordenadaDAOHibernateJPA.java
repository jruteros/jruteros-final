package hibernateJPA;

import interfacesDAO.CoordenadaDAO;

import misClases.Coordenada;

public class CoordenadaDAOHibernateJPA extends GenericDAOHibernateJPA<Coordenada> implements CoordenadaDAO{

	public CoordenadaDAOHibernateJPA(){
		super(Coordenada.class);
	}
}
