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

        String sql = "CREATE TABLE IF NOT EXISTS Orders(" +
                "ID int primary key auto_increment," +
                "PRODUCT varchar(50)," +
                "COUNT int," +
                "PRICE decimal(5,2)," +
                "DateOrder datetime," +
                "Client_ID int," +
                "foreign key (Client_ID) references Clients(ID) ON DELETE CASCADE)"
                ;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate(sql);

        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }


}
