package 프로그래머스.Level3;

import java.util.*;

public class 베스트앨범 {

	static class Music implements Comparable<Music> {
		int idx, playCnt;

		public Music(int idx, int playCnt) {
			super();
			this.idx = idx;
			this.playCnt = playCnt;
		}

		public int getPlayCnt() {
			return playCnt;
		}

		@Override
		public int compareTo(Music o) {
			return Integer.compare(o.playCnt, playCnt);
		}

	}

	public int[] solution(String[] genres, int[] plays) {
		Map<String, List<Music>> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (!map.containsKey(genres[i])) {
				map.put(genres[i], new ArrayList<>());
			}

			map.get(genres[i]).add(new Music(i, plays[i]));
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		List<String> keySet = new ArrayList<>(map.keySet());

		keySet.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(map.get(o2).stream().mapToInt(Music::getPlayCnt).sum(),
						map.get(o1).stream().mapToInt(Music::getPlayCnt).sum());
			}
		});

		List<Integer> list = new ArrayList<>();

		for (String key : keySet) {
			if (map.get(key).size() < 2) {
				for (Music m : map.get(key)) {
					list.add(m.idx);
				}
			} else {
				for (int i = 0; i < 2; i++) {
					list.add(map.get(key).get(i).idx);
				}
			}
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
