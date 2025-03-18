import java.io.*;
import java.util.*;

public class Solution {

	static int[] scores;
	static int[] calories;
	static int N, L;
	static int highScore;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			scores = new int[N];
			calories = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			highScore = 0;
			high(0, 0, 0);
			sb.append("#" + test_case + " " + highScore + "\n");
		}
		System.out.println(sb);
	}

	// select : 재료 번호, calorie : 총 칼로리 수
	public static void high(int number, int calorie, int score) {

		if (calorie > L)
			return;
		highScore = Math.max(score, highScore);
		if (number == N)
			return;

		// 지금 재료 안 고를거야
		high(number + 1, calorie, score);

		// 지금 재료 고를거야
		high(number + 1, calorie + calories[number], score + scores[number]);

	}
}