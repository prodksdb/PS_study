import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int [][] dp = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				dp[i][0] = 1;
				dp[i][i] = 1;
				for(int j = 1; j < i; j++ ) {
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				}
			}
			
			bw.write("#"+test_case);
			bw.newLine();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					bw.write(String.valueOf(dp[i][j])+" ");
				}
				bw.newLine();
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

}