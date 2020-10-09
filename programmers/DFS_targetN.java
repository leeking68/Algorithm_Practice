package programmers;

/**
 * Problem from : programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/43165
 *         
 * 
 * 
 */

public class DFS_targetN {

	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = {1,1,1,1,1};
		System.out.println(solution(numbers,3));
		
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		dfs(numbers,target,0,(-numbers[0]));
		dfs(numbers,target,0,(+numbers[0]));

		answer = cnt;
		
		return answer;
	}
	
	public static void dfs(int[] numbers, int target, int depth, int result) {
		if(depth+1 == numbers.length) {
			
			System.out.println(result);
			if(result == target ) {
				cnt++;	
			}
			
			return;
		}
		

		dfs(numbers, target, depth+1, result+numbers[depth+1]);
		dfs(numbers, target, depth+1, result-numbers[depth+1]);
		
		
	}
}
