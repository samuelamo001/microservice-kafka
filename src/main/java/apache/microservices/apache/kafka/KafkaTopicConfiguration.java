package apache.microservices.apache.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic studentTopic(){
        return TopicBuilder
                .name("student")
                .partitions(3)
                .replicas(2)
                .config(TopicConfig.DELETE_RETENTION_MS_CONFIG, "172800000")
                .build();
    }
}
