package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSeviceImpl implements ProductSevice{
    protected Connection getConnection() {
        Connection connection=null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demoweb?useSSL=false", "root","bich2001");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void add(Object o) throws SQLException {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");)   {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id= rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");

                products.add(new Product(id,name,price,quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public boolean update(Object o) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List findByName(String name) {
        return null;
    }

    @Override
    public List findAllOrderByAge() {
        return null;
    }
}
