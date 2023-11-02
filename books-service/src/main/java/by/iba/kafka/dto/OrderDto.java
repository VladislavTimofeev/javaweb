package by.iba.kafka.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto implements AbstractDto {

    private String id;
    private String status;
    private Double price;
    private Integer number;

}
