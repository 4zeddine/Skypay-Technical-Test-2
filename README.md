# Hotel Reservation System

A Java implementation of a simplified hotel reservation system demonstrating entity design, date range validation, and immutable data snapshots.

## Overview

This system manages hotel reservations with the following features:
- Create and update rooms with types and pricing
- Create users with balance management
- Book rooms with date overlap detection and balance validation
- Maintain immutable booking history

## Requirements Met

- Room and User entity management
- Booking entity with immutable snapshots
- Date range validation and overlap detection
- Balance verification and deduction
- setRoom() doesn't affect previous bookings
- Print operations show latest to oldest
- ArrayList-based storage
- Comprehensive exception handling

## Architecture

### Immutable Booking Snapshots

Bookings store complete snapshots of room and user data at booking time

### Date Overlap Detection

Validates room availability by checking if new booking overlaps with existing bookings

## Project Structure

```
src/
└── main/java/com/skypay/hotel/
    ├── RoomType.java         # Enum: STANDARD, JUNIOR, MASTER
    ├── User.java             # User entity with balance
    ├── Room.java             # Room entity with mutable properties
    ├── Booking.java          # Immutable booking snapshot
    ├── Service.java          # Main business logic
    └── Main.java             # Test case execution
```

## Running the Application

Execute the `Main` class located at `src/main/java/com/skypay/hotel/Main.java`

The test case demonstrates:
- Room and user creation
- Successful bookings with balance deduction
- Failed bookings (insufficient balance, invalid dates, date conflicts)
- Room updates not affecting previous bookings
- Final reporting with `printAll()` and `printAllUsers()`

## Core Classes

### Service

Main service class managing all operations:

```java
void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight)
void setUser(int userId, int balance)
void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut)
void printAll()
void printAllUsers()
```

### Booking Validations

Each booking attempt validates:
- User and room existence
- Date validity (checkout after checkin)
- Sufficient user balance
- Room availability (no date overlap)

Throws `IllegalArgumentException` with descriptive messages for invalid operations.


## Test Case Results

The test demonstrates:
1. User 1 booking Room 2 for 7 nights - Fails (insufficient balance: needs 14000, has 5000)
2. User 1 booking Room 2 with invalid dates - Fails (checkout before checkin)
3. User 1 booking Room 1 for 1 night - Success (balance: 5000 → 4000)
4. User 2 booking Room 1 for 2 nights - Fails (date overlap with User 1's booking)
5. User 2 booking Room 3 for 1 night - Success (balance: 10000 → 7000)
6. Room 1 updated to MASTER suite at 10000/night
7. User 1's booking still shows original price (1000/night)