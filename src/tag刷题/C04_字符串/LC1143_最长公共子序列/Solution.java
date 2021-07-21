package tag刷题.C04_字符串.LC1143_最长公共子序列;

public class Solution {
    // 题目：求最长公共子序列的长度
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.equals("") || text2.equals("")) {
            return 0;
        }
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        // 画出dp表
        int[][] dp = getDpArr(c1, c2);
        return dp[c1.length - 1][c2.length - 1];
    }

    private int[][] getDpArr(char[] c1, char[] c2) {
        // dp[i][j]:c1[0...i]到c2[0...i]的最大公共子序列长度
        int[][] dp = new int[c1.length][c2.length];
        // 根据定义：c1[0]==c2[0]，dp[0][0]=1
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        // 先初始化第一行和第一列
        for (int i = 1; i < c2.length; i++) {
            // 子序列是只要前面取到最大过，后面都是它，所以用Math.max
            dp[0][i] = Math.max(dp[0][i - 1], c1[0] == c2[i] ? 1 : 0);
        }
        for (int i = 1; i < c1.length; i++) {
            // 子序列是只要前面取到最大过，后面都是它，所以用Math.max
            dp[i][0] = Math.max(dp[i - 1][0], c1[i] == c2[0] ? 1 : 0);
        }
        // 根据递推公式算其他
        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                // 取c1前一位和c2前一位的dp最大值
                int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (c1[i] == c2[j]) {// 两个i，j对应字符相同
                    dp[i][j] = Math.max(max, dp[i - 1][j - 1] + 1);
                } else {// 两个i，j对应字符不相同：取max
                    dp[i][j] = max;
                }
            }
        }
        return dp;
    }
}
