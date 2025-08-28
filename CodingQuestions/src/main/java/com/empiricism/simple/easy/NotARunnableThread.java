package com.empiricism.simple.easy;

public class NotARunnableThread extends Thread {
    public static void main(String args[]) {
        NotARunnableThread nThread = new NotARunnableThread();
        nThread.start();
        System.out.println("Thread is now terminated");
    }
}
