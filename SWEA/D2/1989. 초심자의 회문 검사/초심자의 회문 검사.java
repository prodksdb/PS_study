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
			String N = br.readLine();
			int size = N.length()/2;
			int a = 0;
			char [] N_String = N.toCharArray();
			char [] M_String = new char[size];
			for(int i = 0; i < size; i++) {
				M_String[i] = N_String[i];
			}
			if( N.length() % 2 == 0) {
				a = size;
			}else {
				a = size+1;
			}
			
			int count = 0;
			
			for(int i = a; i < N.length(); i++) {
				for(int j = size-1; j >= 0; j--) {
					if(M_String[j] == N_String[i]) {
						count++;
					}
				}
			}
			
			bw.write("#"+test_case+" ");
			if(count == size) {
				bw.write(String.valueOf(1));
			}else {
				bw.write(String.valueOf(0));
			}
			
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

}
