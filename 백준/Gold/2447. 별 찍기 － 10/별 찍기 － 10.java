import java.io.*;
import java.util.*;

public class Main {
	public static String[][] stars;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stars = new String[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stars[i][j] = " ";
			}

		}

		star(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static void star(int x, int y, int size) {
		// x + starSize / 3, y + starSize / 3, starSize
		if (size == 3) {
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (i == x + 1 && j == y + 1) {
						stars[i][j] = " ";
					} else {
						stars[i][j] = "*";
					}
				}
			}
			return;
		} else {
			int starSize = size / 3;

			star(x, y, starSize);
			star(x, y + starSize, starSize);
			star(x, y + starSize * 2, starSize);
			star(x + starSize, y, starSize);
		
			star(x + starSize, y + starSize * 2, starSize);
			star(x + starSize * 2, y, starSize);
			star(x + starSize * 2, y + starSize, starSize);
			star(x + starSize * 2, y + starSize * 2, starSize);

		}
	}

}