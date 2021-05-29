package shujuqianyi.configuration;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ShuJuQianYiBean {
	
	@Bean("oldDatasource")
	public DataSource getDatasource(){
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setUsername("zmk");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@//127.0.0.1:1521/XE");
		dataSource.setPassword("123456");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return dataSource;
	}
	
}
