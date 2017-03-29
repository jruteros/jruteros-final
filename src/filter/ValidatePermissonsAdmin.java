package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misClases.Perfil;

public class ValidatePermissonsAdmin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
	    HttpServletResponse httpResp = (HttpServletResponse) response;
	    //System.out.println("Interepto Admin");
	    if (isAuthenticatedUser(httpReq)){
		    if (isAdmin(httpReq)){
		    	chain.doFilter(request, response);
		    }else 
		    	httpResp.sendRedirect(httpReq.getContextPath()+"/views/errorPermiso.xhtml");
	    }else {
	    	httpResp.sendRedirect(httpReq.getContextPath()+"/errorAutenticacion.xhtml");
	    }
	}	
	
	private boolean isAuthenticatedUser(HttpServletRequest httpReq) {
		return httpReq.getSession().getAttribute("perfil") != null;
	}

	private boolean isAdmin (HttpServletRequest httpReq){
    	Perfil perfil = (Perfil) httpReq.getSession().getAttribute("perfil");
    	if (perfil.getClass().getSimpleName().equals("Administrador")){
    		return true;
    	}
    	return false;
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
