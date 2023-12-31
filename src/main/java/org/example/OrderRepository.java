package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderRepository {

    private final Connection connection;

    public OrderRepository() {
        connection = JdbcConnection.CONNECTION;
    }

    public void createTableOrder() {

//Столбцы: id, продукт, количество, стоимость за шт., дата-время заказа, client_id

        String sql = "create table if not exists orders(" +
                "id int primary key auto_increment," +
                "product varchar(50)," +
                "count int," +
                "price decimal(5,2)," +
                "dateOrder datetime," +
                "client_id int," +
                "foreign key (client_id) references clients(id) on delete cascade)"
                ;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate(sql);

        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }


}
