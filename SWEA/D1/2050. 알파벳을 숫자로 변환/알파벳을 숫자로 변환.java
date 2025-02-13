import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st = br.readLine();
	
		for(char c: st.toCharArray()) {
			int number = c - 64;
			bw.write(number+" ");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
