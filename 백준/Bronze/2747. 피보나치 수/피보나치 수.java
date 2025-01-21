import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());

		int [] F = new int[n+1];

		F[0] = 0;
		F[1] = 1;
		
		for(int i = 2; i < n+1; i++ ) {
			F[i] = F[i-2]+F[i-1];
		}

		bw.write(String.valueOf(F[n]));

		bw.flush();
		br.close();
		bw.close();
	}
}