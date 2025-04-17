import java.io.*;
import java.util.*;

public class Solution {
	static Queue<String> queue1;
	static Queue<String> queue2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			queue1 = new ArrayDeque<>();
			queue2 = new ArrayDeque<>();

			if (N % 2 == 0) {
				for (int i = 0; i < N / 2; i++) {
					queue1.offer(st.nextToken());
				}
				for (int i = 0; i < N / 2; i++) {
					queue2.offer(st.nextToken());
				}
			} else {
				for (int i = 0; i < N / 2 + 1; i++) {
					queue1.offer(st.nextToken());
				}
				for (int i = 0; i < N / 2; i++) {
					queue2.offer(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				if (!queue1.isEmpty()) {
					result.append(queue1.poll() + " ");
				}

				if (!queue2.isEmpty()) {
					result.append(queue2.poll() + " ");
				}
			}
			sb.append("#" + test_case + " " + result + "\n");
			result = new StringBuilder();
		}
		System.out.println(sb);
	}
}