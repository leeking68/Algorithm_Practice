package acmicpc;

/**
 * Problem from : baekjoon
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/16236
 *         
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_16236 {

	public static int N, sharkX, sharkY, sharkSize = 2, ans = 0, cnt;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static int[][] map;

	static class Fish {
		int x, y, move;

		public Fish(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		N = in.nextInt();

		map = new int[N][N];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {

				map[y][x] = in.nextInt();

				if (map[y][x] == 9) {

					sharkX = x;
					sharkY = y;

				}

			}
		}

		bfs();

	}

	static class SortList implements Comparator<Fish> {

		public int compare(Fish f1, Fish f2) {

			if (f1.y < f2.y) {
				return -1;
			} else if (f1.y == f2.y) {
				if (f1.x < f2.x) {
					return -1;
				} else if (f1.x == f2.x) {
					return 0;
				}

				return 1;
			} else {
				return 1;
			}

		}

	}

	public static void bfs() {

		while (true) {

			boolean[][] visited = new boolean[N][N];
			int found = -1;

			ArrayList<Fish> eatList = new ArrayList<Fish>();
			Queue<Fish> que = new LinkedList<Fish>();

			que.add(new Fish(sharkX, sharkY, 0));

			visited[sharkY][sharkX] = true;

			while (!que.isEmpty()) {

				Fish node = que.poll();

				int cx = node.x;
				int cy = node.y;
				int move = node.move;

				if (move == found) {
					break;
				}

				for (int k = 0; k < 4; k++) {

					int nx = cx + dx[k];
					int ny = cy + dy[k];

					if (nx < N && nx >= 0 && ny < N && ny >= 0) {

						if (visited[ny][nx]) {
							continue;
						}
						visited[ny][nx] = true;
						if (sharkSize >= map[ny][nx]) {

							if (map[ny][nx] > 0 && sharkSize > map[ny][nx]) {

								found = move + 1;
								eatList.add(new Fish(nx, ny, move + 1));

							}
							que.add(new Fish(nx, ny, move + 1));

						}

					}

				}

			}
			if (found == -1) {
				break;
			} else if (eatList.size() > 1) {

				Collections.sort(eatList, new SortList());

			}

			Fish fish = eatList.get(0);

			if (found != -1) {
				ans += found;

				map[sharkY][sharkX] = 0;
				sharkX = fish.x;
				sharkY = fish.y;
				map[sharkY][sharkX] = 9;

				if (sharkSize == ++cnt) {

					sharkSize++;
					cnt = 0;

				}

			}

		}

		System.out.println(ans);
	}

}
