package 프로그래머스.Level3;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
	}

	static int[] parents;

	public static int solution(int n, int[][] computers) {

		parents = new int[n];

		make(n);

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (computers[y][x] == 1 && y != x) {
					union(y, x);
				}
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (list.contains(find(i))) {
				continue;
			} else {
				list.add(find(i));
			}
		}

		return list.size();
	}

	private static void make(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

	private static void union(int y, int x) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			parents[rootX] = rootY;
		}
	}

}
