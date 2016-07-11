package hibernateJPA;

import interfacesDAO.ImagenDAO;
import misClases.Imagen;

public class ImagenDAOHibernateJPA extends GenericDAOHibernateJPA<Imagen> implements ImagenDAO {

	public ImagenDAOHibernateJPA(){
		super(Imagen.class);
	}
} 
