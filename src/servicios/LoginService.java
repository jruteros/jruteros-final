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
		Perfil p = perfilDAO.recuperarNombreUsuario(perfil.getNombreUsuario());
		if (p != null){
			// faltaría utilizar una utils.hashPassword() y comparar hashes.
			// el servicio de alta de usuario debe utilizar el mismo utils.hashPassword()
			if (p.getClave().compareTo(perfil.getClave()) == 0){
				// esto es feo, depende del contexto de jsf. Debería ser independiente del framework
				Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				Usuario u = DAOFactory.getUsuarioDAO().recuperar(p.getId_perfil());
				if ( u != null ){
					session.put("usuario", u);
					session.put("menu", "menuUsuario.xhtml");
					return "LoginUsuario";
				}else{
					Administrador a = DAOFactory.getAdministradorDAO().recuperar(p.getId_perfil());
					session.put("usuario", a);
					session.put("menu", "menuAdministrador.xhtml");
					return "LoginAdministrador";
				}
			}
			else
				return null;
		}else{
			return null;
		}
	}
}
