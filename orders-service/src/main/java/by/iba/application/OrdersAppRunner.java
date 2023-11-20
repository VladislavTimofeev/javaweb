package by.iba.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "by.iba")
@EnableJpaRepositories("by.iba.repository")
@EntityScan("by.iba.domain")
public class OrdersAppRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrdersAppRunner.class, args);
    }

}
