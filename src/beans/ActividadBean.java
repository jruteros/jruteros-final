package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha editado correctamente la actividad");
		context.addMessage("mensaje", mensaje);
		actividad.setNombre(this.nombreActividadNueva);
		actividadService.guardarActividadEditada(actividad);
		return "listadoActividades";
	}
	
	public String guardarActividad(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha dado de alta una nueva actividad");
		context.addMessage("mensaje", mensaje);
		actividadService.guardarActividad(actividad);
		return "listadoActividades";
	}
	
	public String habilitar (Actividad actividad){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha habilitado la actividad");
		context.addMessage("mensaje", mensaje);
		actividadService.habilitarActividad(actividad);
		return "listadoActividades";
	}
	
	public String deshabilitar (Actividad actividad){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha deshabilitado la actividad");
		context.addMessage("mensaje", mensaje);
		actividadService.deshabilitarActividad(actividad);
		return "listadoActividades";
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
