package 프로그래머스.Level2;

import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	public static int solution(int[] scoville, int K) {

		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : scoville) {
			pq.offer(i);
		}

		while (true) {
			if (pq.peek() >= K) {
				break;
			} else {
				if (pq.size() == 1) {
					answer = -1;
					break;
				}
			}

			int first = pq.poll();
			int second = pq.poll();

			pq.offer(first + second * 2);
			answer++;
		}

		return answer;

	}
	
}
