package by.iba.kafka.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
@JsonDeserialize(as = OrderDto.class)
public interface AbstractDto extends Serializable {
}
