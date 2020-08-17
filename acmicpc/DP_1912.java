package acmicpc;

import java.util.Scanner;

public class DP_1912 {
	public static int n, arr[], dp[];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 1; i < n + 1; i++) {

			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

		}

		int ans = dp[1];

		for (int i = 1; i < n + 1; i++) {

			if (ans < dp[i]) {
				ans = dp[i];
			}
		}

		System.out.println(ans);
	}

}
