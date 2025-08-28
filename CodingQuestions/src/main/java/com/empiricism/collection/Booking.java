package com.empiricism.collection;

import java.util.TreeMap;

public class Booking {
    TreeMap<Integer, Integer> bookings = new TreeMap<>();

    boolean book(int start, int end) {
        Integer floorKey = bookings.floorKey(start);
        if (floorKey != null && bookings.get(floorKey) > start) return false; // overlaps left

        Integer ceilingKey = bookings.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false; // overlaps right

        bookings.put(start, end);
        return true;
    }


}
