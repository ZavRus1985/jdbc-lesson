package org.example;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

//5. Описать следующие методы для работы с БД:
//получение всех клиентов, вставка нового клиента, обновление данных клиента, удаление клиента.
public class ClientRepository {

    private final Connection connection;

    public ClientRepository() {
        connection = JdbcConnection.CONNECTION;
    }

    public void createTableClient() {

//        String sql = "create table if not exists clients(" +
//                "id int primary key auto_increment," +
//                "name varchar(50)," +
//                "age int," +
//                "city varchar(50))";

//        String sql = SqlFileReader.sqlQuerry();

        String sql = "alter table clients \n" +
                     "add column total_Sum_Orders DECIMAL(5,2) DEFAULT 0.00;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate(sql);

        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

    public List<Client> findAllClients() {

        String sql = "select * from clients";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String city = resultSet.getString("city");
                BigDecimal total_Sum_Orders = resultSet.getBigDecimal("total_Sum_Orders");

                Client person = new Client(id, name, age, city, total_Sum_Orders);
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
            statement.setString(2, person.getName());
            statement.setInt(3, person.getAge());
            statement.setString(4, person.getCity());
            statement.setBigDecimal(5, person.getTotalSumOrders());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

    public boolean updatePerson(long personId, Client person) {


        String sql = "update clients set name = ?, age = ?, city = ?, total_Sum_Orders = ? where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getCity());
            statement.setBigDecimal(4, person.getTotalSumOrders());
            statement.setLong(5, personId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex ) {

            throw  new RuntimeException(ex);
        }
    }

    public boolean deletePerson(long personId) {


        String sql = "delete from clients where id = ?";

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
//        String sql = "select * from clients c\n" +
//                "inner join orders o\n" +
//                "on o.client_id = c.id;";
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
//                String name = resultSet.getString("name");
//                Integer age = resultSet.getInt("age");
//                String city = resultSet.getString("city");
//
//                Client person = new Client(id, name, age, city);
//
//                Long id1 = resultSet.getLong("id");
//                String product = resultSet.getString("product");
//                Integer count = resultSet.getInt("count");
//                BigDecimal price = resultSet.getBigDecimal("price");
//                LocalDateTime dateOrder = resultSet.getTimestamp("dateOrder").toLocalDateTime();
//                Integer id2 = resultSet.getInt("client_id");
//
//                Order order = new Order(id1, product, count, price, dateOrder, id2);
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
