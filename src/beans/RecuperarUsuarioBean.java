package beans;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import misClases.Usuario;
import servicios.UsuarioService;

public class RecuperarUsuarioBean {
	
	private Usuario usuario;

	public RecuperarUsuarioBean(){
		
	}
	
	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (id == null){
			usuario = new Usuario();
		}else{
			Long id_perfil = Long.valueOf(id);
			UsuarioService userService = new UsuarioService();
			usuario = userService.recuperar(id_perfil);
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
