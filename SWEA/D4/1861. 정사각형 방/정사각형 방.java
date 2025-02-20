import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] room;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int total, count, start;

	public static void move(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isWall(nx, ny))
				continue;
			if (room[nx][ny] == room[x][y] + 1) {
				count++;
				move(nx, ny);
			}
		}
	}

	public static boolean isWall(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= N)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			total = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int a = room[i][j];
					count = 1;
					move(i, j);
					if( total  < count) {
						total = count;
						start = a;
					}else if(total == count) {
						start = Math.min(start, a);
					}
				}
			}

			sb.append("#" + test_case + " " + start + " " + total + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}