package acmicpc;

/**
 * Problem from : baekjoon
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/14889
 *         
 * 
 * 
 */


import java.util.Scanner;

public class DFS_14889 {

	public static int N;
	public static int[][] map;
	public static int gap = Integer.MAX_VALUE;
	static int[] pick = new int[20];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		map = new int[N][N];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				map[row][col] = in.nextInt();
			}
		}

		dfs(0, 0);

		System.out.println(gap);

	}

	public static void dfs(int count, int start) {

		if ((count * 2) == N) {

			int teamOneValue = teamOne();
			int teamTwoValue = teamTwo();
			int teamGap = Math.abs(teamOneValue - teamTwoValue);

			if (gap > teamGap) {

				gap = teamGap;

			}

			return;
		}

		for (int idx = start; idx < N; idx++) {
			pick[idx] = 1;
			dfs(count + 1, idx + 1);
			pick[idx] = 0;

		}

	}

	public static int teamOne() {
		int hap = 0;

		for (int row = 0; row < N; row++) {
			for (int col = row + 1; col < N; col++) {

				if ((pick[row] == 1) && (pick[col] == 1)) {

					hap += map[row][col];
					hap += map[col][row];

				}

			}
		}

		return hap;

	}

	public static int teamTwo() {
		int hap = 0;
		for (int row = 0; row < N; row++) {
			for (int col = row + 1; col < N; col++) {

				if ((pick[row] == 0) && (pick[col] == 0)) {

					hap += map[row][col];
					hap += map[col][row];

				}

			}
		}
		return hap;
	}

}
