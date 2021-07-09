package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet994 {

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		int[][] zz = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int[][] idx = { { 0, 1 } };
		int[][] dx2 = { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
		System.out.println(orangesRotting2(dx2));
		System.out.println(orangesRotting(dx2));

	}

	public static int orangesRotting(int[][] grid) {

        
		int ans = 0;
		int count = 0;
		int rLength = grid.length;
		int cLength = grid[0].length;
		
		Queue<Orange> que = new LinkedList<>();
		
		for(int x = 0; x < rLength; x++)
			for(int y = 0; y < cLength; y++) {
				if(grid[x][y]==1) {
					count++;
				} else if(grid[x][y]==2) {
					que.add(new Orange(x,y));
				} 
			}
        System.out.println("coiu : " + count);	
		if(count == 0) return 0;

		
		while(!que.isEmpty() && count > 0) {
			System.out.println("check");
			for(int pos = 0; pos < que.size(); pos++) {
				Orange node = que.poll();
				
				for(int dir= 0; dir < 4; dir++) {
					
					int nextX = node.x + dx[dir];
					int nextY = node.y + dy[dir];
					
					if(nextX < 0 || nextX >=rLength || nextY < 0 || nextY >= cLength) continue;
					if(grid[nextX][nextY] == 1) {
						que.add(new Orange(nextX,nextY));
						count--;
						grid[nextX][nextY] = 2;
					}
					
				}
			}
            ans++;
			
		}
				System.out.println(count+"@@");

		return count == 0 ? ans : -1;
	}

	static class Orange {
		int x, y;

		public Orange(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int orangesRotting2(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int freshCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					freshCount++;
				} else if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int step = 0;
		while (!queue.isEmpty() && freshCount > 0) {
			int size = queue.size();
			System.out.println("@#@# : " +  size);
			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();
				for (int[] dir : DIRS) {
					int nextX = curr[0] + dir[0];
					int nextY = curr[1] + dir[1];
					if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || grid[nextX][nextY] != 1) {
						continue;
					}
					queue.offer(new int[] { nextX, nextY });
					grid[nextX][nextY] = 2;
					freshCount--;
				}
			}

			step++;
		}

		return freshCount == 0 ? step : -1;
	}

}
