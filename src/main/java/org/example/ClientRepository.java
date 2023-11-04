package org.example;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

//5. Описать следующие методы для работы с БД:
//получение всех клиентов, вставка нового клиента, обновление данных клиента, удаление клиента.
public class ClientRepository {

    private final Connection connection;

    public ClientRepository() {
        connection = JdbcConnection.CONNECTION;
    }

    public void createTableClient() {


//        String sql = "CREATE TABLE IF NOT EXISTS Clients(" +
//                "ID int primary key auto_increment," +
//                "NAME varchar(50)," +
//                "AGE int," +
//                "CITY varchar(50))";

//        String sql = SqlFileReader.sqlQuerry();

        String sql = "ALTER TABLE Clients \n" +
                     "ADD COLUMN Total_Sum_Orders DECIMAL(5,2) DEFAULT 0.00;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate(sql);

        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

    public List<Client> findAllClients() {

        String sql = "select * from Clients";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                String NAME = resultSet.getString("NAME");
                Integer AGE = resultSet.getInt("AGE");
                String CITY = resultSet.getString("CITY");
                BigDecimal Total_Sum_Orders = resultSet.getBigDecimal("Total_Sum_Orders");

                Client person = new Client(id, NAME, AGE, CITY, Total_Sum_Orders);
                clients.add(person);
            }
            return clients;
        }
        catch (Exception ex ) {
            ex.printStackTrace();
            return List.of();
        }
    }

    public boolean savePerson(Client person) {


        String sql = "insert into Clients values (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setNull(1, Types.NULL);
            statement.setString(2, person.getNAME());
            statement.setInt(3, person.getAGE());
            statement.setString(4, person.getCITY());
            statement.setBigDecimal(5, person.getTotal_Sum_Orders());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

    public boolean updatePerson(long personId, Client person) {


        String sql = "update Clients set NAME = ?, AGE = ?, CITY = ?, Total_Sum_Orders = ? where ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, person.getNAME());
            statement.setInt(2, person.getAGE());
            statement.setString(3, person.getCITY());
            statement.setBigDecimal(4, person.getTotal_Sum_Orders());
            statement.setLong(5, personId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

    public boolean deletePerson(long personId) {


        String sql = "delete from Clients where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, personId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

//    public Map<Client, List<Order>> findAllClients_map() {
//
//        String sql = "select * from Clients c\n" +
//                "inner join Orders o\n" +
//                "on o.Client_ID = c.ID;";
//
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            Map<Client,List<Order>> clients = new LinkedHashMap<>();
//
//            while (resultSet.next()) {
//
//
//                Long id = resultSet.getLong("ID");
//                String NAME = resultSet.getString("NAME");
//                Integer AGE = resultSet.getInt("AGE");
//                String CITY = resultSet.getString("CITY");
//
//                Client person = new Client(id, NAME, AGE, CITY);
//
//                Long id1 = resultSet.getLong("ID");
//                String PRODUCT = resultSet.getString("PRODUCT");
//                Integer COUNT = resultSet.getInt("COUNT");
//                BigDecimal PRICE = resultSet.getBigDecimal("PRICE");
//                LocalDateTime DateOrder = resultSet.getTimestamp("DateOrder").toLocalDateTime();
//                Integer id2 = resultSet.getInt("Client_ID");
//
//                Order order = new Order(id1, PRODUCT, COUNT, PRICE, DateOrder, id2);
//
//                clients.merge(person, new ArrayList<Order>(List.of(order)), (a,b) ->  {
//                    List <Order> orders = new ArrayList<>(a);
//                    orders.add(b.get(0));
//                    return orders;
//                });
//            }
//            return clients;
//        }
//        catch (Exception ex ) {
//            ex.printStackTrace();
//            return Map.of();
//        }
//    }
}
