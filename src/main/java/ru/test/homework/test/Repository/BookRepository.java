package ru.test.homework.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.homework.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}