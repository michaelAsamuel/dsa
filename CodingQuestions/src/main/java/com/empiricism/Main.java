package com.empiricism;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        printTree(0, 5, "");

    }

    public static void printTree(int step, int n, String path) {
        if (step > n) return;
        if (step == n) {
            System.out.println(path + step);
            return;
        }

        printTree(step + 1, n, path + step + " -> ");
        printTree(step + 2, n, path + step + " -> ");
    }

}