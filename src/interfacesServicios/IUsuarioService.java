package interfacesServicios;

import java.util.List;

import misClases.Usuario;

public interface IUsuarioService extends IGenericService<Usuario> {
	public List<Usuario> recuperarTodos();
}
