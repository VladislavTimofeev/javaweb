package by.iba.repository.mapper;

import by.iba.domain.OrderEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderRowMapper implements RowMapper<OrderEntity> {

    @Override
    public OrderEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId(resultSet.getLong("id"));
        orderEntity.setOrderDate(resultSet.getDate("order_date"));
        orderEntity.setOrderCost(resultSet.getDouble("order_cost"));
        orderEntity.setUserId(resultSet.getLong("user_id"));
        orderEntity.setBookId(resultSet.getLong("book_id"));

        return orderEntity;
    }
}
