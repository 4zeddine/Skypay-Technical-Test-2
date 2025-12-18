package com.skypay.hotel;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        System.out.println("========== HOTEL RESERVATION SYSTEM TEST ==========\n");

        // Create 3 rooms
        System.out.println("--- Creating Rooms ---");
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.MASTER, 3000);

        // Create 2 users
        System.out.println("\n--- Creating Users ---");
        service.setUser(1, 5000);
        service.setUser(2, 10000);

        // Test bookings
        System.out.println("\n--- Testing Bookings ---");

        System.out.println("\n1. User 1 books Room 2 (30/06/2026 to 07/07/2026):");
        service.bookRoom(1, 2, createDate(2026, 6, 30), createDate(2026, 7, 7));

        System.out.println("\n2. User 1 books Room 2 (07/07/2026 to 30/06/2026):");
        service.bookRoom(1, 2, createDate(2026, 7, 7), createDate(2026, 6, 30));

        System.out.println("\n3. User 1 books Room 1 (07/07/2026 to 08/07/2026):");
        service.bookRoom(1, 1, createDate(2026, 7, 7), createDate(2026, 7, 8));

        System.out.println("\n4. User 2 books Room 1 (07/07/2026 to 09/07/2026):");
        service.bookRoom(2, 1, createDate(2026, 7, 7), createDate(2026, 7, 9));

        System.out.println("\n5. User 2 books Room 3 (07/07/2026 to 08/07/2026):");
        service.bookRoom(2, 3, createDate(2026, 7, 7), createDate(2026, 7, 8));

        System.out.println("\n--- Updating Room 1 ---");
        service.setRoom(1, RoomType.MASTER, 10000);

        // Print final results
        service.printAll();
        service.printAllUsers();
    }

    private static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
