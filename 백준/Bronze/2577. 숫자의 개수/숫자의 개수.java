import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int result = A * B * C;
		
		int [] count = new int[10];
		
		while(result > 0) {
			int index = result % 10 ;
			count[index]++;
			result /= 10;
		}
		for(int i = 0; i < 10; i++) {
			sb.append(count[i]+"\n");
		}
		
		bw.write(sb+"");
		bw.flush();
		br.close();
		bw.close();
	}

}