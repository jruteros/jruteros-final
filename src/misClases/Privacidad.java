package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Privacidad {
	
	@Id @GeneratedValue
	private Long id_privacidad;
	
	private String nombre;
	
	public Privacidad() {}
	
	public Privacidad(String nombre) {
		this.setNombre(nombre);
	}
	
	public Long getId_privacidad() {
		return id_privacidad;
	}
	
	public void setId_privacidad(Long id_privacidad) {
		this.id_privacidad = id_privacidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
