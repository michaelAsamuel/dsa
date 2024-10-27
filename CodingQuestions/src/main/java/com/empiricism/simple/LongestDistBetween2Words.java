package com.empiricism.simple;
//Given a sentence/phrase and two words,
//    return the minimum distance between the words.
//
//Example:
//String str = “the quick the brown quick brown the frog”
//String word1 = “quick”
//String word2 = "frog"
//return 2

public class LongestDistBetween2Words {
    public static void main(String[] args) {
        //System.out.println(getMinDistance("the quick the brown quick brown the frog", "quick","frog" ));
        System.out.println(getMinDistance("the quick thee dag brown quick brown aa bb cc dd ee ff ss the frog", "the","brown" ));

    }

    private static int getMinDistance(String sentence, String w1, String w2){
        int minDist=Integer.MAX_VALUE;
        int currDist=0;
        int s1Index=Integer.MAX_VALUE, s2Index=Integer.MAX_VALUE;
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            if(words[i].equals(w1)) {
                s1Index=i;
                currDist=Math.abs(s1Index - s2Index)-1;
                minDist=Math.min(minDist, currDist);
            }
            if(words[i].equals(w2)) {
                s2Index=i;
                currDist=Math.abs(s1Index - s2Index)-1;
                minDist=Math.min(minDist, currDist);
            }

        }
        return minDist;
    }
}
