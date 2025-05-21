import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution {

	static int N;
	static int[][] map;
	static int[][] cost;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cost;

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cost[i][j] = Integer.MAX_VALUE;
				}
			}

			int result = bfs();
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}

	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, map[0][0]));
		cost[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Point current = pq.poll();
			int cx = current.x;
			int cy = current.y;
			int cc = current.cost;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				if (cost[nx][ny] > cost[cx][cy] + map[nx][ny]) {
					cost[nx][ny] = cost[cx][cy] + map[nx][ny];
					pq.add(new Point(nx, ny, cost[nx][ny]));
				}
			}
		}
		return cost[N-1][N-1];
	}
}