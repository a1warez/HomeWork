package ru.test.homework.test.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

//public interface BookRepository extends PagingAndSortingRepository<Book, Long> {}
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {}
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {}

@Service
public class MyService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;

    public void pagingAndSortingOperations() {
        Page<Book> firstTenBooks = bookRepository.findAll(PageRequest.of(0, 10, Sort.by("title")));

        Page<Article> secondPageArticles = articleRepository.findAll(PageRequest.of(1, 5, Sort.by("publicationDate")));

        Page<Order> firstPageOrders = orderRepository.findAll(PageRequest.of(0, 20, Sort.by("totalAmount")));

        List<Product> sortedProducts = (List<Product>) productRepository.findAll(Sort.by("price", "name"));

        //Page<Client> clientsWithA = clientRepository.findByLastNameStartingWith("A", PageRequest.of(0, 10));

    }
}