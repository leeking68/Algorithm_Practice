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

public class DP_sum2number_2 {
	static int sum;
	static ArrayList<Integer> list;
	static ArrayList<Integer> notDuList;

	public static void main(String[] args) {

	}


	public static ArrayList<Integer> solution3(int[] numbers) {

		ArrayList<Integer> answer = new ArrayList<Integer>();

		int size = numbers.length;
		for (int idx = 0; idx < size - 1; idx++) {
			for (int idx2 = idx + 1; idx2 < size; idx2++) {

				int sum = numbers[idx] + numbers[idx2];

				if (!answer.contains(sum)) {
					answer.add(sum);
				}

			}
		}

		Collections.sort(answer);

		return answer;

	}
}
