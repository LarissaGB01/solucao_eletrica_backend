package br.com.eletrica.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class ConfiguracaoBancoDeDados {

    @Value("classpath:normativas.sql")
    private Resource initializeScript;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initializeDatabase() throws SQLException {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(initializeScript);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
    }
}