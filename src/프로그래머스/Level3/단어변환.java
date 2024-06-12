package 프로그래머스.Level3;

public class 단어변환 {

	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
	}

	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];

		dfs(0, begin, target, words);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	public static void dfs(int cnt, String begin, String target, String[] words) {
		if (begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i]) {
				continue;
			}

			int diff = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) != words[i].charAt(j)) {
					diff++;
				}
			}

			if (diff == 1) {
				visited[i] = true;
				dfs(cnt + 1, words[i], target, words);
				visited[i] = false;
			}
		}
	}

}
