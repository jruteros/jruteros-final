package rest.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import misClases.Perfil;
import misClases.Usuario;

@Path("rutas/")
public class CoordenadasResource {
	
	@Context
	UriInfo urlinfo;
	
	@Context
	Request request;
	
	@Inject 
    HttpServletRequest httpRequest;
	
	List<Coordenada> coordenadas;
	CoordenadaService coordenadaService;
	
	public CoordenadasResource(@Context HttpServletRequest httpRequest){
		coordenadaService = new CoordenadaService();
		coordenadas = (List<Coordenada>)httpRequest.getSession().getAttribute("coordenadas");
		if (this.coordenadas == null){
			this.coordenadas = new ArrayList<>();
		}
		
	}
	
	@GET
	@Path("coordenadas/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coordenada> getCoordenadasAsHtml() {
		//return coordenadaService.getCoordenadasList();
		return coordenadas;
	}
	
	@GET
	@Path("coordenadas/primerCoordenada")
	@Produces(MediaType.APPLICATION_JSON)
	public Coordenada obtenerPrimerCoordenada() {
		if (!(coordenadaService.getCoordenadasList().isEmpty())){
			return coordenadaService.getCoordenadasList().get(0);
		}
		else{
			Coordenada coordenada = new Coordenada(-34.9038055,-57.9392111);
			return coordenada;
		}
	}
	
	@POST
	@Path("coordenadas/")
	public void agregarCoordenada(@QueryParam("lat") Double lat,
            @QueryParam("lon") Double lon ){
		Coordenada coordenada = new Coordenada(lat,lon);
		this.coordenadas.add(coordenada);
		httpRequest.getSession().setAttribute("coordenadas", this.coordenadas);
	}
	
	@DELETE
	@Path("coordenadas/eliminarTodo")
	@Produces(MediaType.APPLICATION_JSON)
	public Coordenada eliminarTodo(){
		Coordenada coordenada = this.coordenadas.get(this.coordenadas.size() - 1);
		httpRequest.getSession().setAttribute("coordenadas", new ArrayList<Coordenada>());
		return coordenada;
	}

	@DELETE
	@Path("coordenadas/")
	@Produces(MediaType.APPLICATION_JSON) //Devuelve la ultima coordenada para que el mapa quede centrado y no se vaya a otro lado
	public Coordenada eliminarCoordenada(@QueryParam("id_coordenada") String id_coordenada){
		coordenadaService.eliminarCoordenada(id_coordenada);
		return coordenadaService.getCoordenadasList().get(coordenadaService.getCoordenadasList().size()-1);
	}
}
