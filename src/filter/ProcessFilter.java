package filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Please intercept all the incoming request
@WebFilter(filterName="processFilter")
public class ProcessFilter implements Filter {
	
	Set<String> allowedResources=new HashSet<>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowedResources.add("/index.jsp");
		allowedResources.add("/auth");
		allowedResources.add("/register.jsp");
		allowedResources.add("/process.jsp");
		allowedResources.add("/unavailable.jsp");
		allowedResources.add("/image");
		allowedResources.add("/photos");
		allowedResources.add("/uploadPhoto");
		allowedResources.add("/upload.jsp");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  httpServletRequest=(HttpServletRequest)request;
		String resourceName=httpServletRequest.getServletPath();
		System.out.println("ProcessFilter Hello Mr . "+resourceName+" , you are most welcome at "+LocalDateTime.now());
		if(allowedResources.contains(resourceName) || resourceName.contains("img/") || resourceName.contains("css/")) {		
			chain.doFilter(request, response);
		}else {
			HttpSession session=httpServletRequest.getSession(false);
			if(session!=null && session.getAttribute("userData")!=null) {
				chain.doFilter(request, response);
			}else {
				///movies-store/index.jsp
				//localhost:9999
				//httpServletRequest.getContextPath() = /movies-store
				((HttpServletResponse)response).sendRedirect(httpServletRequest.getContextPath()+"/"+"index.jsp");
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}
