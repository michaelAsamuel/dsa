public class LongestCommonSubsequence {

    public static String getLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Fill DP matrix
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // diagonally up
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //  max top or left
                }
            }
        }

        // Step 2: Print DP matrix
//        System.out.println("DP Matrix:");
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        // Step 3: Reconstruct the LCS string by tracing from dp[m][n]
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString(); // reverse since we traced from the end
    }

    public static void main(String[] args) {
        String text1 = "abcd";
        String text2 = "ade";

        String lcs = getLCS(text1, text2);
        System.out.println("Longest Common Subsequence: " + lcs);
        System.out.println("Length of LCS: " + lcs.length());


        lcs = getLCS("cadence", "cascade");
        System.out.println("Longest Common Subsequence: " + lcs);
        System.out.println("Length of LCS: " + lcs.length());
    }
}
