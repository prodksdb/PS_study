import java.io.*;
import java.util.*;

public class Main {
	static class App {
		int memory, cost;

		public App(int memory, int cost) {
			this.memory = memory;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] memory = new int[N];
		int[] cost = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		App[] apps = new App[N];
		for (int i = 0; i < N; i++) {
			apps[i] = new App(memory[i], cost[i]);
		}
		
		int[] dp = new int[10001];
		dp[0] = 0; // 비용이 0일 때 확보된 메모리는 0

		for (int i = 0; i < N; i++) {
			for (int j = 10000; j >= apps[i].cost; j--) {
				dp[j] = Math.max(dp[j], dp[j - apps[i].cost] + apps[i].memory);
			}
		}

		for (int i = 0; i < 10001; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}

	}
}