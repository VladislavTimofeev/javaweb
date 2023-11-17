package by.iba.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class KafkaOrderDto implements AbstractDto {

    private Long userId;
    private Long bookId;
    private double bookPrice;

}
