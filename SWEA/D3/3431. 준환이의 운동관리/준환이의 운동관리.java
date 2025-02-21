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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
		
			sb.append("#" + test_case + " ");
			
			if( U < X) {
				sb.append(-1);
			}else if(L > X){
				sb.append(L-X);
			}else {
				sb.append(0);
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}