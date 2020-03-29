package mm.pharmacy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class DBInitializeConfig {

  @Autowired
  private DataSource dataSource;

  @PostConstruct
  public void initialize() {
  }
}
