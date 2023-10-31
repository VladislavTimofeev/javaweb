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
        orderEntity.setOrderDate(resultSet.getDate("orderDate"));
        orderEntity.setOrderCost(resultSet.getDouble("orderCost"));
        orderEntity.setUserId(resultSet.getString("userId"));

        return orderEntity;
    }
}
