import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static long answer;
	public static boolean[] selected;
	public static int[][] points;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			points = new int[N][2];
			selected = new boolean[N];
			answer = Long.MAX_VALUE;

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			long dx = 0, dy = 0;

			for (int i = 0; i < N; ++i) {
				if (selected[i]) {
					dx += points[i][0];
					dy += points[i][1];
				} else {
					dx -= points[i][0];
					dy -= points[i][1];
				}
			}

			long vectorSize = dx * dx + dy * dy;
			answer = Math.min(answer, vectorSize);
			return;
		}

		for (int i = start; i < N; ++i) {
			selected[i] = true;
			comb(cnt + 1, i + 1);
			selected[i] = false;
		}
	}
}
