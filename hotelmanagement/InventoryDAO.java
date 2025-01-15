package com.hotelmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagment.DBConnection;

public class InventoryDAO {

    // Method to retrieve rooms within a specified price range
    public List<Room> getRoomsByPriceRange(double minPrice, double maxPrice) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE pricePerNight BETWEEN ? AND ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, minPrice); // Set minimum price
            statement.setDouble(2, maxPrice); // Set maximum price

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("roomId"),
                        resultSet.getString("roomType"),
                        resultSet.getBoolean("isAvailable"),
                        resultSet.getDouble("pricePerNight")
                );
                rooms.add(room); // Add room to the list
            }
        }
        return rooms; // Return list of rooms
    }

    // Method to count the total number of rooms in the inventory
    public int getInventoryCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM rooms";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("total"); // Return the total count
            }
        }
        return 0; // Default to 0 if no rooms found
    }

    // Method to count available rooms in the inventory
    public int getAvailableRoomCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS availableRooms FROM rooms WHERE isAvailable = TRUE";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("availableRooms"); // Return count of available rooms
            }
        }
        return 0; // Default to 0 if no available rooms
    }
}
