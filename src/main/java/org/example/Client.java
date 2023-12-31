package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {

    private Long id;
    private String name;
    private int age;
    private String city;
    private BigDecimal totalSumOrders;

    public Client(Long id, String name, int age, String city, BigDecimal totalSumOrders) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.totalSumOrders = totalSumOrders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getTotalSumOrders() {
        return totalSumOrders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTotalSumOrders(BigDecimal totalSumOrders) {
        this.totalSumOrders = totalSumOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", totalSumOrders=" + totalSumOrders +
                '}';
    }
}
