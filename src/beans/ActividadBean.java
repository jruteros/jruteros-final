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
	private String nombreActividadNueva;
	
	public ActividadBean (){
		setListaActividades(actividadService.recuperarTodos());
		actividad = new Actividad();
	}
	
	public String verRutasAsociadas(Actividad actividad){
		setRutasAsociadas(rutaService.getRutasAsociadas(actividad.getId_actividad()));
     	return "administradorVerRutasAsociadas.xhtml";
	}
	
	public String editarNombreActividad(Actividad actividad){
		this.actividad = actividadService.recuperar(actividad.getId_actividad());
     	return "administradorEditarActividad.xhtml";
	}
	
	public String guardarActividadEditada(){
		actividad.setNombre(this.nombreActividadNueva);
		actividadService.guardarActividadEditada(actividad);
		return "listadoActividades";
	}
	
	public String guardarActividad(){
		actividadService.guardarActividad(actividad);
		return "listadoActividades";
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

	public String getNombreActividadNueva() {
		return nombreActividadNueva;
	}

	public void setNombreActividadNueva(String nombreActividadNueva) {
		this.nombreActividadNueva = nombreActividadNueva;
	}
	
}
