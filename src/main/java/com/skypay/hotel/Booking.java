package com.skypay.hotel;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Booking {
    private final int bookingId;
    private final int userId;
    private final int userBalanceAtBooking;
    private final int roomNumber;
    private final RoomType roomTypeAtBooking;
    private final int roomPriceAtBooking;
    private final Date checkIn;
    private final Date checkOut;
    private final int totalCost;
    private final long timestamp;

    public Booking(int bookingId, int userId, int userBalanceAtBooking,
        int roomNumber, RoomType roomTypeAtBooking, int roomPriceAtBooking,
        Date checkIn, Date checkOut, int totalCost) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.userBalanceAtBooking = userBalanceAtBooking;
        this.roomNumber = roomNumber;
        this.roomTypeAtBooking = roomTypeAtBooking;
        this.roomPriceAtBooking = roomPriceAtBooking;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalCost = totalCost;
        this.timestamp = System.currentTimeMillis();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Booking{ID=" + bookingId +
                ", User{ID=" + userId + ", Balance=" + userBalanceAtBooking + "}" +
                ", Room{Number=" + roomNumber + ", Type=" + roomTypeAtBooking +
                ", Price/Night=" + roomPriceAtBooking + "}" +
                ", CheckIn=" + sdf.format(checkIn) +
                ", CheckOut=" + sdf.format(checkOut) +
                ", TotalCost=" + totalCost + "}";
    }
}