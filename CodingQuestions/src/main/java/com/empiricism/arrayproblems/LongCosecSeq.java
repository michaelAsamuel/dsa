package com.empiricism.arrayproblems;

import java.util.HashSet;
import java.util.Set;

public class LongCosecSeq {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only start counting when it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }

    public static void main(String[] args) {
        int[] input = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(input));

    }
}
