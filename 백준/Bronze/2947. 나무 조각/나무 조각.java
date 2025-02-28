import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] number = new int[5];
		for (int i = 0; i < 5; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		int[] target = { 1, 2, 3, 4, 5 };
		while (!Arrays.equals(number, target)) {
			for (int i = 1; i < 5; i++) {
				if (number[i] < number[i - 1]) {
					int temp = number[i - 1];
					number[i - 1] = number[i];
					number[i] = temp;
				} else {
					continue;
				}

				for (int j = 0; j < 5; j++) {
					sb.append(number[j] + " ");
				}
				sb.append("\n");

			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}