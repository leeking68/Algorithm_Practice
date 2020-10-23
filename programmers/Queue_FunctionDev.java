package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI : https://programmers.co.kr/learn/courses/30/lessons/42586
 * 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class Queue_FunctionDev {

	public static void main(String[] args) {

		int[] pro = { 93, 30, 55 };
		int[] sp = { 1, 30, 5 };

		int[] ans = solution(pro, sp);

		for (int idx = 0; idx < ans.length; idx++) {
			System.out.println(ans[idx]);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visited = new boolean[progresses.length];

		while (true) {

			int cnt = 0;

			for (int idx = 0; idx < progresses.length; idx++) {

				progresses[idx] += speeds[idx];

			}

			if (!visited[0] && progresses[0] >= 100) {
				visited[0] = true;
				cnt++;
			}

			if (visited[0]) {

				for (int pos = 1; pos < progresses.length; pos++) {

					if (visited[pos - 1] && progresses[pos] >= 100 && !visited[pos]) {
						visited[pos] = true;
						cnt++;
					}

				}

			}

			if (cnt > 0) {
				que.add(cnt);
			}

			// exit condition : If lastprogress is complete all progress were completed.
			if (visited[progresses.length - 1]) {
				break;
			}

		}
		
		int[] answer = new int[que.size()];

		int idx = 0;
		while (!que.isEmpty()) {

			answer[idx] = que.poll();
			idx++;

		}

		return answer;
	}

}
