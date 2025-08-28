package com.empiricism.collection;
import java.util.Map;
import java.util.TreeMap;

public class SeatBooking {

    // TreeMap to store booked intervals: key=start, value=end
    private TreeMap<Integer, Integer> bookings = new TreeMap<>();

    // Booking method
    public boolean book(int start, int end) {
        // Find interval just before the start
        Map.Entry<Integer, Integer> lower = bookings.floorEntry(start);
        if (lower != null && lower.getValue() >= start) {
            // Overlaps with previous interval
            return false;
        }

        // Find interval just after the start
        Map.Entry<Integer, Integer> higher = bookings.ceilingEntry(start);
        if (higher != null && higher.getKey() < end) {
            // Overlaps with next interval
            return false;
        }

        // No overlap — book it
        bookings.put(start, end);
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        SeatBooking system = new SeatBooking();

        System.out.println("Booking (25, 35): " + system.book(25, 35)); // true
        System.out.println("Booking (45, 77): " + system.book(45, 77)); // true
        System.out.println("Booking (30, 40): " + system.book(30, 40)); // false
        System.out.println("Booking (77, 88): " + system.book(77, 88)); // true
        System.out.println("Booking (10, 20): " + system.book(10, 20)); // true
        System.out.println("Booking (34, 45): " + system.book(34, 45)); // false (overlap end and start)
        System.out.println("Booking (88, 100): " + system.book(88, 100)); // true
    }
}
