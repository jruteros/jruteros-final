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
import javax.servlet.http.HttpSession;

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
	    if (validateAdmin(httpReq)){
	    	chain.doFilter(request, response);
	    }
	    else 
	    	httpResp.sendRedirect(httpReq.getContextPath()+"/views/errorPermiso.xhtml");
	}	
	
	private boolean validateAdmin (HttpServletRequest httpReq){
		if (httpReq.getSession().getAttribute("perfil") != null){
	    	Perfil perfil = (Perfil) httpReq.getSession().getAttribute("perfil");
	    	if (perfil.getClass().getSimpleName().equals("Administrador")){
	    		return true;
	    	}else
	    		return false;
	    }else 
	    	return false;
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
