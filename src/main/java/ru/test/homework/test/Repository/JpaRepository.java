package ru.test.homework.test.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailEndingWith(String domain);
}

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByProductionYearBetween(int startYear, int endYear);
}

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByRatingGreaterThanAndCity(double rating, String city);
}

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Transactional
    void deleteByDateBefore(LocalDate date);
}
public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findByLastNameStartingWith(String lastNamePrefix, Pageable pageable);
}

//public interface BookRepository extends JpaRepository<Book, Long> {
//    @Query("SELECT new com.example.demo.BookDTO(b.title, b.author) FROM Book b WHERE b.genre = :genre")
//    List<BookDTO> findBookDTOByGenre(@Param("genre") String genre);
//}

@Data
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String email;
}
@Data
@AllArgsConstructor
public class BookDTO {
    private String title;
    private String author;
}
@Service
public class MyService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private BookRepository bookRepository;

    public void jpaRepositoryOperations() {
        List<User> gmailUsers = userRepository.findByEmailEndingWith("@gmail.com");

        List<Vehicle> vehicles = vehicleRepository.findByProductionYearBetween(2010, 2020);

        List<Hotel> hotels = hotelRepository.findByRatingGreaterThanAndCity(4.5, "Baku");

        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream()
                .map(user -> new UserDTO(user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());

        List<BookDTO> bookDTOs = bookRepository.findBookDTOByGenre("Fantasy");

    }
}