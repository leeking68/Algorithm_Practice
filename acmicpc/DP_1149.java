package acmicpc;

/**
 * @date : 2021-08-31
 * @author : Gilho Lee
 * solution : DP
 * addr : https://www.acmicpc.net/problem/1149
 * difficulty : Silver
 */

import java.util.Scanner;


public class DP_1149 {

    public static int n;
    public static int[][] dp;
    public static int[][] color;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        DP_1149 sol = new DP_1149();
        n = in.nextInt();
        dp = new int[n+1][3];
        color = new int[n+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = color[0][0] = color[0][1] = color[0][2] = 0;

        for(int i = 1; i < n+1; i++)
            for(int j = 0; j < 3; j++) {
                color[i][j] = in.nextInt();
            }

        System.out.println(sol.dp(color));

    }

    public int dp(int[][] color) {

        for(int pos = 1; pos < n+1; pos++) {


            dp[pos][0] = Math.min(dp[pos-1][1],dp[pos-1][2]) + color[pos][0];
            dp[pos][1] = Math.min(dp[pos-1][0],dp[pos-1][2]) + color[pos][1];
            dp[pos][2] = Math.min(dp[pos-1][1],dp[pos-1][0]) + color[pos][2];
        }

        return Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);

    }

    public static int Min(int a, int b){ return a < b ? a : b; }

}
