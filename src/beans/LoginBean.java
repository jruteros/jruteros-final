package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import misClases.Perfil;
import servicios.LoginService;

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
		if (ret == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage errorUserPassword = new FacesMessage("Usuario o contraseña incorrecta");
			context.addMessage("formu", errorUserPassword);
		}
		return ret;
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
