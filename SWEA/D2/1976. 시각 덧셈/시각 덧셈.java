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
			String [] line = br.readLine().trim().split(" ");
			int hour = Integer.parseInt(line[0]) + Integer.parseInt(line[2]);
			int minute = Integer.parseInt(line[1]) + Integer.parseInt(line[3]);
			
			if(minute > 60) {
				minute = minute - 60;
				hour = hour + 1;
			}
			
			if(hour > 12) {
				hour = hour - 12;
			}
			
			bw.write("#" + test_case + " " + hour + " " + minute);
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();

		
		}

}