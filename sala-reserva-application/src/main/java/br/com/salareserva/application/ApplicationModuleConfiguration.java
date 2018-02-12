package br.com.salareserva.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ApplicationModuleConfiguration.class)
public class ApplicationModuleConfiguration {
}
