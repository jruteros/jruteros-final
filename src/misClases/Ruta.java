package misClases;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ruta {
	
	@Id @GeneratedValue
	private Long id_ruta;
	
	private String nombre;
	
	private String descripcion;
	
	private Float distancia;
	
	private Time tiempo_estimado;
	
	private Date fecha_realizacion;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_formato")
	private Formato formato;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_actividad")
	private Actividad actividad;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_dificultad")
	private Dificultad dificultad;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id_privacidad")
	private Privacidad privacidad;
	

	@OneToMany(mappedBy="ruta")	
	private Collection<Puntaje> puntajes;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="ruta")
	private Collection<Coordenada>coordenadas;
	
	@OneToMany(mappedBy="ruta")
	private Collection<Imagen>imagenes;
	
	public Ruta() {	}
	
	public Ruta(String nombre, String descripcion, Float distancia, 
			Time tiempo_estimado, Date fecha_realizacion, Usuario usuario,
			Formato formato, Actividad actividad, Dificultad dificultad, Privacidad privacidad) {
		this.puntajes = new ArrayList<Puntaje>();
		this.coordenadas = new ArrayList<Coordenada>();
		this.imagenes = new ArrayList<Imagen>();
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDistancia(distancia);
		this.setTiempo_estimado(tiempo_estimado);
		this.setFecha_realizacion(fecha_realizacion);
		this.setUsuario(usuario);
		this.setFormato(formato);
		this.setActividad(actividad);
		this.setPrivacidad(privacidad);
		this.setDificultad(dificultad);
	}

	public Long getId_ruta() {
		return id_ruta;
	}
	
	public void setId_ruta(Long id_ruta) {
		this.id_ruta = id_ruta;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Float getDistancia() {
		return distancia;
	}
	
	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}
	
	public Time getTiempo_estimado() {
		return tiempo_estimado;
	}
	
	public void setTiempo_estimado(Time tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}
	
	public Date getFecha_realizacion() {
		return fecha_realizacion;
	}
	
	public void setFecha_realizacion(Date fecha_realizacion) {
		this.fecha_realizacion = fecha_realizacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Formato getFormato() {
		return formato;
	}
	
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	public Actividad getActividad() {
		return actividad;
	}
	
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	public Dificultad getDificultad() {
		return dificultad;
	}
	
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
		
	public Collection<Puntaje> getPuntajes() {
		return puntajes;
	}
	
	public void setPuntajes(Collection<Puntaje> puntajes) {
		this.puntajes = puntajes;
	}
	
	public Collection<Coordenada> getCoordenadas() {
		return coordenadas;
	}
	
	public void setCoordenadas(Collection<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	public Collection<Imagen> getImagenes() {
		return imagenes;
	}
	
	public void setImagenes(Collection<Imagen> imagenes) {
		this.imagenes = imagenes;
	}
	
	public Privacidad getPrivacidad() {
		return privacidad;
	}
	
	public void setPrivacidad(Privacidad privacidad) {
		this.privacidad = privacidad;
	}
	
	public void agregarCoordenada(Float latitud, Float longitud) {
		this.getCoordenadas().add(new Coordenada(latitud, longitud, this));
	}
}
