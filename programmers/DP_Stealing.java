package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
 * 
 * 
 */

public class DP_Stealing {

	public static void main(String args[]) {

		int[] arr = { 1, 2, 3, 1 };

		System.out.println(solution(arr));

	}

	// before test, have to delete 'static' keywords
	public static int solution(int[] money) {
		int answer = 0;

		int[] initDp = new int[money.length-1];
		int[] notInitDp = new int[money.length];

		// add first index value
		initDp[0] = money[0];
		initDp[1] = money[0];

		// not add first index value
		notInitDp[0] = 0;
		notInitDp[1] = money[1];

		for (int index = 2; index < money.length - 1; index++) {

			initDp[index] = Math.max(initDp[index - 2] + money[index], initDp[index - 1]);

		}

		for (int index = 2; index < money.length; index++) {

			notInitDp[index] = Math.max(initDp[index - 2] + money[index], notInitDp[index - 1]);

		}
		
		answer = Math.max(initDp[money.length-2], notInitDp[money.length-1]);

		return answer;
	}
	public int solution2(int[] money) {        
        int[][] pick = new int[2][money.length];

        pick[0][0] = money[0];
        pick[0][1] = money[0];
        pick[1][0] = 0;
        pick[1][1] = money[1];

        for(int i=2; i<money.length; i++) {
            pick[0][i] = Math.max(pick[0][i-2] + money[i], pick[0][i-1]);
            pick[1][i] = Math.max(pick[1][i-2] + money[i], pick[1][i-1]);
        }

        return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
    }

}
