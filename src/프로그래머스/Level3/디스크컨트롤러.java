package 프로그래머스.Level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
	}

	public static int solution(int[][] jobs) {

		int answer = 0;
		int time = 0;
		int idx = 0;
		int len = jobs.length;

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		while (!pq.isEmpty() || idx < len) {

			while (idx < len && jobs[idx][0] <= time) {
				pq.offer(jobs[idx++]);
			}

			if (pq.isEmpty()) {
				time = jobs[idx][0];
			} else {
				int[] job = pq.poll();
				time += job[1];
				answer += time - job[0];
			}

		}

		return answer / len;

	}

}
