import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int R, C;
	static int count;
	static int max;

	public static void main(String[] args) throws Exception {
		// 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선
		// 파이프라인의 최대 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) == 'x') {
					visited[i][j] = true;
				}
			}
		}

		count = 0;
		for (int i = 0; i < R; i++) {
			if (countPipe(i, 0)) {
				count++;
			}
		}
		System.out.println(count);

	}

	// 오른쪽 위 대각선, 오른쪽 아래 대각선, 오른쪽으로 갈 수 있는지 없는지!
	public static boolean can_go(int nx, int ny) {
		if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
			return true;
		}
		return false;
	}

	// pipe 최대 개수 세기
	public static boolean countPipe(int i, int j) {
		visited[i][j] = true;
	
		if (j == C - 1) {
			return true;
		}

		for (int k = 0; k < 3; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (can_go(ni, nj) && !visited[ni][nj]) {
				if (countPipe(ni, nj))
					return true;
			}
		}

		return false;
	}
}