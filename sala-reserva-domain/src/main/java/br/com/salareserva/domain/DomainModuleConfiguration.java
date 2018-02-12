package br.com.salareserva.domain;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Configuration
@ComponentScan(basePackageClasses = DomainModuleConfiguration.class)
@EntityScan(basePackageClasses = {DomainModuleConfiguration.class,  Jsr310JpaConverters.class})
public class DomainModuleConfiguration {
}
