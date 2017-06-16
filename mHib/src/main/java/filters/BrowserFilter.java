package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class BrowserFilter implements Filter {

	public BrowserFilter() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest requestHttp = (HttpServletRequest) request;
	    String userAgent = requestHttp.getHeader("User-Agent");
		System.out.println(userAgent);

		String reqURI = requestHttp.getRequestURI();
		if (reqURI.indexOf("/unsupported_browser.xhtml") < 0 && !userAgent.toLowerCase().contains("chrome")) {
			((HttpServletResponse) response).sendRedirect(requestHttp.getContextPath() + "/unsupported_browser.xhtml");
		}

		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}