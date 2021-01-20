package fr.eni.encheres.ihm;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */

@WebFilter(
        urlPatterns = {"/edit", ""},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    if(null == ((HttpServletRequest)request).getSession().getAttribute("login")) {
            request.getRequestDispatcher("login").forward(request, response);
//            response.sendRedirect("/ENI-Encheres/login");
        }
        else {
            chain.doFilter(request, response);
        }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
