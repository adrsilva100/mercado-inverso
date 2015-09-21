package br.com.mercadoinverso.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;  

/**
 * @author Adriano Silva
 * @since 18/09/2015
 * Configuração para startup da aplicação (mesma coisa que o configurar pelo web.xml)
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {        
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
		ctx.register(SpringConfig.class);  
		ctx.setServletContext(servletContext);    
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
		servlet.addMapping("/");  
		servlet.setLoadOnStartup(1);
	}
}
