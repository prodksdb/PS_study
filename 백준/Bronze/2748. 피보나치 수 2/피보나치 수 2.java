import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());

		long [] F = new long[n+1];

		F[0] = 0;
		F[1] = 1;
		int i = 2;

		while(i <= n) {
			F[i] = F[i-2] + F[i-1];
			i++;
		}

		bw.write(String.valueOf(F[n]));

		bw.flush();
		br.close();
		bw.close();

	}
}
