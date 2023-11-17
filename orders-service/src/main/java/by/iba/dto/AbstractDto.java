package by.iba.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
@JsonDeserialize(as = KafkaOrderDto.class)
public interface AbstractDto extends Serializable {
}
