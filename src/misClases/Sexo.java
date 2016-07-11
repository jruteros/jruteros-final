package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sexo {
	
	@Id @GeneratedValue
	private Long id_sexo;

	private String genero;
	
	public Sexo() {}
	
	public Sexo(String genero) {
		this.setGenero(genero);
	}

	public Long getId_sexo() {
		return id_sexo;
	}
	
	public void setId_sexo(Long id_sexo) {
		this.id_sexo = id_sexo;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
