package beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import misClases.Usuario;
import servicios.UsuarioService;

public class PerfilBean {
	
	private  Usuario usuario;
	
	private String oldPassword;
	private String newPassword;
	private String confirmatePassword;
	Map<String,Object> session;
	
	
	public PerfilBean() {
		
	}
	
	@PostConstruct
	public void init() {
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		usuario = (Usuario) session.get("perfil");
	}

	public String modificar() {
		UsuarioService userService = new UsuarioService();
		try{			
			userService.modificar(usuario);
			session.put("usuario", usuario);
			return "registroExitoso.xhtml?faces-redirect=true&id=" + this.usuario.getId_perfil();
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmatePassword() {
		return confirmatePassword;
	}

	public void setConfirmatePassword(String confirmatePassword) {
		this.confirmatePassword = confirmatePassword;
	}
}
