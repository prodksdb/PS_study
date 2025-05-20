import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	static int N, M;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 반의 사람 수
			M = Integer.parseInt(st.nextToken()); // 친구 관계 수

			List<Integer>[] list = new ArrayList[N + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}

			// 초대 받을 사람들
			check = new boolean[N + 1];
			check[1] = true;

			dfs(0, 1, list);

			int result = 0;
			for (int i = 2; i < check.length; i++) {
				if (check[i])
					result++;
			}

			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int index, List<Integer>[] list) {
		if (depth == 2) {
			return;
		}

		for (int i = 0; i < list[index].size(); i++) {
			int next = list[index].get(i);
			check[next] = true;
			dfs(depth + 1, next, list);
		}
	}
}