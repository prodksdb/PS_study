import java.io.*;
import java.util.*;

public class Main {
	static int[] weights;
	static int[] values;
	static int N, K;
	static int maxValue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물품의 수
		K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

		weights = new int[N];
		values = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			weights[i] = W;
			values[i] = V;
		}
		int[] dp = new int[K + 1];
		// 0부터 K까지, 각 무게 한도별 최대 가치 저장
		for (int i = 0; i < N; i++) {
			for (int w = K; w >= weights[i]; w--) {
				//선택하지 않을 경우 dp[w] 값 그대로 유지, 선택할 경우 남은 무게에서 가능한 최대 가치 + 현재 물품의 가치 
				dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
			}
		}

		System.out.println(dp[K]);  //최대 가치는 dp[K]에 저장됨 
	}

}