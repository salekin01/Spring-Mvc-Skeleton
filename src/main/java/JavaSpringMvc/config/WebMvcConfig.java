package JavaSpringMvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import JavaSpringMvc.dao.StudentDao;
import JavaSpringMvc.dao.StudentDaoImpl;


@Configuration
@EnableWebMvc
@ComponentScan("JavaSpringMvc")
public class WebMvcConfig {
	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		/* ds.setUrl("jdbc:mysql://localhost:3306/sys"); */
		ds.setUrl("jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("sa1234");

		return ds;
	}

	@Bean
	public StudentDao getUserDao() {
		return new StudentDaoImpl(getDataSource());
	}
}
