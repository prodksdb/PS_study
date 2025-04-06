import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean check(String str) {
		boolean checking [] = new boolean[26];
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);
			int prev = (i > 0) ? str.charAt(i-1) : 0 ;
			if(checking[now-'a'] == false)
				checking[now-'a'] = true;
			else if( now != prev)
				return false;
		}
		return true;
		}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if(check(input)) {
				count++;
			}
		}

		bw.write(count+"");
		bw.flush();
		br.close();
		bw.close();
	}
}