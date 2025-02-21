import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int [] height = new int [N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int up = 0;
			int down = 0;
			for(int i = 0; i < N-1; i++) {
				if(height[i] < height[i+1]) {
					up = Math.max(up,  height[i+1]-height[i]);
				}else if(height[i] > height[i+1]) {
					down = Math.max(down,  height[i] - height[i+1]);
				}
			}
			sb.append("#" + test_case + " "+up+" "+down+"\n");
		}

		System.out.println(sb);
		br.close();
	}

}