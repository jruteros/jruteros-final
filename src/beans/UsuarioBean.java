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
	
	public String listarUsuarios(){
		listaUsuarios = usuarioService.recuperarTodos();
		return "administradorAdminUsuarios.xhtml?faces-redirect=true";
	}
}
