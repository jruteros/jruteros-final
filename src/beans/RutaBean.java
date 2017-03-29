package beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import clasesUtiles.DAOFactory;
import misClases.Actividad;
import misClases.Dificultad;
import misClases.Formato;
import misClases.Privacidad;
import misClases.Puntaje;
import misClases.Ruta;
import misClases.Usuario;
import rest.jersey.Coordenada;
import servicios.ActividadService;
import servicios.PuntajeService;
import servicios.RutaService;


public class RutaBean {

	private Ruta ruta;
	private List<Actividad> actividades;
	private List<Dificultad> dificultades;
	private List<Formato> formatos;
	private List<Privacidad> privacidades;
	private Usuario usuarioActivo;
	private Map<String,Object> session;
	private List<Ruta> listaRutas;
	private RutaService rutaService = new RutaService();
	private PuntajeService puntajeService = new PuntajeService();
	private Integer puntajeRuta;
	private Integer cantidadUsuarios;
	private Double promedio;
	
	
	public RutaBean (){
		this.actividades = new ActividadService().recuperarHabilitadas();
		this.dificultades = DAOFactory.getDificultadDAO().recuperarTodos();
		this.formatos = DAOFactory.getFormatoDAO().recuperarTodos();
		this.privacidades = DAOFactory.getPrivacidadDAO().recuperarTodos();
		this.ruta = new Ruta();
		ruta.setDistancia(Float.valueOf(0));
		ruta.setFecha_realizacion(new Date());
		ruta.setPrivacidad(new Privacidad());
		ruta.setDificultad(new Dificultad());
		ruta.setFormato(new Formato());
		ruta.setActividad(new Actividad());
		listaRutas = rutaService.recuperarTodas();
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		usuarioActivo = (Usuario)session.get("perfil");
	}
	
	@PostConstruct
	public void init() {
		
		
	}
	
	public boolean esRutaPropia(Ruta ruta){
		return rutaService.esRutaDeEsteUsuario(ruta.getId_ruta(),usuarioActivo.getId_perfil());
	}
	
	public boolean yoLaHice (Ruta ruta){
		return puntajeService.hizoEsteUsuarioEstaRuta(usuarioActivo.getId_perfil(), ruta.getId_ruta());
	}
	
	public boolean yoLaPuntee(Ruta ruta){
		return puntajeService.esteUsarioPuntuoEstaRuta(usuarioActivo.getId_perfil(), ruta.getId_ruta());
	}
	
	public String puntuarRuta(Ruta ruta){
		this.ruta = rutaService.recuperar(ruta.getId_ruta());
		return "usuarioPuntuarRuta.xhtml";
	}
	
	public void eliminarPuntuacionDeRuta (Ruta ruta){
		Puntaje puntaje = puntajeService.obtenerPuntaje(usuarioActivo.getId_perfil(),ruta.getId_ruta());
		puntajeService.eliminarPuntaje(puntaje);
	}
	
	public String guardarPuntuacionParaRuta(){
		Puntaje puntaje = new Puntaje();
		puntaje.setUsuario(usuarioActivo);
		puntaje.setRuta(this.ruta);
		puntaje.setPuntuacion(this.puntajeRuta);
		puntajeService.guardarPuntaje(puntaje);
		return "usuarioAdministrarRutas.xhtml";
	}
	
	public void marcarComoHecha (Ruta ruta){
		if (! puntajeService.hizoEsteUsuarioEstaRuta(usuarioActivo.getId_perfil(),ruta.getId_ruta())){
			Puntaje puntaje = new Puntaje();
			puntaje.setRuta(ruta);
			puntaje.setUsuario(usuarioActivo);
			puntajeService.guardarPuntaje(puntaje);
		}
		
	}
	
	public void marcarComoNoHecha(Ruta ruta){
		Puntaje puntaje = puntajeService.obtenerPuntajeConPuntuacionNull(usuarioActivo.getId_perfil(),ruta.getId_ruta());
		puntajeService.eliminarPuntaje(puntaje);
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

	public String alta (){
		Map<String, Coordenada> coordenadasMap = (Map<String, Coordenada>) session.get("coordenadas");
		List<Coordenada> coordenadasAsList = new ArrayList<>(coordenadasMap.values());
		for (Coordenada coor: coordenadasAsList) {
			ruta.agregarCoordenada(coor.getLat(), coor.getLon());
		}
		ruta.setUsuario(usuarioActivo);
		rutaService.guardarRuta(ruta);
		listaRutas = rutaService.recuperarTodas();
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("Se ha creado una nueva ruta");
		context.addMessage("mensaje", mensaje);
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "listadoMisRutas";
	}

	public Integer getPuntajeRuta() {
		return puntajeRuta;
	}
	
	public String altaRuta(){
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "usuarioAltaRuta.xhtml";
	}

	public void setPuntajeRuta(Integer puntajeRuta) {
		this.puntajeRuta = puntajeRuta;
	}
	
	public String verMas(Ruta ruta){
		this.setRuta(rutaService.recuperar(ruta.getId_ruta()));
		this.cantidadUsuarios = puntajeService.getCantidadUsuariosHicieronEstaRuta(ruta.getId_ruta());
		this.promedio = puntajeService.getPromedioParaEstaRuta(ruta.getId_ruta());
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "usuarioVerMasRuta.xhtml";
	}

	public Integer getCantidadUsuarios() {
		return cantidadUsuarios;
	}

	public void setCantidadUsuarios(Integer cantidadUsuarios) {
		this.cantidadUsuarios = cantidadUsuarios;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	 
	
}
