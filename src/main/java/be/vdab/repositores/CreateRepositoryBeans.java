package be.vdab.repositores;

import java.sql.Driver;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.vdab.entities.Client;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class CreateRepositoryBeans {
	@Bean
	DataSource dataSource()  {
		try {
		Driver driver=(Driver) Class.forName(JDBCDriver.class.getName()).newInstance();
		return new SimpleDriverDataSource(driver, "jdbc:hsqldb:mem:clients", 
				"sa", "");
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(Client.class.getPackage().getName());
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		
		adapter.setShowSql(true);
		factory.setJpaVendorAdapter(adapter);
		factory.getJpaPropertyMap().put("hibernate.format_sql", true);
		factory.getJpaPropertyMap().put("hibernate.use_sql_comments", true);
		factory.getJpaPropertyMap().put(
				"javax.persistence.schema-generation.database.action", "create");		
		return factory;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}
	
	
}
