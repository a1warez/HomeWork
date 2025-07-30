package ru.test.homework;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import ru.test.homework.model.Book;
import ru.test.homework.test.Repository.BookRepository;

import static org.awaitility.Awaitility.given;
import static org.hamcrest.Matchers.equalTo;
import static sun.security.util.KnownOIDs.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class BookIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private BookRepository bookRepository;

    @BeforeAll
    void beforeAll() {
        RestAssured.port = port;
        System.out.println("Starting integration tests for Book API...");
    }

    @AfterAll
    void afterAll() {
        System.out.println("Finished integration tests for Book API.");
    }

    @BeforeEach
    void setUp() {
        RestAssured.port = port; // Устанавливаем порт для RestAssured перед каждым тестом
    }

    @Test
    @Order(1)
    void createBookTest() {
        Book newBook = new Book();
        newBook.setTitle("Test Book");
        newBook.setAuthor("Test Author");
        newBook.setYear(2023);

        given()
                .untilTrue(ContentType.JSON)
                .body(newBook)
                .when()
                .post("/api/book")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("title", equalTo("Test Book"))
                .body("author", equalTo("Test Author"))
                .body("year", equalTo(2023));
    }

    @Test
    @Order(2)
    void getBookByIdTest() {
        Book newBook = new Book();
        newBook.setTitle("Get Book");
        newBook.setAuthor("Get Author");
        newBook.setYear(2024);
        Book savedBook = bookRepository.save(newBook); // Сохраняем книгу в базу через репозиторий

        given()
                .when()
                .get("/api/book/" + savedBook.getId()) // Получаем книгу по ID, который вернула база
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("title", equalTo("Get Book"))
                .body("author", equalTo("Get Author"))
                .body("year", equalTo(2024));
    }

    @Test
    @Order(3)
    void getBookByNonExistentIdTest() {
        given()
                .when()
                .get("/api/book/999") // Несуществующий ID
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @Order(4)
    void deleteBookTest() {
        Book newBook = new Book();
        newBook.setTitle("Delete Book");
        newBook.setAuthor("Delete Author");
        newBook.setYear(2025);
        Book savedBook = bookRepository.save(newBook);

        given()
                .when()
                .delete("/api/book/" + savedBook.getId())
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @Order(5)
    @Sql(statements = "DELETE FROM book") // Очищаем таблицу book перед тестом
    void getAllBooksNoContentTest() {

        given()
                .when()
                .get("/api/book")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }
}