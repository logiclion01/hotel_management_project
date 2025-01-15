package com.hotelmanagement;

import com.hotelmanagment.DBConnection;
import java.sql.*;

public class RoomDao {

    // Method to add a new room to the inventory
    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (roomType, isAvailable, pricePerNight) VALUES (?, ?, ?)"; // SQL query to insert new room
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, room.getRoomType()); // Set room type
            statement.setBoolean(2, room.isAvailable()); // Set room availability
            statement.setDouble(3, room.getPricePerNight()); // Set room price per night
            statement.executeUpdate(); // Execute the insert operation
        }
    }

    // Method to retrieve a room by ID
    public Room getRoomById(int roomId) throws SQLException {
        Room room = null;
        String sql = "SELECT * FROM rooms WHERE roomId = ?"; // SQL query to get room by ID
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomId); // Set room ID
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Create a Room object from the result set
                room = new Room(
                    resultSet.getInt("roomId"),
                    resultSet.getString("roomType"),
                    resultSet.getBoolean("isAvailable"),
                    resultSet.getDouble("pricePerNight")
                );
            }
        }
        return room; // Return the room object
    }

    // Method to update room details
    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE rooms SET roomType = ?, isAvailable = ?, pricePerNight = ? WHERE roomId = ?"; // SQL query to update room
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, room.getRoomType()); // Set updated room type
            statement.setBoolean(2, room.isAvailable()); // Set updated availability
            statement.setDouble(3, room.getPricePerNight()); // Set updated price per night
            statement.setInt(4, room.getRoomId()); // Set room ID for the update
            statement.executeUpdate(); // Execute the update operation
        }
    }

    // Method to delete a room from the inventory
    public void deleteRoom(int roomId) throws SQLException {
        String sql = "DELETE FROM rooms WHERE roomId = ?"; // SQL query to delete room by ID
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roomId); // Set room ID for deletion
            statement.executeUpdate(); // Execute the delete operation
        }
    }
}
