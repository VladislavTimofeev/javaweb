package by.iba.application;

import by.iba.repository.AuthorRepository;
import by.iba.repository.BookRepository;
import by.iba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication(scanBasePackages = "by.iba")
public class BooksAppRunner implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(BooksAppRunner.class, args);
    }


    @Override
    public void run(String... args) {
        runJDBC();
    }

    void runJDBC() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/dlib", "postgres", "testing321");

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    //jdbcTemplate.execute("DROP TABLE books IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE users " +
//                "( " +
//                "    id SERIAL PRIMARY KEY, " +
//                "   firstName varchar(30), " +
//                "   lastName varchar(30) " +
//                ");");
//        jdbcTemplate.execute("CREATE TABLE books " +
//                "( " +
//                "   id SERIAL PRIMARY KEY, " +
//                "   numberOfPages integer, " +
//                "   title varchar(30) " +
//                ");");
//        jdbcTemplate.execute("CREATE TABLE authors " +
//                "( " +
//                "   id SERIAL PRIMARY KEY, " +
//                "   firstName varchar(30), " +
//                "   lastName varchar(30) " +
//                ");");
//        jdbcTemplate.execute("CREATE TABLE books_authors " +
//                "( " +
//                "   id SERIAL PRIMARY KEY, " +
//                "   book_id integer, " +
//                "   author_id integer " +
//                ");");
//        userRepository.save(new UserEntity(1L, "vasya", "lastName"));
//
//        System.out.println(userRepository.findById(1L).get().getId());
//        System.out.println(userRepository.findById(1L).get().getFirstName());
//        System.out.println(userRepository.findById(1L).get().getLastName());
//
//
//        bookRepository.save(new BookEntity(1L, 555, "About Dogs"));
//
//        System.out.println(bookRepository.findById(1L).get().getId());
//        System.out.println(bookRepository.findById(1L).get().getNumberOfPages());
//        System.out.println(bookRepository.findById(1L).get().getTitle());


}
