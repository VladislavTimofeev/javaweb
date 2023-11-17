package by.iba.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {

    private Long id;

    private Date orderDate;

    private double orderCost;

    private Long userId;

    private Long bookId;

}
