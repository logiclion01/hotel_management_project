package com.hotelmanagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


 package com.hotelmanagement;

 public class Room {
 
     private int roomId;         // Unique identifier for the room
     private String roomType;    // Type of the room (e.g., Single, Double, Suite)
     private boolean isAvailable; // Availability status of the room
     private double pricePerNight; // Price per night for the room
 
     // Constructor
     public Room(int roomId, String roomType, boolean isAvailable, double pricePerNight) {
         this.roomId = roomId;
         this.roomType = roomType;
         this.isAvailable = isAvailable;
         this.pricePerNight = pricePerNight;
     }
 
     // Getter and Setter for Room ID
     public int getRoomId() {
         return roomId;
     }
 
     public void setRoomId(int roomId) {
         this.roomId = roomId;
     }
 
     // Getter and Setter for Room Type
     public String getRoomType() {
         return roomType;
     }
 
     public void setRoomType(String roomType) {
         this.roomType = roomType;
     }
 
     // Getter and Setter for Availability
     public boolean isAvailable() {
         return isAvailable;
     }
 
     public void setAvailable(boolean isAvailable) {
         this.isAvailable = isAvailable;
     }
 
     // Getter and Setter for Price Per Night
     public double getPricePerNight() {
         return pricePerNight;
     }
 
     public void setPricePerNight(double pricePerNight) {
         this.pricePerNight = pricePerNight;
     }
 
     // Method to display room details
     @Override
     public String toString() {
         return "Room{" +
                 "roomId=" + roomId +
                 ", roomType='" + roomType + '\'' +
                 ", isAvailable=" + isAvailable +
                 ", pricePerNight=" + pricePerNight +
                 '}';
     }
 }
 
