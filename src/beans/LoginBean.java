package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import misClases.Perfil;
import servicios.LoginService;
import servicios.LogoutService;

public class LoginBean {
	
	public String username;
	public String password;
	
	public LoginBean(){
		super();
	}
	
	public String login() {
		Perfil perfil = new Perfil();
		perfil.setClave(password);
		perfil.setNombreUsuario(username);
		LoginService login = new LoginService();
		String ret = login.login(perfil);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		if (ret!=null){
			if (ret.contentEquals("usuarioDeshabilitado")) {
				FacesMessage errorDeshabilitado = new FacesMessage("Usuario deshabilitado, contactese con un administrador");
				context.addMessage("formu", errorDeshabilitado);
				ret = "error";
			}
			if (ret.contentEquals("errorContraseña") || ret == null) {
				FacesMessage errorUserPassword = new FacesMessage("Usuario o contraseña incorrecta");
				context.addMessage("formu", errorUserPassword);
				ret = "error";
			}
		}else{
			FacesMessage errorUserPassword = new FacesMessage("Usuario o contraseña incorrecta");
			context.addMessage("formu", errorUserPassword);
			ret = "error";
		}
		return ret;
	}
	
	public String logout() {
		LogoutService logout = new LogoutService();
		logout.logout();
		return "Logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
