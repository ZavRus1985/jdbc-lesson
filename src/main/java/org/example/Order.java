package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private Long id;
    private String product;
    private int count;
    private BigDecimal price;
    private LocalDateTime dateOrder;
    private int clientId;

    public Order(Long id, String product, int count, BigDecimal price, LocalDateTime dateOrder, int client_Id) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.price = price;
        this.dateOrder = dateOrder;
        clientId = client_Id;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public int getClientId() {
        return clientId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", dateOrder=" + dateOrder +
                ", clientId=" + clientId +
                '}';
    }
}
