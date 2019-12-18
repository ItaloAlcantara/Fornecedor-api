package com.alura.webservices.fornecedor.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    @Profile({"dev", "prod"})
    public Flyway flyway(DataSource dataSource) {
        FluentConfiguration configuration = new FluentConfiguration();
        configuration.dataSource(dataSource);
        configuration.locations("classpath:db");
        Flyway flyway = new Flyway(configuration);
        flyway.migrate();
        return flyway;
    }

    @Bean
    @Profile("test")
    public Flyway flywayTest(DataSource dataSource) {
        FluentConfiguration configuration = new FluentConfiguration();
        configuration.dataSource(dataSource);
        configuration.locations("classpath:db/migration");
        Flyway flyway = new Flyway(configuration);
        flyway.clean();
        flyway.migrate();
        return flyway;
    }

    @Bean
    @Profile("test")
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }

}
