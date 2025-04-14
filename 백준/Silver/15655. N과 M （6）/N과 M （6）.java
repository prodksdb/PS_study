import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int count;
	static int[] numbers;
	static int[] results;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		results = new int[M];
		visited = new boolean[N];
		Combination(0, 0);

		System.out.println(sb);

	}

	public static void Combination(int count, int start) {

		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(results[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {

			results[count] = numbers[i];
			Combination(count + 1, i + 1);
		}
	}
}