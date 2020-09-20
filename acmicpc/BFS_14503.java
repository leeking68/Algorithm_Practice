package acmicpc;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/14503
 *         
 * 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_14503 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { -1, 0, 1, 0 };
	public static int curR, curC, N, M, curDir, ans = 1;
	public static int[][] map;
	public static boolean[][] visited = new boolean[50][50];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		M = in.nextInt();
		N = in.nextInt();

		map = new int[M][N];

		curR = in.nextInt();
		curC = in.nextInt();
		curDir = in.nextInt();

		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {

				map[row][col] = in.nextInt();

			}
		}
		visited[curR][curC] = true;

		bfs();
		System.out.println(ans);

	}

	static class Robot {
		int r, c, dir;

		public Robot(int r, int c, int dir) {

			this.r = r;
			this.c = c;
			this.dir = dir;

		}
	}

	public static void bfs() {

		Queue<Robot> que = new LinkedList<>();
		que.add(new Robot(curR, curC, curDir));
		while (!que.isEmpty()) {

			Robot ro = que.poll();
			boolean flag = false;

			int d = ro.dir;
			int y = ro.r;
			int x = ro.c;

			int nextDir = d;
			int nx = 0;
			int ny = 0;

			for (int idx = 0; idx < 4; idx++) {

				nextDir = rotateValue(nextDir);

				nx = x + dx[nextDir];
				ny = y + dy[nextDir];

				if (nx < N && nx >= 0 && ny < M && ny >= 0) {
					if (map[ny][nx] == 0 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						ans++;
						que.add(new Robot(ny, nx, nextDir));
						flag = true;
						break;
					}

				}

			}

			if (!flag) {

				nextDir = backValue(d);

				nx = x + dx[nextDir];
				ny = y + dy[nextDir];

				if (nx < N && nx >= 0 && ny < M && ny >= 0) {
					if (map[ny][nx] == 0) {
						que.add(new Robot(ny, nx, d));

					}

				}

			}

		}

	}

	public static int backValue(int dir) {

		return (dir + 2) % 4;

	}

	public static int rotateValue(int dir) {

		return (dir + 3) % 4;

	}

}
