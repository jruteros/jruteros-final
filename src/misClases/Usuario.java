package misClases;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("usuario")
public class Usuario extends Perfil{
	
	@OneToMany(mappedBy="usuario")
	private Collection<Ruta> misRutas;

	@OneToMany(mappedBy="usuario")
	private Collection<Puntaje> misPuntajes;
	
	public Usuario() { super();	}
	
	public Usuario(String nombre, String apellido, String nombreUsuario, String email
			, String clave, Integer dni, String domicilio, Sexo sexo) {
		super(nombre, apellido, nombreUsuario, email, clave, dni, domicilio, sexo);
		this.setMisRutas(new ArrayList<Ruta>());
		this.setMisPuntajes(new ArrayList<Puntaje>());
	}

	public Collection<Ruta> getMisRutas() {
		return misRutas;
	}

	public void setMisRutas(Collection<Ruta> misRutas) {
		this.misRutas = misRutas;
	}

	public Collection<Puntaje> getMisPuntajes() {
		return misPuntajes;
	}

	public void setMisPuntajes(Collection<Puntaje> misPuntajes) {
		this.misPuntajes = misPuntajes;
	}

	public void agregarPuntaje(Puntaje puntaje) {
		this.getMisPuntajes().add(puntaje);
	}
	
	public void puntuarRuta(Ruta ruta, Integer puntos) {
		Puntaje puntaje = new Puntaje();
		puntaje.setPuntuacion(puntos);
		puntaje.setRuta(ruta);
		puntaje.setUsuario(this);
		this.agregarPuntaje(puntaje);
	}
	
	public void agregarRutaSubida(Ruta ruta) {
		this.getMisRutas().add(ruta);
		System.out.println(this.getMisRutas().size());
	}
}
