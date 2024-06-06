package 백준.실버;

import java.io.*;
import java.util.*;

public class Nx2타일링 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n;
	static int[] memo;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= n; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
		}

		System.out.println(memo[n]);
	}

}
