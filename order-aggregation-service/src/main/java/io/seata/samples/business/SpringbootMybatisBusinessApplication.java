package io.seata.samples.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "io.seata.samples.business.remote")
@SpringBootApplication(scanBasePackages = "io.seata.samples", exclude = DataSourceAutoConfiguration.class)
public class SpringbootMybatisBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisBusinessApplication.class, args);
	}

}
