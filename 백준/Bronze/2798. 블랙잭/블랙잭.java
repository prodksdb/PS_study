import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().trim().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] arr = new int[N];
		String[] input2 = br.readLine().trim().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input2[i]);
		}

		Arrays.sort(arr);

		int closetSum = 0;

		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;
			while (left < right) {
				int currentSum = arr[i] + arr[left] + arr[right];

				if (currentSum <= M) {
					closetSum = Math.max(closetSum, currentSum);
					left++;
					;
				} else {
					right--;
				}

			}
		}

		bw.write(String.valueOf(closetSum));
		bw.flush();
		br.close();
		bw.close();
	}

}
