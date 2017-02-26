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

	@Override
	public boolean esRutaDeEsteUsuario(Long idRuta, Long idUsuario) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select r from Ruta r where r.id_ruta = ?1 AND r.usuario.id_perfil = ?2");
		consulta.setParameter(1, idRuta);
		consulta.setParameter(2, idUsuario);
		List<Ruta> resultado = (List<Ruta>) consulta.getResultList();
		return !resultado.isEmpty();
	}
	
}
