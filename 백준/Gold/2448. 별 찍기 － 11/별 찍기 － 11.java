import java.io.*;
import java.util.*;

public class Main {

	public static char[][] stars;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int width = 2 * N - 1;
		stars = new char[N][width];

		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' ');
		}

		star(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(new String(stars[i]) + "\n");
		}
		System.out.println(sb);
	}

	// x, y: 현재 삼각형의 왼쪽 상단 좌표, n: 삼각형의 높이(항상 3×2^k)
	public static void star(int x, int y, int size) {
		if (size == 3) {
			// 기본 삼각형 그리기
			stars[x][y + 2] = '*';
			stars[x + 1][y + 1] = '*';
			stars[x + 1][y + 3] = '*';
			for (int i = 0; i < 5; i++) {
				stars[x + 2][y + i] = '*';
			}
			return;
		}
		int starSize = size / 2;
		// 상단 삼각형(위쪽 중앙)
		star(x, y + starSize, starSize);
		// 좌측 하단 삼각형
		star(x + starSize, y, starSize);
		// 우측 하단 삼각형
		star(x + starSize, y + starSize * 2, starSize);

	}
}