import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int revenue;
	static int[][] crops;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			crops = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					crops[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
				}
			}

			revenue = 0;
			profit();

			sb.append("#" + test_case + " " + revenue + "\n");
		}
		System.out.println(sb);
	}

	static void profit() {
		for (int i = 0; i < (N - 1) / 2; i++) {
			for (int j = (N - 1) / 2 - i; j <= (N - 1) / 2 + i; j++) {
				revenue += crops[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			revenue += crops[(N - 1) / 2][i];
		}

		for (int i = (N - 1) / 2 + 1; i < N; i++) {
			for (int j = i - ((N - 1) / 2); j <= (3 * (N - 1) / 2) - i; j++) {
				revenue += crops[i][j];
			}
		}
	}
}