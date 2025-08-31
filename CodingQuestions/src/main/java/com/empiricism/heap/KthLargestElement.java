package com.empiricism.heap;

//https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargestPQ(int[] nums, int k) {

        // Min-heap to keep track of top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            // Keep heap size no larger than k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();


    }
    public static int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.removeMin();
            }
        }
        return heap.peek();
    }

    // Custom Min-Heap with fixed (or flexible) capacity
    static class MinHeap {
        private int[] heap;
        private int size;

        MinHeap(int capacity) {
            heap = new int[capacity + 1]; // 1-based index
            size = 0;
        }

        int size() {
            return size;
        }

        void add(int val) {
            if (size + 1 >= heap.length) {
                // optional: resize if needed
                int[] newHeap = new int[heap.length * 2];
                System.arraycopy(heap, 0, newHeap, 0, heap.length);
                heap = newHeap;
            }
            heap[++size] = val;
            heapifyUp(size);
        }

        int peek() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            return heap[1];
        }

        int removeMin() {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            int min = heap[1];
            heap[1] = heap[size--];
            heapifyDown(1);
            return min;
        }

        private void heapifyUp(int idx) {
            while (idx > 1) {
                int parent = idx / 2;
                if (heap[parent] > heap[idx]) {
                    swap(parent, idx);
                    idx = parent;
                } else {
                    break;
                }
            }
        }

        private void heapifyDown(int idx) {
            while (2 * idx <= size) {
                int left = 2 * idx;
                int right = left + 1;
                int smallest = left;
                if (right <= size && heap[right] < heap[left]) {
                    smallest = right;
                }
                if (heap[smallest] < heap[idx]) {
                    swap(smallest, idx);
                    idx = smallest;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    // Example main
    public static void main(String[] args) {
        int[] nums = {3, 2, 11, 5, 6, 4};
        int k = 3;
        System.out.println(findKthLargest(nums, k));  // Output: 5
    }



}
