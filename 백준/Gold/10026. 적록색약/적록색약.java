import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[][] colors;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		colors = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String string = br.readLine();
			for (int j = 0; j < N; j++) {
				colors[i][j] = string.charAt(j);
			}
		}

		int colorCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfsColor(i, j, colors[i][j]);
					colorCount++;
				}
			}
		}

		visited = new boolean[N][N];
		int colorBlindnessCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfsColorBlindness(i, j, colors[i][j]);
					colorBlindnessCount++;
				}
			}
		}

		System.out.print(colorCount + " ");
		System.out.println(colorBlindnessCount);
	}

	public static void dfsColor(int x, int y, char color) {

		visited[x][y] = true;
		// 상하좌우 방향 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 밖으로 안 벗어나는지 확인
			if (check(nx, ny) && !visited[nx][ny] && colors[nx][ny] == color) {
				dfsColor(nx, ny, colors[nx][ny]);
			}
		}
	}

	// 적록색약 : 빨간색과 초록색의 차이를 거의 느끼지 못한다.
	public static void dfsColorBlindness(int x, int y, char color) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 밖으로 안 벗어나는지 확인
			if (!check(nx, ny) || visited[nx][ny])
				continue;
			// 만약 이전과 색깔이 일치하다면 방문 처리한 후 다음 호출
			if (color == 'B') {
				if (colors[nx][ny] == 'B') {
					dfsColorBlindness(nx, ny, colors[nx][ny]);
				}
			} else {
				if (colors[nx][ny] == 'R' || colors[nx][ny] == 'G') {
					dfsColorBlindness(nx, ny, colors[nx][ny]);
				}
			}

		}
	}

	public static boolean check(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
			return true;
		}
		return false;
	}
}