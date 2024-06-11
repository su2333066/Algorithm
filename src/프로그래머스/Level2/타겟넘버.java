package 프로그래머스.Level2;

public class 타겟넘버 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	static int answer;

	public static int solution(int[] numbers, int target) {
		answer = 0;

		dfs(0, 0, numbers, target);

		return answer;
	}

	private static void dfs(int cnt, int sum, int[] numbers, int target) {

		if (cnt == numbers.length) {

			if (sum == target) {
				answer++;
			}

			return;
		}

		dfs(cnt + 1, sum + numbers[cnt], numbers, target);
		dfs(cnt + 1, sum - numbers[cnt], numbers, target);

	}

}
