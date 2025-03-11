import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		while (true) {
			if (N % 5 == 0) {
				cnt += N / 5;
				break;
			} else {
				if (N < 3) {
					cnt = -1;
					break;
				}
				N -= 3;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}