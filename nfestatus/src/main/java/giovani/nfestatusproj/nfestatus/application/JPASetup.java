package giovani.nfestatusproj.nfestatus.application;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import giovani.nfestatusproj.nfestatus.BasePackageClass;

@EnableJpaRepositories(basePackageClasses = BasePackageClass.class)
@EntityScan(basePackageClasses = BasePackageClass.class)
@Configuration
public class JPASetup {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("rootteste");
		dataSource.setUrl("jdbc:mysql://localhost:3306/StatusNFE?createDatabaseIfNotExist=true&serverTimezone=UTC");

		return dataSource;
	}
}
