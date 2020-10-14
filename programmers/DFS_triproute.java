package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/43164
 *        
 * 
 * 
 */

public class DFS_triproute {

	public static void main(String[] args) {

//		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		String[] ans = solution(tickets);
		for (int idx = 0; idx < ans.length; idx++) {

			System.out.print(ans[idx] + ",");
		}
	}

	static String[] answerList = {};
	static String[] comList = {};

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		int rowLen = tickets.length;

		boolean[] visited = new boolean[rowLen];

		for (int idx = 0; idx < rowLen; idx++) {
			if (!visited[idx]) {
				visited[idx] = true;
				dfs(visited, tickets, tickets[idx][0] + "," + tickets[idx][1], tickets[idx][1], 1, rowLen);
				visited[idx] = false;

			}

		}
		answer = answerList;

		return answer;
	}

	public static void dfs(boolean[] visited, String[][] tickets, String way, String depart, int depth, int rowLen) {
		if (depth == rowLen) {
			if (way.subSequence(0, 3).equals("ICN")) {
				if (answerList.length == 0) {
					answerList = way.split(",");
				} else {
					comList = way.split(",");
				}

				if (comList.length != 0 && checkRoute(answerList, comList)) {
					answerList = comList;
				}
			}
			return;
		}

		for (int idx = 0; idx < rowLen; idx++) {

			if (!visited[idx] && tickets[idx][0].equals(depart)) {
				visited[idx] = true;
				dfs(visited, tickets, way + "," + tickets[idx][1], tickets[idx][1], depth + 1, rowLen);
				visited[idx] = false;

			}

		}

	}

	public static boolean checkRoute(String[] cur, String[] com) {
		boolean answer = false;
		int answerCheck = -1;
		for (int idx = 0; idx < cur.length; idx++) {
			if (cur[idx].equals(com[idx])) {
				continue;
			}
			char[] word = cur[idx].toCharArray();
			char[] c_word = com[idx].toCharArray();

			for (int idx2 = 0; idx2 < 3; idx2++) {

				if (c_word[idx2] < word[idx2]) {
					answerCheck = 1;
					answer = true;
					break;
				} else if (c_word[idx2] > word[idx2]) {
					answerCheck = 1;
					break;
				}

			}

			if (answerCheck == 1) {
				break;
			}

		}

		return answer;
	}
}
