package acmicpc;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/14502
 *         
 * 
 * 
 */

import java.util.Scanner;

public class DFS_14502 {
	static int N,M;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int count = 0; 
	static int ans = -1;
	public static void main(String args[]) {
		
		
		Scanner sc = new Scanner(System.in);
		
		N  = sc.nextInt();
		M  = sc.nextInt();
		
		map = new int[N][M];
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				
				map[i][j] = sc.nextInt();
				
			}
		
		
		for(int i = 0; i < N*M; i++) {
				
				int nx = (int)i/M;
				int ny = i % M;
				
				if(map[nx][ny] == 0) {
					
					map[nx][ny] = 1;
				
					makeWall(i,1);
					
					map[nx][ny] = 0;
					
				
			}
		
		
		}
		
		System.out.println(ans);
		
	}
	
	public static void makeWall(int start, int depth) {
		
		if(depth == 3) {
			
			copymap = new int[N][M];
			
			for(int i =0 ; i < N; i++) 
				for(int j = 0 ; j < M; j++) {
					copymap[i][j] = map[i][j];
				}
			
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++) {
				
					if(copymap[i][j]==2) {
						
						speard(i, j);
						
					}
					
				}
			
			calc();
			
			
		} else {
			
			
			for(int i = start+1; i < N*M; i++) {
					
					int nx = (int)i/M;
					int ny = i % M;
					
					if(map[nx][ny] == 0) {
						
						map[nx][ny] = 1;
						
						makeWall(i,depth+1);
						
						map[nx][ny] = 0;
						
					
				}
			
			
			}
		}
		
		
	}
	
	public static void speard(int x, int y) {
		
		for(int i = 0; i < 4; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && nx <N&& ny >=0 && ny <M) {
				
				if(copymap[nx][ny]==0) {
					
					copymap[nx][ny] = 2;
					
					speard(nx,ny);
					
				}
				
			}
			
			
		}
		
	}
	
	public static void calc() {

		count = 0;
		
		for(int i =0 ;i < N; i++) 
			for(int j = 0; j < M; j++) {
				
				if(copymap[i][j]==0) {
					
					count++;
				}
				
			}
		
		if(count > ans) {
			
			ans = count;
			
		}
		
	}
	

}

