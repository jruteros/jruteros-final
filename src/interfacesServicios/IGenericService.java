package interfacesServicios;

public interface IGenericService<T> {
	public abstract T alta(T entidad) throws Exception;
	public abstract T baja(T entidad) throws Exception;
	public abstract T modificar(T entidad) throws Exception;
}
