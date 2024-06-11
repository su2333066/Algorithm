package 프로그래머스.Level2;

public class 피로도 {

	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] { { 80, 20 }, { 50, 40 }, { 30, 10 } }));
	}

	static boolean[] visited;
	static int answer;

	public static int solution(int k, int[][] dungeons) {
		answer = -1;
		visited = new boolean[dungeons.length];

		dfs(0, 0, k, dungeons);

		return answer;
	}

	private static void dfs(int cnt, int clearCnt, int k, int[][] dungeons) {

		if (cnt == dungeons.length) {
			answer = Math.max(answer, clearCnt);
			return;
		}

		for (int i = 0; i < dungeons.length; i++) {
			if (visited[i])
				continue;
			if (dungeons[i][0] <= k) {
				visited[i] = true;
				dfs(cnt + 1, clearCnt + 1, k - dungeons[i][1], dungeons);
				visited[i] = false;
				dfs(cnt + 1, clearCnt, k, dungeons);
			} else {
				dfs(cnt + 1, clearCnt, k, dungeons);
			}
		}

	}

}
