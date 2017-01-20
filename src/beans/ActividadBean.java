package beans;

import java.util.List;

import misClases.Actividad;
import servicios.ActividadService;

public class ActividadBean {
	
	private ActividadService actividadService = new ActividadService();
	private List<Actividad> listaActividades;
	private Actividad actividad;
	
	public ActividadBean (){
		setListaActividades(actividadService.recuperarTodos());
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
	
}
