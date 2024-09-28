package apache.microservices.apache.kafka;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void produceStudent(Student student) {
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "student")
                .build();

        kafkaTemplate.send(message);
    }
}
