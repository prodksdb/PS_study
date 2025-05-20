import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	// 간선 class
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		// 가중치 오름차순
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static Edge[] edgeList;
	static int[] parents;
	static int V, E;

	static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a; // 자기 자신이 루트인 경우
		return parents[a] = find(parents[a]); // 루트 찾아 경로 압축
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			parents = new int[V];
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(from - 1, to - 1, weight);
			}

			make(); // union-find 초기화

			Arrays.sort(edgeList); // 간선을 가중치 오름차순 정렬

			long result = 0; // 최종 비용
			int count = 0; // 선택된 간선 수

			// 가중치가 낮은 간선부터 순서대로 시도
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					count++;
					if (count == V - 1)
						break;
				}
			}

			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}
}