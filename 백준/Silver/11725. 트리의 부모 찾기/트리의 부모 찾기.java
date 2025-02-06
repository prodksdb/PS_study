import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean [] visited;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());

		//그래프 초기화
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		//그래프 입력 받기
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		//크기가 N+1인 boolean 배열을 생성
		//모든 값이 기본적으로 false로 초기화됨
		visited = new boolean[N+1];
		
		//부모 배열 초기화
		parent = new int[N+1];

		bfs(1);
		
		for(int i = 2; i <= N; i++) {
			bw.write(parent[i]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();


	}

//	static void dfs(int node) {
//		visited[node] = true;
//
//		for(int next : graph.get(node)) {
//			if(!visited[next])
//				dfs(next);
//		}
//	}

	static void bfs(int start) {
		visited[start] = true;
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int node = queue.poll();

			for(int next : graph.get(node)) {
				if(!visited[next]) {
					queue.add(next);
					parent[next] = node;
					visited[next] = true;
				}
			}

		}
	}
}
