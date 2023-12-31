package by.iba.repository;

import by.iba.domain.OrderEntity;
import by.iba.repository.mapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private static final String INSERT_INTO_ORDERS = "insert into orders (order_date, order_cost, user_id, book_id) values(?,?,?,?)";
    private static final String SELECT_ALL_ORDERS = "select * from orders";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(OrderEntity orderEntity) {
        return jdbcTemplate.update(
                INSERT_INTO_ORDERS,
                LocalDate.now(), orderEntity.getOrderCost(), orderEntity.getUserId(), orderEntity.getBookId()
        );
    }

    @Override
    public List<OrderEntity> findAll() {
        return jdbcTemplate.query(
                SELECT_ALL_ORDERS,
                new OrderRowMapper()
        );
    }
}
