package io.vels.springboot3basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBoot3BasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3BasicsApplication.class, args);
    }

}

@RestController
class StudentController {
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getDetails(@PathVariable String id) {
        if (id.equals("empty")) {
            throw new IllegalArgumentException("Input is invalid");
        }
        return ResponseEntity.ok(new Student(1, id));
    }
}

@ControllerAdvice
class StudentControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail onException(IllegalArgumentException iae) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), iae.getMessage());
    }
}

record Student(int i, String name) {
}
