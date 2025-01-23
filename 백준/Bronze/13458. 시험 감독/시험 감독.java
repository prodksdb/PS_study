import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());

		String[] Input = br.readLine().trim().split(" ");
		int[] A = new int[N];

		String[] Input2 = br.readLine().trim().split(" ");
		int B = Integer.parseInt(Input2[0]);
		int C = Integer.parseInt(Input2[1]);


		long sum = 0; 

		for(int i=0; i< N; i++) {
			A[i] = Integer.parseInt(Input[i]);

			//총감독관 1명 배치 
			sum += 1;
			int count = A[i]-B;

			if(count > 0) {
				sum += count / C;
				if(count % C != 0) {
					sum += 1;
				}
			}
		}	
		bw.write(String.valueOf(sum));

		bw.flush();
		br.close();
		bw.close();
	}


}
