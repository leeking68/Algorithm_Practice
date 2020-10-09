package programmers;

/**
 * Problem from : programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/68644
 *         Solution 1 : DFS 
 *         Solution 2 : DP using ArrayList , Hashset
 *         Solution 2 : DP using ArrayList 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class DFS_sum2number {
	static int sum;
	static ArrayList<Integer> list;
	static ArrayList<Integer> notDuList;

	public static void main(String[] args) {

	}

	public static int[] solution(int[] numbers) {
		int size = numbers.length;
		boolean[] visited = new boolean[size];

		list = new ArrayList<Integer>();
		notDuList = new ArrayList<Integer>();

		for (int idx = 0; idx < size; idx++) {
			if (!visited[idx]) {

				visited[idx] = true;

				dfs(1, numbers, visited, idx + 1);

			}

			visited[idx] = false;
		}

		for (int idx = 0; idx < list.size(); idx++) {
			if (!notDuList.contains(list.get(idx))) {
				notDuList.add(list.get(idx));
			}
		}

		Collections.sort(notDuList);

		int[] answer = new int[notDuList.size()];

		for (int idx = 0; idx < notDuList.size(); idx++) {

			answer[idx] = notDuList.get(idx);

		}

		return answer;
	}

	public static void dfs(int count, int[] numbers, boolean[] visited, int start) {
		sum = 0;
		if (count == 2) {

			for (int idx = 0; idx < numbers.length; idx++) {

				if (visited[idx]) {
					sum += numbers[idx];

				}

			}

			list.add(sum);

			return;

		}

		for (int idx = start; idx < numbers.length; idx++) {

			if (!visited[idx]) {

				visited[idx] = true;

				dfs(count + 1, numbers, visited, idx + 1);

			}

			visited[idx] = false;

		}

	}

}
