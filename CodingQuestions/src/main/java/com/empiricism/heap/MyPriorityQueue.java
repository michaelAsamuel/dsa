package com.empiricism.heap;

public class MyPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor
    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Get index helpers
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Add a new element
    public void insert(int val) {
        if (size == capacity) throw new RuntimeException("Heap is full");
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    // Remove and return the max (highest priority)
    public int extractMax() {
        if (size == 0) throw new RuntimeException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    // Return the max without removing
    public int peek() {
        if (size == 0) throw new RuntimeException("Heap is empty");
        return heap[0];
    }

    // Heapify-up (used in insert)
    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Heapify-down (used in extractMax)
    private void heapifyDown(int i) {
        int largest = i;  // tracks index of largest element of current node and its children
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest); // Recursively
        }
    }

    // Swap helper
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
        MyPriorityQueue pq = new MyPriorityQueue(10);

        pq.insert(3);
        pq.insert(10);
        pq.insert(5);
        pq.insert(1);

        System.out.println("Top priority (peek): " + pq.peek()); // 10

        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.extractMax());
        }
    }
}

