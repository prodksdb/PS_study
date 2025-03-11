import java.io.*;
import java.util.*;

public class Solution {
	static int[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			sb.append("#" + test_case + " ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			tree = new int[N];
			int highTree = 0;
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				highTree = Math.max(tree[i], highTree);
			}

			int odd = 0, even = 0;
			for (int i = 0; i < N; i++) {
				int diff = highTree - tree[i];
				odd += diff % 2;
				even += diff / 2;
			}

			int result = odd + even;
			if (odd < even) {
				int gap = (even - odd) * 2;
				int remain = (gap / 3) * 2;

				if (gap % 3 == 2) {
					remain += 2;
				} else if (gap % 3 == 1)
					remain += 1;
				result = 2 * odd + remain;
			} else if (odd - even > 1) {
				result += odd - even - 1;
			}

			sb.append(result + "\n");

		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}