package br.com.mercadoinverso.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;  

/**
 * @author Adriano Silva
 * @since 18/09/2015
 * Configuração do spring (mesma coisa que configurar por xml)
 */

@Configuration
@ComponentScan("br.com.mercadoinverso")
@Import({ThymeleafConfig.class})
@EnableWebMvc  
public class SpringConfig extends WebMvcConfigurerAdapter {  

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}  
