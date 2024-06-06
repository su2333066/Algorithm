package 프로그래머스.Level2;

import java.util.*;

public class 전화번호목록 {

	public static boolean solution(String[] phone_book) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], i);
		}

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				if (map.containsKey(phone_book[i].substring(0, j))) {
					return false;
				}
			}
		}

		return true;
	}

}
