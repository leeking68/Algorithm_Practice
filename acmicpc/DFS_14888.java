package acmicpc;

/**
 * Problem from : baekjoon
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/14888
 *         
 * 
 * 
 */

import java.util.Scanner;

public class DFS_14888 {

	public static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static int[] op = new int[4];
	public static int[] num;

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		num = new int[N];
		for (int idx = 0; idx < N; idx++) {
			num[idx] = in.nextInt();
		}

		for (int idx = 0; idx < 4; idx++) {
			op[idx] = in.nextInt();
		}
		
		dfs(0,num[0]);
		
		System.out.println(max);
        System.out.println(min);
	}

	public static void dfs(int num_idx, int result) {

		if (num_idx == N-1) {
			
			if (max < result) {
				
				max = result;

			}

			if (min > result) {

				min = result;
			}
			
			return;

		} else {

			for (int op_idx = 0; op_idx < 4; op_idx++) {

				if (op[op_idx] != 0) {

					op[op_idx]--;

					
					switch (op_idx) {

					case 0:
						dfs(num_idx+1, result + num[num_idx+1]);
						break;
					case 1:
						dfs(num_idx+1, result - num[num_idx+1]);

						break;
					case 2:
						dfs(num_idx+1, result * num[num_idx+1]);

						break;
					case 3:
						dfs(num_idx+1, result / num[num_idx+1]);

						break;

					}

					op[op_idx]++;

				}

			}

		}

	}

}
