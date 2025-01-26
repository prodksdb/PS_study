import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] Input = br.readLine().trim().split(" ");
		int N = Integer.parseInt(Input[0]);
		int M = Integer.parseInt(Input[1]);
		
		String [] Input2 = br.readLine().trim().split(" ");
		int [] Card = new int[N];
		
		for(int i = 0; i < N; i++) {
			Card[i] = Integer.parseInt(Input2[i]);
		}
		
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j< N; j++) {
				for(int k = j+1; k < N; k++) {
					int sum = Card[i]+ Card[j]+Card[k];
					if(sum <= M) {
						result = Math.max(sum, result);
				}
			}
		}
		}
		
		bw.write(String.valueOf(result));
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();
		
	}
}
