import java.io.*;
import java.util.*;

public class Main {
	private static int N; // 사람의 수
	private static int M; // 친구 관계의 수
	private static List<Integer>[] adjList; // 인접리스트
	private static boolean found = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().trim().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int from, to;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, new boolean[N+1], 0);
			if(found) break;
		}
		
		bw.write(found ? "1": "0");
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void dfs(int current, boolean [] visited, int depth) {	
		if(depth >= 4) {
			found = true;
			return;
		}
		
		visited[current] = true;
		for(int next : adjList[current]) {
			if(!visited[next]) {
				dfs(next, visited, depth+1);
				if(found) return; 
			}
		}
		visited[current] = false;	
	}
}