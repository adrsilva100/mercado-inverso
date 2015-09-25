package br.com.mercadoinverso.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.mercadoinverso.config.security.SecurityConfig;  

/**
 * @author Adriano Silva
 * @since 18/09/2015
 * Configuração do spring (mesma coisa que configurar por xml)
 */

@Configuration
@ComponentScan("br.com.mercadoinverso")
@PropertySource(value = { "classpath:application.properties" })
@Import({ThymeleafConfig.class, SecurityConfig.class})
@EnableWebMvc  
public class SpringConfig extends WebMvcConfigurerAdapter {  

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean 
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() { 
		return new PropertySourcesPlaceholderConfigurer(); 
	}

	@Bean 
	public CacheManager cacheManager() { 
		return new ConcurrentMapCacheManager(); 
	}
}  
