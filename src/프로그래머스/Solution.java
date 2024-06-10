package 프로그래머스;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 40, 20, 30, 20 }, new int[] { 1, 1, 1, 1 })));
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < progresses.length; i++) {
			q.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
		}

		List<Integer> list = new ArrayList<>();

		while (!q.isEmpty()) {
			int cnt = 1;
			int day = q.poll();

			while (!q.isEmpty() && q.peek() <= day) {
				q.poll();
				cnt++;
			}

			list.add(cnt);
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;

	}

}
