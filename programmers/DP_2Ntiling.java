package programmers;
/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/12900
 * 
 * 
 */
public class DP_2Ntiling {

	public static void main(String args[]) {

		System.out.println(solution(4));

	}
	// before test, have to delete 'static' keywords
	public static int solution(int n) {
		int answer = 0;
		int s = 1000000007;

		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for (int idx = 3; idx <= n; idx++) {

			dp[idx] = (dp[idx - 2] + dp[idx - 1]) % s;

		}

		answer = dp[n];

		return answer;
	}

}
