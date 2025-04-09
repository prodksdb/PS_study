import java.io.*;
import java.util.*;

public class Main {

	private static int N, M;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];

		// 1부터 N까지 M개 고르기 같은 수 여러번 골라도 된다.
		// 사전 순으로 증가하는 순서로 출력
		Permutation(0);
		System.out.println(sb);

	}

	static void Permutation(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			numbers[count] = i;
			Permutation(count + 1);
		}

	}

}