import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int T = Integer.parseInt(br.readLine().trim());
	for(int test_case = 1; test_case <= T; test_case++) {
		String [] input = br.readLine().trim().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		if(a>=1 && a <100 && b >= 1 && b < 1000000) {
			int result = 1;
			for(int i = 0; i < b; i++) {
				result = (result*a) % 10;
			}
			
			if(result == 0) {
				result = 10;
			}
		bw.write(result+"\n");
		}
	}
	bw.flush();
	br.close();
	bw.close();
}
}
