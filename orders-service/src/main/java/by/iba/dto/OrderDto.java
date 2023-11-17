package by.iba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements AbstractDto {

    private Long id;

    private Date orderDate;

    private double orderCost;

    private Long userId;

    private Long bookId;

}
