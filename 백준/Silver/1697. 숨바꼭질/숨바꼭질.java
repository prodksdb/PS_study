import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int depth; // depth = second

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		depth = 0;

		int result = bfs(N);

		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];

		queue.offer(start);
		visited[start] = true;
		depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if (current == K) {
					return depth;
				}

				for (int next : new int[] { current - 1, current + 1, 2 * current }) {
					if (next >= 0 && next <= 100000 && !visited[next]) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
			depth++;
		}
		return -1;

	}
}