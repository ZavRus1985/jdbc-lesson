package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    Long ID;
    String PRODUCT;
    int COUNT;
    BigDecimal PRICE;
    LocalDateTime DateOrder;
    int Client_ID;

    public Order(Long ID, String PRODUCT, int COUNT, BigDecimal PRICE, LocalDateTime dateOrder, int client_ID) {
        this.ID = ID;
        this.PRODUCT = PRODUCT;
        this.COUNT = COUNT;
        this.PRICE = PRICE;
        DateOrder = dateOrder;
        Client_ID = client_ID;
    }

    public Long getID() {
        return ID;
    }

    public String getPRODUCT() {
        return PRODUCT;
    }

    public int getCOUNT() {
        return COUNT;
    }

    public BigDecimal getPRICE() {
        return PRICE;
    }

    public LocalDateTime getDateOrder() {
        return DateOrder;
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    public void setCOUNT(int COUNT) {
        this.COUNT = COUNT;
    }

    public void setPRICE(BigDecimal PRICE) {
        this.PRICE = PRICE;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        DateOrder = dateOrder;
    }

    public void setClient_ID(int client_ID) {
        Client_ID = client_ID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", PRODUCT='" + PRODUCT + '\'' +
                ", COUNT=" + COUNT +
                ", PRICE=" + PRICE +
                ", DateOrder=" + DateOrder +
                ", Client_ID=" + Client_ID +
                '}';
    }
}
