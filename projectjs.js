const prompt = require('prompt-sync')({ sigint: true });

// Array to store hotel rooms
const rooms = Array.from({ length: 10 }, (_, i) => ({
  roomNumber: i + 1,
  guest: "Empty",
}));

// Function to display the menu
function displayMenu() {
  console.log("\nWelcome to the Hotel Management System\n");
  console.log("1. Check-In");
  console.log("2. Check-Out");
  console.log("3. View Occupancy");
  console.log("4. Exit");
  return parseInt(prompt("\nEnter your choice: "), 10);
}

// Function to check in guests
function checkIn() {
  const roomNumber = parseInt(prompt("\nEnter room number: "), 10);

  if (roomNumber >= 1 && roomNumber <= rooms.length) {
    const room = rooms[roomNumber - 1];
    if (room.guest === "Empty") {
      const guestName = prompt("\nEnter guest name: ");
      room.guest = guestName;
      console.log("\nCheck-in successful.");
    } else {
      console.log("\nSorry, this room is already occupied.");
    }
  } else {
    console.log("\nInvalid room number. Please try again.");
  }
}

// Function to check out guests
function checkOut() {
  const roomNumber = parseInt(prompt("\nEnter room number: "), 10);

  if (roomNumber >= 1 && roomNumber <= rooms.length) {
    const room = rooms[roomNumber - 1];
    if (room.guest !== "Empty") {
      console.log(`\nGuest ${room.guest} has checked out of room ${room.roomNumber}.`);
      room.guest = "Empty";
    } else {
      console.log("\nSorry, this room is already vacant.");
    }
  } else {
    console.log("\nInvalid room number. Please try again.");
  }
}

// Function to view occupancy status
function viewOccupancy() {
  console.log("\nRoom\tGuest");
  rooms.forEach((room) => {
    console.log(`${room.roomNumber}\t${room.guest}`);
  });
}

// Main function
function main() {
  while (true) {
    const choice = displayMenu();

    switch (choice) {
      case 1:
        checkIn();
        break;
      case 2:
        checkOut();
        break;
      case 3:
        viewOccupancy();
        break;
      case 4:
        console.log("\nExiting... Thank you!");
        return;
      default:
        console.log("\nInvalid choice. Please try again.");
    }
  }
}

// Run the program
main();
