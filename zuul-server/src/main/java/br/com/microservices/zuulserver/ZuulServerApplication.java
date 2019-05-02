package br.com.microservices.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import br.com.microservices.zuulserver.filter.AddResponseHeaderFilter;
import br.com.microservices.zuulserver.filter.LoggingRequestFilter;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
	
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Bean
	public LoggingRequestFilter loggingRequestFilter() {
		return new LoggingRequestFilter();
	}
	
	@Bean
	public AddResponseHeaderFilter addResponseHeaderFilter() {
		return new AddResponseHeaderFilter();
	}

}
