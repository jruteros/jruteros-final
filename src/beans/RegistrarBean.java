package beans;

import misClases.Usuario;
import servicios.UsuarioService;

public class RegistrarBean {
	
	private  Usuario usuario;
	
	public RegistrarBean() {
		this.usuario = new Usuario();
	}
	
	public String registrar() {
		UsuarioService userService = new UsuarioService();
		try{
			this.usuario.setClave("password");
			userService.alta(usuario);
			return "registroExitoso.xhtml";
		}catch (Exception e){
			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
