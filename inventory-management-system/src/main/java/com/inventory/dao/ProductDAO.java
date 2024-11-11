package com.inventory.dao;

import com.inventory.config.DatabaseConfig;
import com.inventory.model.Product;
import com.inventory.util.HashUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Method to add a product with hashing
    public void addProduct(Product product) {
        String sql = "INSERT INTO Product (product_name, warehouse_id, type, quantity, product_hash) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Generate hash based on product details
            String productHash = HashUtil.generateHash(product.getProductName() + product.getType() + product.getWarehouseId() + product.getQuantity());

            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getWarehouseId());
            statement.setString(3, product.getType());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, productHash); // Store the generated hash
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all products with their hash
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, product_name, warehouse_id, type, quantity, product_hash FROM Product";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setWarehouseId(resultSet.getInt("warehouse_id"));
                product.setType(resultSet.getString("type"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setProductHash(resultSet.getString("product_hash")); // Retrieve the stored hash

                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
