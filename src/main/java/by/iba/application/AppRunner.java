package by.iba.application;

import by.iba.domain.UserEntity;
import by.iba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages = "by.iba")
public class AppRunner implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }


    @Override
    public void run(String... args) {
        runJDBC();
    }

    void runJDBC() {

        jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE users\n" +
                "(\n" +
                "    id SERIAL PRIMARY KEY\n" +
                "   firstName varchar(30)\n" +
                "   lastName varchar(30)\n" +
                ");");


        userRepository.save(new UserEntity(1L));

        System.out.println(userRepository.findById(1L).get().getId());

    }
}