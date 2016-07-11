package misClases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Administrador extends Perfil {
	public Administrador() { super();	}
	
	public Administrador(String nombre, String apellido, String nombreUsuario, String email
			, String clave, Integer dni, String domicilio, Sexo sexo) {
		super(nombre, apellido, nombreUsuario, email, clave, dni, domicilio, sexo);
	}
}