package servicios;

import interfacesServicios.ILoginService;
import misClases.Administrador;
import misClases.Perfil;
import misClases.Usuario;

import java.util.Map;

import javax.faces.context.FacesContext;

import clasesUtiles.DAOFactory;
import interfacesDAO.PerfilDAO;

public class LoginService implements ILoginService{

	public String login(Perfil perfil){
		PerfilDAO<Perfil> perfilDAO = DAOFactory.getPerfilDAO();
		Perfil p = null;
		p = perfilDAO.recuperarNombreUsuario(perfil.getNombreUsuario());
		if (p!=null){
			Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			session.put("perfil", p);
			session.put("menu", "menu"+p.getClass().getSimpleName()+".xhtml");
			return "Login"+p.getClass().getSimpleName();
		}else {
			return null;
		}
	}
}
