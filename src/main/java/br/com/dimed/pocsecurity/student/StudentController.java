package br.com.dimed.pocsecurity.student;

import br.com.dimed.pocsecurity.student.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS =
            Arrays.asList(
                    new Student(1, "Andrews"),
                    new Student(2, "Erick"),
                    new Student(3, "Rambo")
            );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst().
                        orElseThrow(() -> new IllegalArgumentException("Student" + studentId + "Not exist"));
    }

}
