package interfacesDAO;

import java.util.List;

import misClases.Perfil;

public interface PerfilDAO<T> extends GenericDAO<T> {
	public Perfil recuperarNombreUsuario (String nombreUsuario);
	public List<Perfil> recuperarNombre (String nombre);
}
