package beans;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import clasesUtiles.DAOFactory;
import misClases.Actividad;
import misClases.Coordenada;
import misClases.Dificultad;
import misClases.Formato;
import misClases.Privacidad;
import misClases.Ruta;
import misClases.Usuario;
import servicios.ActividadService;
import servicios.RutaService;

public class RutaBean {

	private Ruta ruta;
	private List<Actividad> actividades;
	private List<Dificultad> dificultades;
	private List<Formato> formatos;
	private List<Privacidad> privacidades;
	
	List<Ruta> listaRutas;
	RutaService rutaService = new RutaService();	
	
	public RutaBean (){
		this.actividades = new ActividadService().recuperarHabilitadas();
		this.dificultades = DAOFactory.getDificultadDAO().recuperarTodos();
		this.formatos = DAOFactory.getFormatoDAO().recuperarTodos();
		this.privacidades = DAOFactory.getPrivacidadDAO().recuperarTodos();
		this.ruta = new Ruta();
		ruta.setPrivacidad(new Privacidad());
		ruta.setDificultad(new Dificultad());
		ruta.setFormato(new Formato());
		ruta.setActividad(new Actividad());
		listaRutas = rutaService.recuperarTodas();
	}
	
	@PostConstruct
	public void init() {
		
		
	}
	
	public boolean esRutaPropia(Ruta ruta){
		Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Usuario usuario = (Usuario)session.get("perfil");
		return rutaService.esRutaDeEsteUsuario(ruta.getId_ruta(),usuario.getId_perfil());
	}

	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public List<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}
	public List<Dificultad> getDificultades() {
		return dificultades;
	}
	public void setDificultades(List<Dificultad> dificultades) {
		this.dificultades = dificultades;
	}
	public List<Formato> getFormatos() {
		return formatos;
	}
	public void setFormatos(List<Formato> formatos) {
		this.formatos = formatos;
	}
	public List<Privacidad> getPrivacidades() {
		return privacidades;
	}
	public void setPrivacidades(List<Privacidad> privacidades) {
		this.privacidades = privacidades;
	}
	
	
	public List<Ruta> getListaRutas() {
		return listaRutas;
	}

	public void setListaRutas(List<Ruta> listaRutas) {
		this.listaRutas = listaRutas;
	}

	public void alta (){
		Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Collection<Coordenada> coordenadas = (List<Coordenada>) session.get("coordenadas");
		ruta.setCoordenadas(coordenadas);
		rutaService.guardarRuta(ruta);
	}
	
}
