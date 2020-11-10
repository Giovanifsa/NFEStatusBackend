package giovani.nfestatusproj.nfestatus.application;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import giovani.nfestatusproj.nfestatus.BasePackageClass;
import giovani.nfestatusproj.nfestatus.utils.ListUtils;

@EnableJpaRepositories(basePackageClasses = BasePackageClass.class)
@EntityScan(basePackageClasses = BasePackageClass.class)
@Configuration
public class JPASetup {
	private static final String ENV_MYSQL_USERNAME = "mysqlusername";
	private static final String ENV_MYSQL_PASSWORD = "mysqlpassword";
	private static final String ENV_MYSQL_URL = "mysqlurl";
	
	@Autowired
    private ApplicationArguments applicationArguments;

	@Bean
	public DataSource dataSource() {
		String username = ListUtils.first(applicationArguments.getOptionValues(ENV_MYSQL_USERNAME));
		String password = ListUtils.first(applicationArguments.getOptionValues(ENV_MYSQL_PASSWORD));
		String url = ListUtils.first(applicationArguments.getOptionValues(ENV_MYSQL_URL));
		
		validateValue(ENV_MYSQL_USERNAME, username);
		validateValue(ENV_MYSQL_PASSWORD, password);
		validateValue(ENV_MYSQL_URL, url);
		
//		dataSource.setUsername("root");
//		dataSource.setPassword("rootteste");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/StatusNFE?createDatabaseIfNotExist=true&serverTimezone=UTC");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl("jdbc:mysql://" + url);

		return dataSource;
	}
	
	private void validateValue(String arg, String value) {
		if (value == null) {
			throw new IllegalArgumentException( arg + " must be provided");
		}
	}
}
