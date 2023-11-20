package by.iba.domain;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "order_cost")
    private double orderCost;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "book_id")
    private Long bookId;

}
