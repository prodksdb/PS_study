import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++) {
			String [] input = br.readLine().trim().split(" ");
			int fm = Integer.parseInt(input[0]);
			int fd = Integer.parseInt(input[1]);
			int sm = Integer.parseInt(input[2]);
			int sd = Integer.parseInt(input[3]);
			
			int [] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int result = lastDay[fm-1]-fd + 1 + sd;
			if(fm == sm) {
				result = sd- fd + 1;
			}else {
				for(int i = fm; i < sm-1; i++) {
				result += lastDay[i];
				}
			}
		
			bw.write("#" + test_case + " " + result);
			bw.newLine();
			
		}
		
		bw.flush();
		br.close();
		bw.close();

		
		}

}