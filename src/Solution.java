import java.util.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(120, new int[] { 1500, 300, 250, 359, 600 }, new int[][] { { 2, 0, 4, 0, -1 },
				{ 0, 0, 3, 0, 0 }, { -1, -1, -1, 0, 0 }, { 0, 0, 5, 0, 0 }, { -1, 0, 0, -1, -1 } }));
	}

	public static int solution(int k, int[] limits, int[][] sockets) {

		int answer = 0;
		List<int[]> list = new ArrayList<>();
		int[] use = new int[sockets.length];

		for (int i = 0; i < sockets.length; i++) {

			int[] temp = new int[6];
			temp[0] = i + 1;
			for (int j = 0; j < 5; j++) {
				temp[j + 1] = sockets[i][j];
			}

			list.add(temp);
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				int connect1 = 0;
				int connect2 = 0;
				for (int i = 1; i <= 5; i++) {
					if (o1[i] > 0) {
						connect1++;
					}
				}
				for (int i = 1; i <= 5; i++) {
					if (o2[i] > 0) {
						connect2++;
					}
				}

				return connect1 == connect2 ? Integer.compare(o2[0], o1[0]) : Integer.compare(connect1, connect2);
			}

		});

		for (int[] socket : list) {
			int sum = 0;

			for (int i = 1; i <= 5; i++) {
				if (socket[i] > 0) {
					sum += use[socket[i] - 1];
				}
				if (socket[i] == -1) {
					sum += k;
				}
			}

			use[socket[0] - 1] = sum;

			while (true) {

				if (limits[socket[0] - 1] >= use[socket[0] - 1])
					break;

				boolean flag = true;

				for (int i = 1; i <= 5; i++) {
					if (socket[i] == -1) {
						use[socket[0] - 1] -= k;
						socket[i] = 0;
						answer++;
						flag = false;
						break;
					}
				}

				if (flag) {
					answer++;
					use[socket[0] - 1] -= k;
				}
			}

		}

		return answer;
	}

}
