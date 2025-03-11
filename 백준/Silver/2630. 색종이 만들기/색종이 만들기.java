import java.io.*;
import java.util.*;

public class Main {
	private static int[][] papers;
	private static int white;
	private static int blue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		papers = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void cut(int x, int y, int size) {

		int sum = 0;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				sum += papers[i][j];
			}
		}

		if (sum == 0) {
			white++;
		} else if (sum == size * size) {
			blue++;
		} else {
			int paperSize = size / 2;

			cut(x, y, paperSize); // 좌상
			cut(x, y + paperSize, paperSize); // 우상
			cut(x + paperSize, y, paperSize); // 좌하
			cut(x + paperSize, y + paperSize, paperSize); // 우하
		}
	}
}