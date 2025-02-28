import java.io.*;
import java.util.*;

public class Main {

	static int N, M; // 미로의 크기
	static int[][] maze, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer ts = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(ts.nextToken());
			}
		}

		dp[0][0] = maze[0][0];
		// DP
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if( i > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+ maze[i][j]);
				if( j > 0) dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+ maze[i][j]);
				if( i > 0 && j > 0 ) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+ maze[i][j]);

			}
		}

		int result = dp[N-1][M-1];
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}