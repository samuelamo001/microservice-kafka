package apache.microservices.apache.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentProducer studentProducer;

    @PostMapping()
    public ResponseEntity<String> sendStudentDataToProducer(@RequestBody Student student) {
        studentProducer.produceStudent(student);
        return ResponseEntity.ok("Student data queued successfully");
    }
}
