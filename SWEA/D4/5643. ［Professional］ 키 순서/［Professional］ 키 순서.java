import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int M;
	static int[][] students;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			students = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				students[a][b] = 1;
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (students[i][k] == 1 && students[k][j] == 1) {
							students[i][j] = 1;
						}
					}
				}
			}

			int result = 0;
			for (int i = 1; i <= N; i++) {
				int count = 0;
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					if (students[i][j] == 1 || students[j][i] == 1) {
						count++;
					}
				}
				if (count == N - 1) {
					result++;
				}
			}

			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}
}