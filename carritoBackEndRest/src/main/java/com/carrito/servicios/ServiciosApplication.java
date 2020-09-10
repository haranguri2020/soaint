package com.carrito.servicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.carrito.servicios.util.Globales;

@SpringBootApplication
@EnableConfigurationProperties(Globales.class)
public class ServiciosApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosApplication.class, args);
	}

}
