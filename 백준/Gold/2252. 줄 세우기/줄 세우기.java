import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	public static int N, M;
	public static Node[] adjList;
	public static int[] inDegree;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N + 1]; // 정점 번호는 1번부터 시작!
		inDegree = new int[N + 1];
		int from, to;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}

		// 위상정렬 수행
		List<Integer> list = topologySort();

		if (list.size() == N)

		{
			for (Integer vertex : list) {
				sb.append(vertex + " ");
			}
			sb.append("\n");
		} else {
			System.out.println("cycle");
		}
		System.out.println(sb);
	}

	private static List<Integer> topologySort() {
		List<Integer> orderList = new ArrayList<>();

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {

			// 1. 진입 차수가 0인 노드를 큐에 넣는다.
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {

			// 2. 큐에서 진입 차수가 0인 노드를 꺼내서 자신과 인접한 노드의 간선을 제거한다.
			Integer current = queue.poll();
			orderList.add(current);

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {

				// 인접한 노드 진입차수 1 감소
				if (--inDegree[temp.vertex] == 0) {

					// 간선 제거 후 진입차수가 0인 노드를 큐에 넣는다.
					queue.offer(temp.vertex);
				}
			}
		}
		return orderList;
	}

}