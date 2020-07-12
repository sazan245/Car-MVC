package filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Utils;

//All the incoming request
@WebFilter(filterName="blockingFilter")
public class SessionBlockerFilter implements Filter {

	private Set<String> allowedUrls=new HashSet<>();

	private  long startTime=1*60*60*1000;
	private  long endTime=23*60*60*1000;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowedUrls.add("/unavailable.jsp");
		allowedUrls.add("/signinform.jsp");
		allowedUrls.add("/auth");
		allowedUrls.add("/process.jsp");
		allowedUrls.add("/register.jsp");
		allowedUrls.add("/forgotPassword.jsp");
		allowedUrls.add("/password.jsp");
		allowedUrls.add("/unBlockTime");
		allowedUrls.add("/blockerTime");
		//Accesing  data 
		ServletContext   se= filterConfig.getServletContext();
	}

	private void updateTimeBlocker(HttpServletRequest httpServletRequest) {
		ServletContext context=httpServletRequest.getServletContext();
		Integer blockerTimeFlag=(Integer)context.getAttribute("blockerTimeFlag");
		if(blockerTimeFlag!=null && blockerTimeFlag==0) {
			startTime=(Long)context.getAttribute("startTimeInMillis");
			endTime=(Long)context.getAttribute("endTimeInMillis");}
			}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 //Reference type casting = Downcasting
		 HttpServletRequest httpServletRequest =(HttpServletRequest)request;
		 String resourceName=httpServletRequest.getServletPath();
		 System.out.println("BlockingFilter Accessing resource = "+resourceName+" at time  "+LocalDateTime.now());
					  long cTime =Utils.currentTime();
					  if(allowedUrls.contains(resourceName)) {
						  chain.doFilter(request, response);
					  }
					  else  if( cTime>startTime && cTime<endTime) {
						  chain.doFilter(request, response);
					  }else {
						   //http://localhost:9999/happy-hours
					       ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath()+"/unavailable.jsp");
					       }

	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}