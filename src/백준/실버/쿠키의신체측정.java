package 백준.실버;

import java.io.*;
import java.util.*;

public class 쿠키의신체측정 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1 };
	static int[] dx = { -1, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= n; j++) {
				if (str.charAt(j - 1) == '*') {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
			}
		}

		int[] heartPoint = new int[2];

		boolean flag = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1 && !visited[i][j] && !flag) {

					// 심장 위치와 팔, 허리길이

					visited[i][j] = true;
					visited[i + 1][j] = true;
					heartPoint[0] = i + 1;
					heartPoint[1] = j;
					sb.append(heartPoint[0] + " ");
					sb.append(heartPoint[1] + "\n");

					flag = true;

					for (int k = 0; k < 3; k++) {
						int len = 0;
						int curY = heartPoint[0];
						int curX = heartPoint[1];

						while (true) {
							int ny = curY + dy[k];
							int nx = curX + dx[k];

							if (0 < ny && ny <= n && 0 < nx && nx <= n && map[ny][nx] == 1 && !visited[ny][nx]) {
								curY = ny;
								curX = nx;
								visited[ny][nx] = true;
								len++;
								continue;
							}

							break;
						}

						sb.append(len + " ");
					}
				} else if (map[i][j] == 1 && !visited[i][j] && flag) {

					// 다리길이

					int len = 1;
					int curY = i;
					int curX = j;
					visited[curY][curX] = true;

					while (true) {
						int ny = curY + dy[2];
						int nx = curX + dx[2];

						if (0 < ny && ny <= n && 0 < nx && nx <= n && map[ny][nx] == 1 && !visited[ny][nx]) {
							curY = ny;
							curX = nx;
							visited[ny][nx] = true;
							len++;
							continue;
						}

						break;

					}

					sb.append(len + " ");
				}
			}
		}

		System.out.println(sb);

	}
}
