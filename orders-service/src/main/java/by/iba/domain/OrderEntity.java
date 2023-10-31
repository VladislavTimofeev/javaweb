package by.iba.domain;

import java.util.Date;

public class OrderEntity {
    private Long id;
    private Date orderDate;
    private double orderCost;
    private String userId;

    public OrderEntity(){

    }

    public OrderEntity(Long id, Date orderDate, double orderCost, String userId) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
