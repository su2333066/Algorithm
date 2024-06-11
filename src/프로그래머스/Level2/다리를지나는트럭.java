package 프로그래머스.Level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		System.out.println(solution(100, 100, new int[] { 10 }));
	}

	static class Truck {
		int point, weight;

		public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			this.point = point;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Truck(int point, int weight) {
			super();
			this.point = point;
			this.weight = weight;
		}
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int idx = 0;

		Queue<Truck> q = new ArrayDeque<>();
		q.offer(new Truck(++time, truck_weights[idx++]));

		while (!q.isEmpty()) {

			for (Truck truck : q) {
				truck.setPoint(truck.getPoint() + 1);
			}

			if (q.peek().getPoint() > bridge_length)
				q.poll();

			if (idx < truck_weights.length) {
				int sum = 0;

				for (Truck truck : q) {
					sum += truck.getWeight();
				}

				if (sum + truck_weights[idx] <= weight) {
					q.offer(new Truck(1, truck_weights[idx++]));
				}
			}

			time++;

		}

		return time;
	}

}
