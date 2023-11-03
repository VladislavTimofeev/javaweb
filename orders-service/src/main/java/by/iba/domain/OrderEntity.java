package by.iba.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderEntity {
    private Long id;

    private Date orderDate;
    private double orderCost;

    private Long userId;

    private Long bookId;

}
