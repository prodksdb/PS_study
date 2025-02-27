import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		sb.append(a+b+"\n");
		sb.append(a-b+"\n");
		sb.append(a*b+"\n");
		sb.append(a/b+"\n");
		
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}