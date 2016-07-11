package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dificultad {
	
	@Id @GeneratedValue
	private Long id_dificultad;
	
	private String nombre;
	
	public Dificultad() {}
	
	public Dificultad(String nombre) {
		this.setNombre(nombre);
	}
	
	public Long getId_dificultad() {
		return id_dificultad;
	}
	
	public void setId_dificultad(Long id_dificultad) {
		this.id_dificultad = id_dificultad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
