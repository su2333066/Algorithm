package 프로그래머스.Level2;

import java.util.Arrays;

public class 카펫 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(24, 24)));
	}

	public static int[] solution(int brown, int yellow) {

		int[] answer = new int[2];

		for (int col = 3; col < 2500; col++) {
			if ((brown + yellow) % col == 0) {
				int row = (brown + yellow) / col;
				if (col >= row && (col + row - 2) * 2 == brown && (col - 2) * (row - 2) == yellow) {
					answer[0] = col;
					answer[1] = row;
					break;
				}
			}
		}

		return answer;

	}

}
