package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import clasesUtiles.RandomString;
import clasesUtiles.Sha256;
import misClases.Usuario;
import servicios.UsuarioService;

public class RegistrarBean {
	
	private  Usuario usuario;
	
	private String clave;
	
	public RegistrarBean() {
		this.usuario = new Usuario();
	}
	
	public String registrar() {
		UsuarioService userService = new UsuarioService();
		try{
			clave = userService.registrar(usuario);
			if (clave==null){
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage error= new FacesMessage("El usuario ya existe. Por favor elija otro.");
				context.addMessage("formu", error);
				return null;
			}
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			FacesMessage mensaje = new FacesMessage("Se ha regisrado correctamente");
			context.addMessage("mensaje", mensaje);
			return "login";
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
