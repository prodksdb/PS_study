import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[][] board;
	static int N;
	static int M;

	// 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	// 흑돌 black 백돌 white
	static int black;
	static int white;

	public static void makeboard(int boardsize) {
		if (boardsize == 4) {
			board = new int[][] { { 0, 0, 0, 0 }, { 0, 2, 1, 0 }, { 0, 1, 2, 0 }, { 0, 0, 0, 0 } };
		}
		if (boardsize == 6) {
			board = new int[][] { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 2, 1, 0, 0 },
					{ 0, 0, 1, 2, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		}
		if (boardsize == 8) {
			board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 2, 1, 0, 0, 0 }, { 0, 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
		}
	}

	static boolean isWall(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) return true;
		return false;
	}

	static boolean isFoundmydol(int x, int y, int dir, int dol) {
		int newX = x + dx[dir];
		int newY = y + dy[dir];

		while (true) {
			if (isWall(newX, newY)) return false;
			if (board[newX][newY] == 0) return false;
			if (board[newX][newY] == dol) return true;

			newX += dx[dir];
			newY += dy[dir];
		}
	}

	public static void updateboard(int x, int y, int dol) {
		for (int i = 0; i < 8; i++) {

			if (!isFoundmydol(x, y, i, dol))
				continue;
			int newX = x + dx[i];
			int newY = y + dy[i];

			while (board[newX][newY] != dol) {
				board[newX][newY] = dol;
				newX += dx[i];
				newY += dy[i];
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().trim().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			makeboard(N);

			for (int i = 0; i < M; i++) {
				String[] input1 = br.readLine().trim().split(" ");
				int x = Integer.parseInt(input1[0]);
				int y = Integer.parseInt(input1[1]);
				int dol = Integer.parseInt(input1[2]);
				board[x - 1][y - 1] = dol;
				updateboard(x - 1, y - 1, dol);
			}
			
			black = 0;
			white = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == 1) black++;
					if(board[i][j] == 2) white++;
				}
			}

			System.out.println("#" + test_case + " " + black + " " + white);

		}
		br.close();
	}

}
