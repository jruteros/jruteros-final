package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Formato {
	
	@Id @GeneratedValue
	private Long id_formato;
	
	private String nombre;
	
	public Formato() {}
	
	public Formato(String nombre) {
		this.setNombre(nombre);
	}

	public Long getId_formato() {
		return id_formato;
	}
	
	public void setId_formato(Long id_formato) {
		this.id_formato = id_formato;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

