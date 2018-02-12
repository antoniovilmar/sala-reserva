package br.com.salareserva.infra.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = RepositoryModuleConfiguration.class)
@EnableJpaRepositories(considerNestedRepositories = true)
public class RepositoryModuleConfiguration {
}
