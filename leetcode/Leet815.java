package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Leet815 {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) return 0;
		int count = 0;

		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> que = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				if (!map.containsKey(routes[i][j])) {
					map.put(routes[i][j], new ArrayList<>());
				}
				map.get(routes[i][j]).add(i);
			}
		}
		que.offer(source);
		while (!que.isEmpty()) {
			count++;
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int curPos = que.poll();
				ArrayList<Integer> buses = map.get(curPos);
				for (int bus : buses) {
					if (visited.contains(bus)) continue;
					visited.add(bus);
					for (int j = 0; j < routes[bus].length; j++) {
						if (routes[bus][j] == target) return count;
						que.offer(routes[bus][j]);
					}
				}
			}
		}
		return -1;
	}
}
