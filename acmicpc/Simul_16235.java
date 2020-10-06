package acmicpc;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Simul_16235 {

	public static int[][] A;
	public static int[][] map;
	public static int N, M, K;
	public static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
	public static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static Queue<Tree> save = new LinkedList<>();
	static Queue<Tree> death = new LinkedList<>();
	static PriorityQueue<Tree> pq = new PriorityQueue<Tree>(new Comparator<Tree>() {
		@Override
		public int compare(Tree o1, Tree o2) {
			return o1.age - o2.age;

		}
	});

	static class Tree {

		int x, y, age;

		public Tree(int x, int y, int age) {

			this.x = x;
			this.y = y;
			this.age = age;
		}

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();

		A = new int[N + 1][N + 1];
		map = new int[N + 1][N + 1];

		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				map[row][col] = 5;
				A[row][col] = in.nextInt();
			}
		}

		for (int k = 0; k < M; k++) {

			int x = in.nextInt();
			int y = in.nextInt();
			int age = in.nextInt();

			pq.add(new Tree(x, y, age));
		}

		for (int T = 0; T < K; T++) {
			season();

		}

		System.out.println(pq.size());
	}

	public static void season() {

		// spring

		while (!pq.isEmpty()) {

			Tree tree = pq.poll();
			System.out.println(tree.age);
			if (map[tree.x][tree.y] >= tree.age) {
				map[tree.x][tree.y] -= tree.age;

				tree.age += 1;

				save.add(tree);

			} else {

				death.add(tree);

			}

		}

		// summer

		while (!death.isEmpty()) {

			Tree tree = death.poll();

			map[tree.x][tree.y] += (tree.age / 2);

		}

		// autumn

		while (!save.isEmpty()) {

			Tree tree = save.poll();

			if ((tree.age % 5) == 0) {

				for (int k = 0; k < 8; k++) {

					int nx = dx[k] + tree.x;
					int ny = dy[k] + tree.y;

					if (nx <= N && nx > 0 && ny <= N && ny > 0) {

						pq.add(new Tree(nx, ny, 1));

					}

				}

			}

			pq.add(tree);

		}

		// winter

		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				map[row][col] += A[row][col];
			}
		}

	}

}
