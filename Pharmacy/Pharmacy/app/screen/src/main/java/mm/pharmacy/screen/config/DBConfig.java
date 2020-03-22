package mm.pharmacy.screen.config;

import org.hibernate.dialect.Database;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class DBConfig {
  @Bean
  public DataSource dataSource() throws IOException {
    new FileOutputStream("mydb", true).close();
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.sqlite.JDBC");
    dataSourceBuilder.url("jdbc:sqlite:mydb");
    return dataSourceBuilder.build();
  }

  @Bean
  public String databasePlatform() {
    return "mm.pharmacy.screen.config.SQLiteDialect";
  }

//  spring.jpa.database-platform                  = mm.pharmacy.screen.config.SQLiteDialect
}
