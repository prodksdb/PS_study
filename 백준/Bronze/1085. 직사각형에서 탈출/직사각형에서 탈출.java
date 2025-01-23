import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().trim().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);

		int left = x;
		int right = w-x;
		int bottom = y;
		int top = h-y;

		int minvalue = Math.min(Math.min(left, right), Math.min(bottom, top));

		bw.write(String.valueOf(minvalue));

		bw.flush();
		br.close();
		bw.close();
	}

}
