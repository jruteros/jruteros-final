package beans;

import java.util.List;

import misClases.Actividad;
import misClases.Ruta;
import misClases.Usuario;
import servicios.ActividadService;
import servicios.RutaService;

public class ActividadBean {
	
	private ActividadService actividadService = new ActividadService();
	private RutaService rutaService = new RutaService();
	private List<Actividad> listaActividades;
	private Actividad actividad;
	private List<Ruta> rutasAsociadas;
	
	public ActividadBean (){
		setListaActividades(actividadService.recuperarTodos());
	}
	
	public String verRutasAsociadas(Actividad actividad){
		setRutasAsociadas(rutaService.getRutasAsociadas(actividad.getId_actividad()));
     	return "administradorVerRutasAsociadas.xhtml";
	}
	
	public void habilitar (Actividad actividad){
		actividadService.habilitarActividad(actividad);
	}
	
	public void deshabilitar (Actividad actividad){
		actividadService.deshabilitarActividad(actividad);
	}

	public List<Actividad> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public List<Ruta> getRutasAsociadas() {
		return rutasAsociadas;
	}

	public void setRutasAsociadas(List<Ruta> rutasAsociadas) {
		this.rutasAsociadas = rutasAsociadas;
	}
	
}
