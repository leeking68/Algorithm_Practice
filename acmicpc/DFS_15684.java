package acmicpc;

/**
 * Problem from : baekjoon
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/15684
 *         
 * 
 * 
 */

import java.util.Scanner;

public class DFS_15684 {

	static int N, M, H;
	static int ref;
	static int[][] map = new int[31][11];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		M = in.nextInt();
		H = in.nextInt();

		for (int k = 0; k < M; k++) {
			int a = in.nextInt();
			int b = in.nextInt();

			map[a][b] = 1;

		}

		ref = 4;
		dfs(0,1,1);
		if (ref == 4) {
			System.out.println(-1);
		} else {
			System.out.println(ref);
		}

	}
	
	public static void dfs(int count, int y, int x) {
		// count have to under compare with ref
		
		if(count >= ref) {
			return;
		}
		if(check()) {
			ref = count;
			return;
		}
		
		// maximum 3
		if(count == 3) return;
		
		for(int i = y; i <=H; ++i) {
			for(int j = x; j <=N; ++j) {
				
				if(map[i][j]==0 && map[i][j-1] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					dfs(count+1, i, j);
					map[i][j] = 0; //backtracking
				}
			}
			x = 1;
		}
	}
	
	public static boolean check() {
		boolean ret = true;
		
		
		for(int i = 1; i <= N; i++) {
			
			int pos = i; 
			
			for(int j = 0; j <= H; j++) {
				if(map[j][pos]==1) {
					pos++;
				} else if(map[j][pos-1] == 1) {
					pos--;
				}
			}
			
			if(pos != i) {
				return ret = false;
			}
			
		}
		
		return ret;
	}

}
