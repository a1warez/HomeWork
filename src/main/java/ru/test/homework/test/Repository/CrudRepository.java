package ru.test.homework.test.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.homework.test.modl.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {}
public interface OrderRepository extends CrudRepository<Order, Long> {}
public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
public interface SupplierRepository extends CrudRepository<Supplier, Long> {}
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {}
public interface StudentRepository extends CrudRepository<Student, Long> {}
public interface DepartmentRepository extends CrudRepository<Department, Long> {}
public interface ClientRepository extends CrudRepository<Client, Long> {}
public interface EventRepository extends CrudRepository<Event, Long> {}
public interface TeacherRepository extends CrudRepository<Teacher, Long> {}

@Service
public class MyService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public void crudOperations() {
        Product newProduct = new Product();
        newProduct.setName("Example Product");
        productRepository.save(newProduct);

        orderRepository.deleteById(1L);

        List<Long> employeeIds = Arrays.asList(1L, 2L, 3L);
        List<Employee> employees = (List<Employee>) employeeRepository.findAllById(employeeIds);

        boolean supplierExists = supplierRepository.existsById(7L);


        //invoiceRepository.deleteByDateBefore(LocalDate.of(2022, 1, 1));

        Optional<Student> student = studentRepository.findById(1L);
        student.ifPresent(s -> System.out.println(s.getName()));


        List<Department> departments = Arrays.asList(new Department(), new Department()); // Пример списка
        departmentRepository.saveAll(departments);


        long clientCount = clientRepository.count();


        Event eventToDelete = new Event();
        eventToDelete.setId(1L);
        eventRepository.delete(eventToDelete);

        boolean teacherExists = teacherRepository.existsById(10L);
    }
}