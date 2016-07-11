package beans;

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
		return login.login(perfil);
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
