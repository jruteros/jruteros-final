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
	
	private Float latitud;
	
	private Float longitud;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_ruta")
	private Ruta ruta;
	
	public Coordenada() {}
	
	public Coordenada(Float latitud, Float longitud, Ruta ruta) {
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
	
	public Float getLatitud() {
		return latitud;
	}
	
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	
	public Float getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
}
