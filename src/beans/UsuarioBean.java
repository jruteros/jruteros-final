package beans;

import interfacesDAO.UsuarioDAO;

import java.util.List;

import servicios.UsuarioService;
import clasesUtiles.DAOFactory;
import misClases.Usuario;

public class UsuarioBean {

	private UsuarioService usuarioService = new UsuarioService();
	private Usuario usuario = new Usuario();
	private List<Usuario> listaUsuarios;

	public UsuarioBean() {
		listaUsuarios = usuarioService.recuperarTodos();
	}

	public String listarUsuarios() {
		listaUsuarios = usuarioService.recuperarTodos();
		return "administradorAdminUsuarios.xhtml?faces-redirect=true";
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
