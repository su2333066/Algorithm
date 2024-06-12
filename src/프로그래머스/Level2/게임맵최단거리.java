package 프로그래머스.Level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
	}

	static int n, m;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static int solution(int[][] maps) {

		n = maps.length;
		m = maps[0].length;
		visited = new boolean[n][m];

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && maps[ny][nx] != 0) {
					q.offer(new int[] { ny, nx });
					maps[ny][nx] += maps[cur[0]][cur[1]];
					visited[ny][nx] = true;
				}
			}
		}

		return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];

	}

}
