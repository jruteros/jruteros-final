package hibernateJPA;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesUtiles.EMF;
import interfacesDAO.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
protected Class<T> persistentClass;
	public GenericDAOHibernateJPA(){}
	
	public GenericDAOHibernateJPA(Class<T> persistentClass){
		this.persistentClass= persistentClass;
	}
	@Override
	public T actualizar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
		tx = em.getTransaction();
		tx.begin();
		em.merge(entity);
		tx.commit();
		}
		catch (RuntimeException e) {
		if ( tx != null && tx.isActive() ) tx.rollback();
		throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
		em.close();
		}
		return entity;
	}

	@Override
	public void borrar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
		tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(entity)); // em.remove(em.merge(obj));
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

	@Override
	public T borrar(Serializable id) {
		T entity = EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
	
		this.borrar(entity);
		}
	
		return entity;
	}

	@Override
	public boolean existe(Serializable id) {
		T entity = EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) 
			return true;
		else
			return false;
			
	}

	@Override
	public T persistir(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
		tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		}
		catch (RuntimeException e) {
		if ( tx != null && tx.isActive() ) tx.rollback();
		throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
		em.close();
		}
		return entity;
	}

	@Override
	public T recuperar(Serializable id) {
		T entity = EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id);
		return entity; 
	}
		
	
	@Override
	public List<T> recuperarTodos() {

		Query consulta= EMF.getEMF().createEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName()+" e");
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}

	

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}


}
