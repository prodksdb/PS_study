import java.io.*;
import java.util.*;

public class Main {

	static int[][] home;
	static int N;
	static int count;
	static int[] dx = { 0, 1, 1 }; // 오른쪽, 대각선, 아래
	static int[] dy = { 1, 1, 0 }; // 오른쪽, 대각선, 아래

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;
		move(0, 1, 0);
		System.out.println(count);
	}

	static void move(int x, int y, int direction) {

		if (x == N - 1 && y == N - 1) {
			count++;
			return;
		}

		// 가로의 경우
		if (direction == 0) {
			for (int i = 0; i < 2; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (can_go(nx, ny, i)) {
					move(nx, ny, i);
				}
			}
		}
		// 대각선의 경우
		else if (direction == 1) {
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (can_go(nx, ny, i)) {
					move(nx, ny, i);
				}
			}
		}
		// 세로의 경우
		else {
			for (int i = 1; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (can_go(nx, ny, i)) {
					move(nx, ny, i);
				}
			}
		}
	}

	static boolean can_go(int nx, int ny, int direction) {
		if (direction == 1) {
			if (nx >= 1 && ny >= 1 && nx < N && ny < N && home[nx][ny] != 1 && home[nx - 1][ny] != 1
					&& home[nx][ny - 1] != 1) {
				return true;
			}
			return false;
		}

		return nx >= 0 && ny >= 0 && nx < N && ny < N && home[nx][ny] != 1;
	}
}