package by.iba.application;

import by.iba.domain.BookEntity;
import by.iba.domain.UserEntity;
import by.iba.repository.UserRepository;
import by.iba.repository.BookRepository;
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

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }


    @Override
    public void run(String... args) {
        runJDBC();
    }

    void runJDBC() {

        //jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE users\n" +
                "(\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "   firstName varchar(30),\n" +
                "   lastName varchar(30)\n" +
                ");");


        userRepository.save(new UserEntity(1L, "vasya", "lastName"));

        System.out.println(userRepository.findById(1L).get().getId());
        System.out.println(userRepository.findById(1L).get().getFirstName());
        System.out.println(userRepository.findById(1L).get().getLastName());

        jdbcTemplate.execute("CREATE TABLE books\n" +
                "(\n" +
                "   id SERIAL PRIMARY KEY,\n" +
                "   numberOfPages integer,\n" +
                "   title varchar(30)\n" +
                ");");

        bookRepository.save(new BookEntity(1L, 555, "About Dogs"));

        System.out.println(bookRepository.findById(1L).get().getId());
        System.out.println(bookRepository.findById(1L).get().getNumberOfPages());
        System.out.println(bookRepository.findById(1L).get().getTitle());

    }
}