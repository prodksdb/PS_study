import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if( A == 1 && B ==3) {
			sb.append("A");
		}else if( A == 3 && B == 1) {
			sb.append("B");
		}else {
			if(A > B) {
				sb.append("A");
			}else {
				sb.append("B");
			}
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}