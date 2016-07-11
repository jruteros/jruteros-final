package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actividad {
	
	@Id @GeneratedValue
	private Long id_actividad;
	
	private String nombre;
	
	public Actividad() {}
	
	public Actividad(String nombre) {
		this.setNombre(nombre);
	}
	
	public Long getId_actividad() {
		return id_actividad;
	}
	
	public void setId_actividad(Long id_actividad) {
		this.id_actividad = id_actividad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
