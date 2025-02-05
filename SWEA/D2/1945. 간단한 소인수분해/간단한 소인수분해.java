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
			int N = Integer.parseInt(br.readLine().trim());
			int countA = 0;
			int countB = 0;
			int countC = 0;
			int countD = 0;
			int countE = 0;
			while(N % 2 == 0) {
				N = N / 2;
				countA++;
			}
			
			while(N % 3 == 0) {
				N = N / 3;
				countB++;
			}
			
			while(N % 5 == 0) {
				N = N / 5;
				countC++;
			}
			
			while(N % 7 == 0) {
				N = N / 7;
				countD++;
			}
			
			while(N % 11 == 0) {
				N = N / 11;
				countE++;
			}
			
			bw.write("#" + test_case + " " + countA + " " + countB + " " + countC + " " + countD + " " + countE);
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();

		
		}

}