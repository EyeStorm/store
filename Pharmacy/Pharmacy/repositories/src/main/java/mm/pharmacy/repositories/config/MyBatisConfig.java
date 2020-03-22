package mm.pharmacy.repositories.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*@Configuration
@MapperScan("mm.pharmacy.repositories.orm.mybatis")
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class })*/

/*@Configuration
@EnableAutoConfiguration
@MapperScan("mm.pharmacy.repositories.orm.mybatis")
@ComponentScan(basePackages = { "mm.pharmacy.repositories" }, excludeFilters = {
  @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { MyBatisConfig.class })
})*/
public class MyBatisConfig {
}
