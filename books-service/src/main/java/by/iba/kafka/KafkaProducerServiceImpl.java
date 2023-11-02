package by.iba.kafka;

import by.iba.kafka.dto.AbstractDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, AbstractDto> objectKafkaTemplate;

    @Override
    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

    @Override
    public void sendMessage(AbstractDto message, String topicName) {
        objectKafkaTemplate.send(topicName, message);
    }
}
