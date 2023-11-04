package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {

    Long ID;
    String NAME;
    int AGE;
    String CITY;

    BigDecimal Total_Sum_Orders;

    public Client(Long ID, String NAME, int AGE, String CITY, BigDecimal Total_Sum_Orders) {
        this.ID = ID;
        this.NAME = NAME;
        this.AGE = AGE;
        this.CITY = CITY;
        this.Total_Sum_Orders = Total_Sum_Orders;
    }

    public Long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public String getCITY() {
        return CITY;
    }

    public BigDecimal getTotal_Sum_Orders() {
        return Total_Sum_Orders;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public void setTotal_Sum_Orders(BigDecimal total_Sum_Orders) {
        Total_Sum_Orders = total_Sum_Orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(ID, client.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", AGE=" + AGE +
                ", CITY='" + CITY + '\'' +
                ", Total_Sum_Orders=" + Total_Sum_Orders +
                '}';
    }
}
