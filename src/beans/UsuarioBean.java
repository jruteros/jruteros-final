package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import servicios.UsuarioService;
import misClases.Usuario;

public class UsuarioBean {

	private UsuarioService usuarioService = new UsuarioService();
	private List<Usuario> listaUsuarios;
	private Usuario usuario;

	public UsuarioBean() {
		listaUsuarios = usuarioService.recuperarTodos();
	}
	
	public String verMas(Usuario usuario){
		this.usuario = usuario;
     	return "administradorVerMas.xhtml";
	}
	
	public void habilitar (Usuario usuario){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha habilitado al usuario");
		context.addMessage("mensaje", mensaje);
		usuarioService.habilitarUsuario(usuario);
	}
	
	public void deshabilitar (Usuario usuario){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha deshabilitado al usuario");
		context.addMessage("mensaje", mensaje);
		usuarioService.deshabilitarUsuario(usuario);
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
