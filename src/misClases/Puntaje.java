package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Puntaje {
	
	@Id @GeneratedValue
	private Long id_puntaje;
	
	private int puntuacion;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_ruta")
	private Ruta ruta;
	
	public Puntaje() {}
	
	public Puntaje(Ruta ruta, Usuario usuario, Integer puntos) {
		this.setRuta(ruta);
		this.setUsuario(usuario);
		this.setPuntuacion(puntos);
	}
	
	public Long getId_puntaje() {
		return id_puntaje;
	}
	
	public void setId_puntaje(Long id_puntaje) {
		this.id_puntaje = id_puntaje;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
}