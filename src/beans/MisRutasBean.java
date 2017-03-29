package beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import misClases.Actividad;
import misClases.Dificultad;
import misClases.Formato;
import misClases.Privacidad;
import misClases.Ruta;
import misClases.Usuario;
import rest.jersey.Coordenada;
import servicios.CoordenadaBeanService;
import servicios.RutaService;

public class MisRutasBean {
	
	public RutaService rutaService = new RutaService();
	List<Ruta> misRutas;
	private Map<String,Object> session;
	private Usuario usuarioActivo;
	private Ruta ruta;
	CoordenadaBeanService coordenadaBeanService;
	
	public MisRutasBean (){
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		usuarioActivo = (Usuario)session.get("perfil");
		misRutas = rutaService.recuperarTodasMisRutas(usuarioActivo.getId_perfil());
		this.ruta = new Ruta();
		ruta.setDistancia(Float.valueOf(0));
		ruta.setPrivacidad(new Privacidad());
		ruta.setDificultad(new Dificultad());
		ruta.setFormato(new Formato());
		ruta.setActividad(new Actividad());
		coordenadaBeanService = new CoordenadaBeanService();
	}

	public List<Ruta> getMisRutas() {
		return misRutas;
	}

	public void setMisRutas(List<Ruta> misRutas) {
		this.misRutas = misRutas;
	}
	
	public String eliminarRuta (Ruta ruta){
		this.rutaService.eliminar(ruta);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("La ruta ha sido eliminada");
		context.addMessage("mensaje", mensaje);
		misRutas = rutaService.recuperarTodasMisRutas(usuarioActivo.getId_perfil());
		return "listadoMisRutas";
	} 
	
	public String verMas(Ruta ruta){
		this.setRuta(rutaService.recuperar(ruta.getId_ruta()));
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "verMas";
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	public String editarRuta(Ruta ruta){
		this.setRuta(rutaService.recuperar(ruta.getId_ruta()));
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "editarMiRuta";
	}
	
	public String guardarEdicion(){
		Map<String, Coordenada> coordenadasMap = (Map<String, Coordenada>) session.get("coordenadas");
		List<Coordenada> coordenadasAsList = new ArrayList<>(coordenadasMap.values());
		for (Coordenada coor: coordenadasAsList) {
			ruta.agregarCoordenada(coor.getLat(), coor.getLon());
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensaje = new FacesMessage("La ruta ha sido modificada con éxito");
		context.addMessage("mensaje", mensaje);
		coordenadaBeanService.eliminarCoordenadasParaEstaRuta(this.ruta.getId_ruta());
		this.ruta.setUsuario(usuarioActivo);
		rutaService.actualizar(ruta);
		misRutas = rutaService.recuperarTodas();
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "listadoMisRutas";
	}
}
