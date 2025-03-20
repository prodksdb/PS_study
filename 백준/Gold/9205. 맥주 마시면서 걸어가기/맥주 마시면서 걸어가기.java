import java.io.*;
import java.util.*;

public class Main {
	static class Location {
		int x, y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// 두 위치 사이의 맨해튼 거리 계산
		public int distanceTo(Location other) {
			return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= t; test_case++) { 
			int n = Integer.parseInt(br.readLine());
			int totalLocations = n + 2; // 집, 편의점들, 그리고 페스티벌
			Location[] locs = new Location[totalLocations];

			for (int i = 0; i < totalLocations; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				locs[i] = new Location(x, y);
			}

			// BFS에서 각 위치(집, 편의점, 페스티벌)의 방문 여부를 확인
			boolean[] visited = new boolean[totalLocations];
			Queue<Integer> q = new LinkedList<>();
			q.offer(0); // 시작점: 집
			visited[0] = true;
			boolean reachable = false;

			while (!q.isEmpty()) {
				int curr = q.poll();
				// 현재 위치에서 페스티벌까지 도달 가능한지 체크 (최대 1000m 이동 가능)
				if (locs[curr].distanceTo(locs[totalLocations - 1]) <= 1000) {
					reachable = true;
					break;
				}
				// 아직 방문하지 않은 편의점(혹은 페스티벌 포함) 탐색
				for (int i = 1; i < totalLocations; i++) {
					if (!visited[i] && locs[curr].distanceTo(locs[i]) <= 1000) {
						visited[i] = true;
						q.offer(i);
					}
				}
			}

			sb.append(reachable ? "happy" : "sad").append("\n");
		}
		System.out.print(sb);
	}
}