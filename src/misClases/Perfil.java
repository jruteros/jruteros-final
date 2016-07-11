package misClases;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
@DiscriminatorColumn(name="tipo_perfil")
public class Perfil {
	@Id @GeneratedValue
	private Long id_perfil;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_sexo")
	private Sexo sexo;
	
	private String nombre;
	
	private String apellido;
	
	private String nombreUsuario;
	
	private String clave;
	
	private Integer dni;
	
	private String email;
	
	private String domicilio;
	
	public Perfil(){}
	
	public Perfil(String nombre, String apellido, String nombreUsuario, String email
			, String clave, Integer dni, String domicilio, Sexo sexo) {
		this.setNombre(nombre);
		this.setNombreUsuario(nombreUsuario);
		this.setApellido(apellido);
		this.setClave(clave);
		this.setDni(dni);
		this.setEmail(email);
		this.setDomicilio(domicilio);
		this.setSexo(sexo);
	}
	
	public Long getId_perfil() {
		return id_perfil;
	}
	
	public void setId_perfil(Long id_perfil) {
		this.id_perfil = id_perfil;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public Integer getDni() {
		return dni;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
}
