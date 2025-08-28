package com.empiricism.heap;

public class Heapify {

        public static void main(String[] args) {
            int[] array = {4, 10, 3, 5, 1};

            System.out.println("Original array:");
            printArray(array);

            buildMaxHeap(array);

            System.out.println("Heapified (max-heap) array:");
            printArray(array);
        }

        // Build max-heap
        public static void buildMaxHeap(int[] arr) {
            int n = arr.length;

            // Start from last parent node and move to the root
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapifyDown(arr, n, i);
            }
        }

        // Heapify-down function (for max-heap)
        public static void heapifyDown(int[] arr, int n, int i) {
            int largest = i;         // Initialize largest as root
            int left = 2 * i + 1;    // Left child
            int right = 2 * i + 2;   // Right child

            // If left child is larger than root
            if (left < n && arr[left] > arr[largest])
                largest = left;

            // If right child is larger than largest so far
            if (right < n && arr[right] > arr[largest])
                largest = right;

            // If largest is not root
            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                // Recursively heapify the affected sub-tree
                heapifyDown(arr, n, largest);
            }
        }

        // Utility function to print array
        public static void printArray(int[] arr) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }


}
