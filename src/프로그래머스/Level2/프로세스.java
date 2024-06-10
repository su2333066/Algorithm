package 프로그래머스.Level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 프로세스 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
	}

	static class Process {
		int location, priority;

		public Process(int location, int priority) {
			super();
			this.location = location;
			this.priority = priority;
		}

	}

	public static int solution(int[] priorities, int location) {

		Queue<Process> q = new ArrayDeque<>();

		for (int i = 0; i < priorities.length; i++) {
			q.offer(new Process(i, priorities[i]));
		}

		int answer = 1;

		while (true) {
			boolean flag = true;
			Process cur = q.poll();

			for (Process next : q) {
				if (cur.priority < next.priority) {
					q.offer(cur);
					flag = false;
					break;
				}
			}

			if (flag) {
				if (cur.location == location)
					break;
				else {
					answer++;
				}
			}

		}

		return answer;

	}

}
