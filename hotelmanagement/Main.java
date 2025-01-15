
package com.hotelmanagement;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAO();
        InventoryDAO inventoryDAO = new InventoryDAO();

        // Add a new room
        Room newRoom = new Room(0, "Deluxe", true, 200.00);
        roomDAO.addRoom(newRoom);
        System.out.println("Room added successfully.");
        // Get a room by ID
        Room room = roomDAO.getRoomById(1); // Replace with a valid room ID
        if (room != null) {
            System.out.println("Room retrieved: Type - " + room.getRoomType() +
                    ", Price per night - $" + room.getPricePerNight());
        } else {
            System.out.println("Room with ID 1 not found.");
        }
        // Get all rooms by price range
        List<Room> rooms = inventoryDAO.getRoomsByPriceRange(100.00, 300.00);
        System.out.println("Rooms in price range .00 - .00:");
        for (Room r : rooms) {
            System.out.println("Room Type: " + r.getRoomType() + ", Price: $" + r.getPricePerNight());
        }
        // Check inventory count
        int inventoryCount = inventoryDAO.getInventoryCount();
        System.out.println("Total rooms in inventory: " + inventoryCount);
                }
            
                private static class RoomDAO {
            
                    public RoomDAO() {
                    }
            
                    public Room getRoomById(int i) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getRoomById'");
                    }
            
                    private void addRoom(Room newRoom) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
