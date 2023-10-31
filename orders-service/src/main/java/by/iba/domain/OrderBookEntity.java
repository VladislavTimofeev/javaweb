package by.iba.domain;

public class OrderBookEntity {
    private String orderId;
    private String bookId;
    private double orderPrice;

    public OrderBookEntity(){

    }
    public OrderBookEntity(String orderId, String bookId, double orderPrice) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.orderPrice = orderPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
