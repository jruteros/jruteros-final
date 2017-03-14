package beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import misClases.Actividad;
import misClases.Dificultad;
import misClases.Formato;
import misClases.Privacidad;
import misClases.Ruta;
import misClases.Usuario;
import rest.jersey.Coordenada;
import rest.jersey.CoordenadaService;
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
	
	public void eliminarRuta (Ruta ruta){
		this.rutaService.eliminar(ruta);
		misRutas = rutaService.recuperarTodasMisRutas(usuarioActivo.getId_perfil());
	} 
	
	public String verMas(Ruta ruta){
		this.setRuta(rutaService.recuperar(ruta.getId_ruta()));
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "usuarioVerMasMiRuta.xhtml";
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
		return "usuarioEditarMiRuta.xhtml";
	}
	
	public String guardarEdicion(){
		Map<String, Coordenada> coordenadasMap = (Map<String, Coordenada>) session.get("coordenadas");
		List<Coordenada> coordenadasAsList = new ArrayList<>(coordenadasMap.values());
		for (Coordenada coor: coordenadasAsList) {
			ruta.agregarCoordenada(coor.getLat(), coor.getLon());
		}
		coordenadaBeanService.eliminarCoordenadasParaEstaRuta(this.ruta.getId_ruta());
		this.ruta.setUsuario(usuarioActivo);
		rutaService.actualizar(ruta);
		misRutas = rutaService.recuperarTodas();
		this.session.put("coordenadas", new LinkedHashMap<String,Coordenada>());
		return "usuarioAdministrarMisRutas.xhtml";
	}
}
