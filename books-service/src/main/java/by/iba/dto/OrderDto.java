package by.iba.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto implements AbstractDto {

    private Long userId;
    private Long bookId;

}
