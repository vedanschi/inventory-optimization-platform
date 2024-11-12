package com.inventory.dao;

import com.inventory.config.DatabaseConfig;
import com.inventory.model.Warehouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDAO {

    // Method to retrieve all warehouses from the database
    public List<Warehouse> getAllWarehouses() throws ClassNotFoundException {
        List<Warehouse> warehouses = new ArrayList<>();
        String sql = "SELECT * FROM warehouse";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setWarehouseId(resultSet.getInt("warehouse_id"));
                warehouse.setName(resultSet.getString("name"));
                warehouses.add(warehouse);
            }

        } catch (SQLException e) {
        }
        return warehouses;
    }

    // Method to retrieve a warehouse by its ID
    public Warehouse getWarehouseById(int warehouseId) throws ClassNotFoundException {
        Warehouse warehouse = null;
        String sql = "SELECT * FROM warehouse WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouseId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                warehouse = new Warehouse();
                warehouse.setWarehouseId(resultSet.getInt("warehouse_id"));
                warehouse.setName(resultSet.getString("name"));
            }

        } catch (SQLException e) {
        }
        return warehouse;
    }

    // Method to add a new warehouse to the database
    public void addWarehouse(Warehouse warehouse) throws ClassNotFoundException {
        String sql = "INSERT INTO warehouse (name) VALUES (?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, warehouse.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    // Method to update an existing warehouse's information in the database
    public void updateWarehouse(Warehouse warehouse) throws ClassNotFoundException {
        String sql = "UPDATE warehouse SET name = ? WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, warehouse.getName());
            statement.setInt(2, warehouse.getWarehouseId());
            statement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    // Method to delete a warehouse by its ID
    public void deleteWarehouse(int warehouseId) throws ClassNotFoundException {
        String sql = "DELETE FROM warehouse WHERE warehouse_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, warehouseId);
            statement.executeUpdate();

        } catch (SQLException e) {
        }
    }
}
