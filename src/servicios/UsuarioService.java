package servicios;

import java.util.List;

import interfacesDAO.UsuarioDAO;
import interfacesServicios.IUsuarioService;
import misClases.Usuario;
import clasesUtiles.DAOFactory;
import clasesUtiles.RandomString;
import clasesUtiles.SendMail;
import clasesUtiles.Sha256;

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

	public void habilitarUsuario(Usuario usuario) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		usuario.setHabilitado(true);
		userDao.actualizar(usuario);
	}

	public void deshabilitarUsuario(Usuario usuario) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		usuario.setHabilitado(false);
		System.out.println(usuario.getApellido());
		userDao.actualizar(usuario);	
	}
	
	public Usuario recuperar(Long id) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		return userDao.recuperar(id);	
	}
	
	public String registrar(Usuario u) throws Exception {
		if (this.existeUsuario(u.getNombreUsuario()))
			return null;
		Sha256 hash = new Sha256();
		String clave = RandomString.randomString(6);
		SendMail mail = new SendMail(u.getEmail(), "Bienvenido a JRuteros "+ u.getNombre()+ ".\n\n"+
				"Su clave de ingreso es: "+clave + ".\n Por favor, por seguridad se recomienda que la cambie.\n\n Equipo de JRuteros.");
		mail.start();
		u.setClave(hash.getSha256(clave));
		if (this.alta(u)!= null){
			return clave;
		}else{
			return null;
		}
	}

	public boolean existeUsuario(String nombreUsuario) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		return (userDao.recuperarNombreUsuario(nombreUsuario)!=null);
	}
	

}
