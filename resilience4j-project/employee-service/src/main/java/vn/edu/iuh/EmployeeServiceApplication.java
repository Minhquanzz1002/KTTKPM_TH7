package vn.edu.iuh;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import vn.edu.iuh.models.Employee;
import vn.edu.iuh.repositories.EmployeeRepository;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

//    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return args -> {
            for (int i = 1; i <= 1000; i++) {
                Employee employee = Employee.builder()
                        .firstName("Nhân")
                        .lastName("Viên " + i)
                        .age(30)
                        .gender(true)
                        .build();
                repository.save(employee);
            }
        };
    }
}
