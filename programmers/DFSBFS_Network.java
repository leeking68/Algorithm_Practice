package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI : https://programmers.co.kr/learn/courses/30/lessons/43162
 * 
 * 
 */

public class DFSBFS_Network {

	public static void main(String args[]) {

		// ex1
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		// ex2
		int[][] computers2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

		int n = 3;

		int ans = solution(n, computers2);

		System.out.println(ans);

	}

	public static int SIZE;

	// before test, have to delete 'static' keywords
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[][] visited = new boolean[n][n];
		SIZE = n;

		for (int c_idx = 0; c_idx < n; c_idx++)
			for (int r_idx = c_idx; r_idx < n; r_idx++) {

				if ((computers[c_idx][r_idx] == 1) && (visited[c_idx][r_idx] == false)) {
					visited[c_idx][r_idx] = true;
					dfs(r_idx, visited, computers);
					answer++;

				}
			}

		return answer;
	}

	public static void dfs(int idx, boolean[][] visited, int[][] computers) {

		for (int col = 0; col < SIZE; col++) {

			if ((computers[idx][col] == 1) && (visited[idx][col] == false)) {

				visited[idx][col] = true;

				dfs(col, visited, computers);

			}

		}

	}

}
