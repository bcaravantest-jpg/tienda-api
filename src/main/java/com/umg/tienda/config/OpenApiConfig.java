package com.umg.tienda.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	  public OpenAPI tiendaApi() {
	    return new OpenAPI().info(new Info()
	      .title("API Tienda - Fase 1")
	      .version("v1")
	      .description("CRUD de Categoría, Producto y Cliente con Spring Boot + H2"));
	  }
	}
