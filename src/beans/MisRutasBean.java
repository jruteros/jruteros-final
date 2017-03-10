package beans;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import misClases.Ruta;
import misClases.Usuario;
import servicios.RutaService;

public class MisRutasBean {
	
	public RutaService rutaService = new RutaService();
	List<Ruta> misRutas;
	private Map<String,Object> session;
	private Usuario usuarioActivo;
	private Ruta ruta;
	
	public MisRutasBean (){
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		usuarioActivo = (Usuario)session.get("perfil");
		misRutas = rutaService.recuperarTodasMisRutas(usuarioActivo.getId_perfil());
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
		return "usuarioVerMasMiRuta.xhtml";
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	

}
