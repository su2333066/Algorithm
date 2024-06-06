package 프로그래머스.Level1;

import java.io.*;
import java.util.*;

public class 폰켓몬 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 3 }));
	}

	public static int solution(int[] nums) {

		int ans = 0;
		int cnt = nums.length / 2;

		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			set.add(n);
		}

		if (cnt >= set.size())
			ans = set.size();
		else
			ans = cnt;

		return ans;

	}

}
