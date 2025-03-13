import java.io.*;
import java.util.*;

public class Main {

	static int[] chess;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int N;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		count = 0;
		queen(0);
		System.out.println(count);
	}

	public static void queen(int q) {

		// q는 행
		if (q == N) {
			count++;
			return;
		}

		// i는 열
		for (int i = 0; i < N; i++) {
			chess[q] = i; // 행에 해당하는 열
			if (isPromising(q)) { // 이 열에 놓을 수 있는지 확인
				queen(q + 1);
			}
		}
	}

	public static boolean isPromising(int x) {
		// 같은 열이면 안되고, 대각선 상에 있으면 안된다.
		for (int i = 0; i < x; i++) {
			if (chess[x] == chess[i] || x - i == Math.abs(chess[x] - chess[i])) {
				return false;
			}
		}
		return true;
	}

}