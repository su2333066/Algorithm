package 프로그래머스.Level2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));
	}

	static class Stock {
		int time, upTime, price;

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getUpTime() {
			return upTime;
		}

		public void setUpTime(int upTime) {
			this.upTime = upTime;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Stock(int time, int upTime, int price) {
			super();
			this.time = time;
			this.upTime = upTime;
			this.price = price;
		}

	}

	public static int[] solution(int[] prices) {

		int[] answer = new int[prices.length];

		int idx = 0;

		Stack<Stock> stack = new Stack<>();
		stack.add(new Stock(idx, 0, prices[idx++]));

		while (!stack.isEmpty()) {

			if (idx >= prices.length) {

				Stock stock = stack.pop();
				answer[stock.getTime()] = stock.getUpTime();

			} else {

				while (!stack.isEmpty() && stack.peek().getPrice() > prices[idx]) {
					Stock stock = stack.pop();
					answer[stock.getTime()] = stock.getUpTime() + 1;
				}

				for (Stock stock : stack) {
					stock.setUpTime(stock.getUpTime() + 1);
				}

				stack.add(new Stock(idx, 0, prices[idx++]));

			}

		}

		return answer;

	}

}
