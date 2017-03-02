package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coordenada {

	@Id @GeneratedValue
	private Long id_coordenada;
	
	private Double latitud;
	
	private Double longitud;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_ruta")
	private Ruta ruta;
	
	public Coordenada() {}
	
	public Coordenada(Double latitud, Double longitud, Ruta ruta) {
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setRuta(ruta);
	}
	
	public Long getId_coordenada() {
		return id_coordenada;
	}
	
	public void setId_coordenada(Long id_coordenada) {
		this.id_coordenada = id_coordenada;
	}
	
	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Ruta getRuta() {
		return ruta;
	}
	
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
}
