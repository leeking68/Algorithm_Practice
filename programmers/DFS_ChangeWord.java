package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :https://programmers.co.kr/learn/courses/30/lessons/43163
 * 
 * 
 */

public class DFS_ChangeWord {

	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		String begin = "hit";
		String target = "cog";

		System.out.println(solution(begin, target, words));

	}

	public static int solution(String begin, String target, String[] words) {
		
		boolean flag = false;
		boolean[] visited = new boolean[words.length];

		// check, there is no target words in words array
		for (int idx = 0; idx < words.length; idx++) {
			if (target.equals(words[idx])) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return 0;
		}
		
		//start to DFS 
		dfs(visited, words, begin, target, 0);

		return min;
	}

	public static void dfs(boolean[] visited, String[] words, String word, String target, int depth) {

	
		if (depth == words.length) {
			return;
		}

		for (int idx = 0; idx < words.length; idx++) {

			if (!visited[idx]) {
				visited[idx] = true;

				if (target.equals(word) && (depth < min)) {

					min = depth;

				} else {

					int cnt = 0;
					for (int pos = 0; pos < word.length(); pos++) {

						if (word.charAt(pos) != words[idx].charAt(pos)) {
							cnt++;
						}
					}

					if (cnt == 1) {
						dfs(visited, words, words[idx], target, depth + 1);

					}

				}

				visited[idx] = false;
			}

		}

	}
}
