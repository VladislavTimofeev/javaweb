package by.iba.kafka;

import by.iba.kafka.dto.AbstractDto;

public interface KafkaProducerService {

    void sendMessage(String message, String topicName);

    void sendMessage(AbstractDto message, String topicName);
}
