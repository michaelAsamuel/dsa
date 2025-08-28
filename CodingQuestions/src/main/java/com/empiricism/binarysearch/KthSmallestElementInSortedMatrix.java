package com.empiricism.binarysearch;

public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k){
    int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];


        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("Mid: "+mid);
            int count = countLessOrEqual(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int countLessOrEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] > target) {
                j--;
            }
            count += (j + 1);
        }
        return count;
    }

}
