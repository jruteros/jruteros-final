package servicios;

import java.util.Map;

import javax.faces.context.FacesContext;

public class LogoutService {

	public LogoutService() {
		
	}
	
	public void logout() {
		Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.clear();
	}
}
