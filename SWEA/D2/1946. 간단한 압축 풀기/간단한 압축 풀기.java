import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine().trim());

			bw.write("#"+test_case);
			bw.newLine();

			int count = 0;
			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String ci = st.nextToken();
				int ki = Integer.parseInt(st.nextToken());

				while(ki > 0) {
					sb.append(ci);
					count++;
					ki--;

					if(count == 10) {
						bw.write(sb.toString());
						bw.newLine();
						//빈 문자열 상태 
						sb.setLength(0);
						count = 0;
					}
				}
			}
			
			if(sb.length() > 0) {
				bw.write(sb.toString());
				bw.newLine();
			}
		}
		bw.flush();
		br.close();
		bw.close();

	}
}
