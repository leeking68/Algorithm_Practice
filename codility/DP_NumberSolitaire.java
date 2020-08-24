package codility;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI : https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/start/
 * 
 * 
 */

public class DP_NumberSolitaire {

	public static void main(String args[]) {

		int[] A = { 1, -2, 0, 9, -1, -2 };
		System.out.println(solution(A));

	}

	// before test, have to delete 'static' keywords
	public static int solution(int[] A) {
		int answer = 0;
		int[] dpBoard = new int[A.length];

		dpBoard[0] = A[0];

		for (int idx = 1; idx < A.length; idx++) {
			int maxNum = Integer.MIN_VALUE;

			for (int next_idx = 1; next_idx <= 6; next_idx++) {

				if (idx - next_idx >= 0) {
					maxNum = Math.max(dpBoard[idx - next_idx] + A[idx], maxNum);
				}
			}

			dpBoard[idx] = maxNum;

		}

		answer = dpBoard[A.length - 1];

		return answer;
	}


}
