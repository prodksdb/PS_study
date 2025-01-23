import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] Input = br.readLine().trim().split(" ");
		double A = Integer.parseInt(Input[0]);
		double B = Integer.parseInt(Input[1]);
		
		Double result = A / B ;
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		br.close();
		bw.close();
	}

}
