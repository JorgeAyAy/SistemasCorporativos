package br.com.cadei.filtro;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
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

import org.hibernate.SessionFactory;

import br.com.cadei.dao.HibernateUtil;

/**
 * Servlet Filter implementation class FiltroHibernate
 */
@WebFilter("/*")
public class FiltroHibernate implements Filter {

	private SessionFactory sf;

	/**
	 * Default constructor.
	 */
	public FiltroHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		try {

			if (sf.getCurrentSession().isOpen()) {
				sf.getCurrentSession().close();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			System.out.println("Iniciando Transacao");
			sf.getCurrentSession().beginTransaction();
			
			HttpServletRequest requests = (HttpServletRequest) request;
	        HttpServletResponse responses = (HttpServletResponse) response;
	        HttpSession ses = requests.getSession(false);
			responses.setHeader("Cache-Control", "no-cache"); // Prevents HTTP 1.1 caching.
			responses.setHeader("Pragma", "no-cache"); // Prevents HTTP 1.0 caching.
			responses.setDateHeader("Expires", -1); // Prevents proxy caching.
			
			if (!requests.getRequestURI().startsWith(requests.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources (CSS/JS/Images/etc)
	            responses.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	            responses.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	            responses.setDateHeader("Expires", 0); // Proxies.
	        }
			
			 String reqURI = requests.getRequestURI();
	            if (reqURI.indexOf("/login.xhtml") >= 0
	                    || (ses != null && ses.getAttribute("nome") != null)
	                    || reqURI.indexOf("/public/") >= 0 
	                    || reqURI.indexOf("/cadastroProfessor.xhtml") >= 0
	                    || reqURI.contains("javax.faces.resource")){
	                chain.doFilter(request, response);
	            }else{
	            	responses.sendRedirect(requests.getContextPath() + "/login.xhtml");
	            }
			
//			chain.doFilter(request, response);
			System.out.println("Comitando Transacao");
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (Throwable e) {
			
			e.printStackTrace();
			try {
				
				if(sf.getCurrentSession().getTransaction().isActive()){
					sf.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable e2) {


			}
		}
		
		
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Iniciando configura??o de SessionFactory");
		sf = HibernateUtil.getSessionFactory();

		if (sf.getCurrentSession().isOpen()) {
			System.out.println("Session aberta");
		}

	}

}
