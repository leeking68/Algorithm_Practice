package acmicpc;

import java.util.Scanner;

public class DP_15988 {


public static void main(String[] args) {

    Scanner ac = new Scanner(System.in);

    int T = ac.nextInt();
    int[] num = new int[T+1];
    long[] dp = new long[1000000];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    int max = 0;

    for(int i = 1; i <= T; i++) {

        num[i] = ac.nextInt();
        if(max < num[i]) max = num[i];

    }

    if(max > 3) {
        for(int pos = 4; pos <= max; pos++) {
            dp[pos] = (dp[pos-3] + dp[pos-2] + dp[pos-1])%1000000009;
        }
    }


    for(int pos = 1; pos < num.length; pos++) {
        System.out.println(dp[num[pos]]);
    }

}



}
