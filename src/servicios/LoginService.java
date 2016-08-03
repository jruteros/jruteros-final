package servicios;

import interfacesServicios.ILoginService;
import misClases.Administrador;
import misClases.Perfil;
import misClases.Usuario;

import java.util.Map;

import javax.faces.context.FacesContext;

import clasesUtiles.DAOFactory;
import clasesUtiles.Sha256;
import interfacesDAO.PerfilDAO;
import interfacesDAO.UsuarioDAO;

public class LoginService implements ILoginService{

	public String login(Perfil perfil){
		PerfilDAO<Perfil> perfilDAO = DAOFactory.getPerfilDAO();
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Perfil p = null;
		p = perfilDAO.recuperarNombreUsuario(perfil.getNombreUsuario());
		if (p!=null){
			Sha256 hash = new Sha256();
			if (p.getClass().getSimpleName().contentEquals("Usuario")){
				Usuario u = usuarioDAO.recuperar(p.getId_perfil());
				if (!(u.isHabilitado()))
					return "usuarioDeshabilitado";
			}
			if (p.getClave().compareTo(hash.getSha256(perfil.getClave()) ) != 0){
				//return null;
				return "errorContraseña";
				//throw new PasswordsNoCoindenException();
			}else{
				Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				session.put("perfil", p);
				session.put("menu", "menu"+p.getClass().getSimpleName()+".xhtml");
				return "Login"+p.getClass().getSimpleName();
			}
		}else {
			return null;
		}
	}
}
