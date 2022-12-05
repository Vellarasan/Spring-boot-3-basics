package io.vels.springboot3basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBoot3BasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3BasicsApplication.class, args);
    }

}

@RestController
class StudentController {
    @GetMapping("/hello")
    public ResponseEntity<Student> getDetails() {
        return ResponseEntity.ok(new Student(1, "vellarasan"));
    }
}

record Student(int i, String name) {
}
