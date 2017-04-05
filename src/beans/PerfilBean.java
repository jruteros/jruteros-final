package beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import clasesUtiles.Sha256;
import misClases.Usuario;
import servicios.UsuarioService;

public class PerfilBean {
	
	private  Usuario usuario;
	
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
	
	public boolean validateMatchPassword(){
		return newPassword.contentEquals(confirmatePassword);
	}

	public String modificar() {
		UsuarioService userService = new UsuarioService();
		try{
			if (!(newPassword.isEmpty()) && !(confirmatePassword.isEmpty())){
				//si ambas no están vacías validar que sean iguales
				if (!(validateMatchPassword())){
					FacesContext context = FacesContext.getCurrentInstance();
					FacesMessage error= new FacesMessage("Las contraseñas deben coincidir.");
					context.addMessage("formu:newPassword", error);
					return null;
				}else{
					Sha256 hash = new Sha256();
					usuario.setClave(hash.getSha256(newPassword));
				}
			}
			// Aquí solo llega sí ambas fueron vacías o coinciden
			userService.modificar(usuario);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			FacesMessage mensaje = new FacesMessage("Se ha editado al usuario con exito");
			context.addMessage("mensaje", mensaje);
			session.put("usuario", usuario);
			return "editarPerfil";
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
