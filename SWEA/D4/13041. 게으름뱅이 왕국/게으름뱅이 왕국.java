import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
	static int N, K, job[][], check[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			job = new int[N + 1][2];
			check = new int[K + 1];
			int count = K;
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i < N + 1; i++) {
				job[i][0] = Integer.parseInt(st.nextToken());
				check[job[i][0]]++;
				if (check[job[i][0]] == 1) {
					count--;
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				job[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(job, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}

			});
			long result = 0;
			for (int i = 1; i < N + 1; i++) {
				if (check[job[i][0]] > 1 && count != 0) {
					result += job[i][1];
					check[job[i][0]]--;
					count--;
				}
			}
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}
}