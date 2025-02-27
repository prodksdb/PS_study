import java.io.*;
import java.util.*;

public class Solution {

	// 도착 정점, 비용, 다음 노드를 저장하는 그래프 설계도
	private static class Node implements Comparable<Node> {
		public int vertex; // 목적지
		public long weight; // 비용(weight)

		public Node(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		// 오름차순
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	private static int V; // 정점의 개수
	private static int E; // 간선의 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String[] input = br.readLine().trim().split(" ");
			V = Integer.parseInt(input[0]); // 정점의 개수
			E = Integer.parseInt(input[1]); // 간선의 개수
			
			
			//정점 i와 연결된 노드들의 리스트 저장, 배열 안에 리스트 저장 
			//노드 리스트를 저장하는 배열 생성 
			List<Node> [] adjList = new ArrayList[V+1];
			for(int i = 1; i <=V; i++) {
				// 빈 리스트로 초기화 
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()); // A 시작 정점
				int end = Integer.parseInt(st.nextToken()); // B 끝 정점
				int weight = Integer.parseInt(st.nextToken()); // C 가중치 비용
				
				// 양방향이므로 A에서 B로 가는 길과 B에서 A로 가는 길을 둘 다 저장!
				// new Node : 새로운 Node 객체를 만들어서 리스트에 추가하기 위함!
				adjList[start].add(new Node(end, weight));
				adjList[end].add(new Node(start, weight));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue <>();
			boolean [] visited = new boolean[V+1];

			pq.offer(new Node(1,0));
			
			long result = 0L; 
			int count = 0;
			
			while(!pq.isEmpty()) {
				//최소 비용 정점 선택
				Node current = pq.poll(); 
				
				if(visited[current.vertex]) continue; //이미 선택된 정점이면 스킵
				visited[current.vertex] = true;
				result += current.weight;
				if(++count == V) break; //모든 정점을 연결했으면 종료
				
				//연결된 간선 탐색 후 우선순위 큐에 추가 
				for(Node next : adjList[current.vertex]) {
					if(!visited[next.vertex]) {
						pq.offer(new Node(next.vertex, next.weight)); //새로운 객체로 추가 
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb.toString());
	}

}