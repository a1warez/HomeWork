package ru.test.homework.test.Repository;

public class Query {
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
        List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") double salary);

        @Query("SELECT e FROM Employee e WHERE e.name LIKE %:namePrefix% ORDER BY e.name")
        List<Employee> findEmployeesByNameStartingWith(@Param("namePrefix") String namePrefix);
    }

    public interface OrderRepository extends JpaRepository<Order, Long> {
        @Query("SELECT new com.example.demo.OrderDTO(o.id, o.deliveryDate) FROM Order o")
        List<OrderDTO> findAllOrderDTOs();
    }

    public interface StudentRepository extends JpaRepository<Student, Long> {
        @Query("SELECT new com.example.demo.StudentDTO(s.name, s.faculty) FROM Student s")
        List<StudentDTO> findAllStudentDTOs();
    }

    public interface SupplierRepository extends JpaRepository<Supplier, Long> {
        @Query("SELECT new com.example.demo.SupplierDTO(s.id, s.name) FROM Supplier s WHERE s.numberOfDeliveries > :minDeliveries")
        List<SupplierDTO> findSupplierDTOsWithMoreThan(@Param("minDeliveries") int minDeliveries);
    }

    public interface ProductRepository extends JpaRepository<Product, Long> {
        @Query("SELECT new com.example.demo.ProductDTO(p.name, p.price) FROM Product p WHERE p.price > :minPrice")
        List<ProductDTO> findProductDTOsWithPriceGreaterThan(@Param("minPrice") double minPrice);
    }

    public interface EventRepository extends JpaRepository<Event, Long> {
        @Query("SELECT e FROM Event e WHERE e.name = :name AND e.date = :date")
        Event findEventByNameAndDate(@Param("name") String name, @Param("date") Date date);
    }

    public interface CourseRepository extends JpaRepository<Course, Long> {
        @Query("SELECT new com.example.demo.CourseDTO(c.name, c.duration) FROM Course c WHERE c.teacher = :teacher")
        List<CourseDTO> findCourseDTOsByTeacher(@Param("teacher") String teacher);
    }

    public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        @Query("SELECT t FROM Transaction t WHERE t.amount BETWEEN :minAmount AND :maxAmount")
        List<Transaction> findTransactionsBetweenAmounts(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount);
    }

    public interface CityRepository extends JpaRepository<City, Long> {
        @Query("SELECT new com.example.demo.CityDTO(c.name, c.population) FROM City c WHERE c.population > 100000")
        List<CityDTO> findCityDTOsWithPopulationGreaterThan();
    }


    @Data
    @AllArgsConstructor
    public class OrderDTO {
        private Long id;
        private Date deliveryDate;
    }
    @Data
    @AllArgsConstructor
    public class StudentDTO {
        private String name;
        private String faculty;
    }
    @Data
    @AllArgsConstructor
    public class SupplierDTO {
        private Long id;
        private String name;
    }
    @Data
    @AllArgsConstructor
    public class ProductDTO {
        private String name;
        private double price;
    }
    @Data
    @AllArgsConstructor
    public class CourseDTO {
        private String name;
        private int duration;
    }
    @Data
    @AllArgsConstructor
    public class CityDTO {
        private String name;
        private int population;
    }

    @Service
    public class MyService {

        @Autowired
        private EmployeeRepository employeeRepository;
        @Autowired
        private OrderRepository orderRepository;
        @Autowired
        private StudentRepository studentRepository;
        @Autowired
        private SupplierRepository supplierRepository;
        @Autowired
        private ProductRepository productRepository;
        @Autowired
        private EventRepository eventRepository;
        @Autowired
        private CourseRepository courseRepository;
        @Autowired
        private TransactionRepository transactionRepository;
        @Autowired
        private CityRepository cityRepository;

        public void queryOperations() {
            List<Employee> highSalaryEmployees = employeeRepository.findEmployeesWithSalaryGreaterThan(50000);

            List<OrderDTO> orderDTOs = orderRepository.findAllOrderDTOs();

            List<StudentDTO> studentDTOs = studentRepository.findAllStudentDTOs();

            List<SupplierDTO> supplierDTOs = supplierRepository.findSupplierDTOsWithMoreThan(10);

            List<ProductDTO> productDTOs = productRepository.findProductDTOsWithPriceGreaterThan(100);

            Event event = eventRepository.findEventByNameAndDate("MyEvent", new Date());

            List<CourseDTO> courseDTOs = courseRepository.findCourseDTOsByTeacher("Mr. Smith");

            List<Transaction> transactions = transactionRepository.findTransactionsBetweenAmounts(100, 1000);

            List<CityDTO> cityDTOs = cityRepository.findCityDTOsWithPopulationGreaterThan();

            List<Employee> employeesStartingWithA = employeeRepository.findEmployeesByNameStartingWith("A");

        }
    }
}
