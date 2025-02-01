import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String [] input =br.readLine().trim().split(" ");

		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);
		int X = Integer.parseInt(input[3]);
		int Y = Integer.parseInt(input[4]);
		int all,all2 = Y;
		int rest, result, result2 = 0;

		if(X > Y) {
			all = Y;
			rest = A*(X-Y);
			all2 =X;
		}else {
			all = X;
			rest = B*(Y-X);
			all2 = Y;
		}

		if(A+B >= 2*C) {
			result = 2*C*all + rest;
			result2 = 2*C*all2;
			if(result >= result2) {
				result = result2;
			}
		}else {
			result = A*X + B*Y;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
	}

}
