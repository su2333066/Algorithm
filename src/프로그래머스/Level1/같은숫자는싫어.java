package 프로그래머스.Level1;

import java.util.Stack;

public class 같은숫자는싫어 {

	public int[] solution(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		stack.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (stack.peek() == arr[i]) {
				continue;
			}
			stack.add(arr[i]);
		}

		int[] answer = new int[stack.size()];

		for (int i = 0; i < stack.size(); i++) {
			answer[i] = stack.get(i);
		}

		return answer;
	}

}
