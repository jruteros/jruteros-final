package servicios;

import java.util.List;

import interfacesDAO.UsuarioDAO;
import interfacesServicios.IUsuarioService;
import misClases.Usuario;
import clasesUtiles.DAOFactory;

public class UsuarioService implements IUsuarioService{

	@Override
	public Usuario alta(Usuario entidad) throws Exception {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		userDao.persistir(entidad);
		return entidad;
	}

	@Override
	public Usuario baja(Usuario entidad) throws Exception {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		userDao.borrar(entidad);
		return null;
	}

	@Override
	public Usuario modificar(Usuario entidad) throws Exception {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		userDao.actualizar(entidad);
		return entidad;
	}

	@Override
	public List<Usuario> recuperarTodos() {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		return userDao.recuperarTodos();
	}

	

}
