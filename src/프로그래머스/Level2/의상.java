package 프로그래머스.Level2;

import java.util.*;

public class 의상 {

	public int solution(String[][] clothes) {
		int answer = 1;

		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			if (!map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], new ArrayList<>());
			}

			map.get(clothes[i][1]).add(clothes[i][0]);
		}

		for (String key : map.keySet()) {
			answer *= map.get(key).size() + 1;
		}

		return answer - 1;
	}

}
