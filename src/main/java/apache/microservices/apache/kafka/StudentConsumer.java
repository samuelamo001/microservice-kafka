package apache.microservices.apache.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class StudentConsumer {

    private final Logger logger = LoggerFactory.getLogger(StudentConsumer.class);

    @KafkaListener(topics = "student", groupId = "student")
    public void consumeStudent(Student student) {
        logger.info("Consuming the message from student Topic:: {}", student.toString());
    }
}
