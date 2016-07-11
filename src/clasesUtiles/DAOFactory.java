package clasesUtiles;

import hibernateJPA.ActividadDAOHibernateJPA;
import hibernateJPA.AdministradorDAOHibernateJPA;
import hibernateJPA.CoordenadaDAOHibernateJPA;
import hibernateJPA.DificultadDAOHibernateJPA;
import hibernateJPA.FormatoDAOHibernateJPA;
import hibernateJPA.ImagenDAOHibernateJPA;
import hibernateJPA.PerfilDAOHibernateJPA;
import hibernateJPA.PrivacidadDAOHibernateJPA;
import hibernateJPA.PuntajeDAOHibernateJPA;
import hibernateJPA.RutaDAOHibernateJPA;
import hibernateJPA.SexoDAOHibernateJPA;
import hibernateJPA.UsuarioDAOHibernateJPA;
import interfacesDAO.ActividadDAO;
import interfacesDAO.AdministradorDAO;
import interfacesDAO.CoordenadaDAO;
import interfacesDAO.DificultadDAO;
import interfacesDAO.FormatoDAO;
import interfacesDAO.ImagenDAO;
import interfacesDAO.PerfilDAO;
import interfacesDAO.PrivacidadDAO;
import interfacesDAO.PuntajeDAO;
import interfacesDAO.RutaDAO;
import interfacesDAO.SexoDAO;
import interfacesDAO.UsuarioDAO;
import misClases.Perfil;


public class DAOFactory {
	
	public static ActividadDAO getActividadDAO(){
		return new ActividadDAOHibernateJPA();
	}
	
	public static PerfilDAO<Perfil> getPerfilDAO(){
		return new PerfilDAOHibernateJPA<Perfil>();
	}
	
	public static AdministradorDAO getAdministradorDAO(){
		return new AdministradorDAOHibernateJPA();
	}
	
	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOHibernateJPA();
	}
	
	public static CoordenadaDAO getCoordenadaDAO(){
		return new CoordenadaDAOHibernateJPA();
	}
	
	public static DificultadDAO getDificultadDAO(){
		return new DificultadDAOHibernateJPA();
	}
	
	public static FormatoDAO getFormatoDAO(){
		return new FormatoDAOHibernateJPA();
	}
	
	public static ImagenDAO getImagenDAO(){
		return new ImagenDAOHibernateJPA();
	}
	
	public static PrivacidadDAO getPrivacidadDAO(){
		return new PrivacidadDAOHibernateJPA();
	}
	
	public static PuntajeDAO getPuntajeDAO(){
		return new PuntajeDAOHibernateJPA();
	}
	
	public static RutaDAO getRutaDAO(){
		return new RutaDAOHibernateJPA();
	}
	
	public static SexoDAO getSexoDAO(){
		return new SexoDAOHibernateJPA();
	}
	
	
	
}

