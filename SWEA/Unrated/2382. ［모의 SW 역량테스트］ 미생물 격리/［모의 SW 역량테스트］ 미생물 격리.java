import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static class Microorganism {
		int row, col, number, direction;

		public Microorganism(int row, int col, int number, int direction) {
			this.row = row;
			this.col = col;
			this.number = number;
			this.direction = direction;
		}
	}

	static int N, M, K;
	static int[] dx = { 0, -1, 1, 0, 0 }; // 1: 상, 2: 하, 3: 좌, 4: 우
	static int[] dy = { 0, 0, 0, -1, 1 };
	static List<Microorganism> organisms;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			organisms = new ArrayList<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				organisms.add(new Microorganism(x, y, count, dir));
			}

			for (int time = 0; time < M; time++) {
				moveAndMerge();
			}

			int total = 0;
			for (Microorganism m : organisms) {
				total += m.number;
			}

			sb.append("#").append(test_case).append(" ").append(total).append("\n");
		}

		System.out.println(sb);
	}

	static void moveAndMerge() {
		Map<String, List<Microorganism>> map = new HashMap<>();

		// 1. 이동
		for (Microorganism m : organisms) {
			m.row += dx[m.direction];
			m.col += dy[m.direction];

			// 2. 약품 셀일 경우
			if (m.row == 0 || m.row == N - 1 || m.col == 0 || m.col == N - 1) {
				m.number /= 2;
				m.direction = changeDirection(m.direction);
			}

			String key = m.row + "," + m.col;
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(m);
		}

		// 3. 병합 및 0제거
		List<Microorganism> next = new ArrayList<>();
		for (List<Microorganism> group : map.values()) {
			if (group.size() == 1) {
				if (group.get(0).number > 0)
					next.add(group.get(0));
			} else {
				int total = 0;
				int max = -1;
				int dir = 0;
				for (Microorganism m : group) {
					total += m.number;
					if (m.number > max) {
						max = m.number;
						dir = m.direction;
					}
				}
				if (total > 0)
					next.add(new Microorganism(group.get(0).row, group.get(0).col, total, dir));
			}
		}

		organisms = next;
	}

	static int changeDirection(int direction) {
		switch (direction) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return 0;
	}
}
