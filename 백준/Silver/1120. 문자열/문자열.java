import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().trim().split(" ");

		String A = input[0];
		String B = input[1];
		StringBuilder sb = new StringBuilder(A);

		int minDifference = Integer.MAX_VALUE; //최소 차이 초기화 

		for(int i = 0; i<= B.length()-A.length(); i++) {
			int difference = 0;

			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j)!= B.charAt(i+j)) {
					difference++;
				}
			}
			minDifference = Math.min(minDifference, difference);
		}

		bw.write(String.valueOf(minDifference));

		bw.flush();
		br.close();
		bw.close();
	}

}
