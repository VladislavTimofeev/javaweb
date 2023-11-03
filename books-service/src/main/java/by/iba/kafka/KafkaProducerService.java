package by.iba.kafka;

import by.iba.dto.AbstractDto;

public interface KafkaProducerService {
    void sendMessage(AbstractDto message, String topicName);
}
