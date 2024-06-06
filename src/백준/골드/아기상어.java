package 백준.골드;

import java.io.*;
import java.util.*;

public class 아기상어 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n;
	static int[][] map;
	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };
	static Shark s;
	static PriorityQueue<int[]> pq;
	static boolean[][] visited;

	static class Shark {
		int y, x, size, time, eatCnt;

		public Shark(int y, int x, int size, int time, int eatCnt) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.time = time;
			this.eatCnt = eatCnt;
		}

	}

	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					s = new Shark(i, j, 2, 0, 0);
					map[i][j] = 0;
				}
			}
		}

		move();

		System.out.println(s.time);

	}

	private static void move() {

		while (true) {
			// ��� �켱���� ť�� �ֱ�
			pq = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
					: (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
			visited = new boolean[n][n];

			pq.offer(new int[] { s.y, s.x, 0 });
			visited[s.y][s.x] = true;

			boolean isEat = false;

			// ���� ������ ���
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();

				if (map[cur[0]][cur[1]] < s.size && map[cur[0]][cur[1]] != 0) {
					map[cur[0]][cur[1]] = 0;
					s.y = cur[0];
					s.x = cur[1];
					s.time += cur[2];
					s.eatCnt += 1;
					isEat = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] <= s.size) {
						pq.offer(new int[] { ny, nx, cur[2] + 1 });
						visited[ny][nx] = true;
					}
				}
			}

			// ���̸� ���� �������� ����
			if (!isEat)
				break;

			// ���� ����� ���� ����� ũ��� ���ٸ� ��� ũ�� 1����
			if (s.size == s.eatCnt) {
				s.size++;
				s.eatCnt = 0;
			}

		}

	}

}