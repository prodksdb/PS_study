import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int R, C, result = 0; // R = row, C = column
	static char[][] alphabet; // alphabet 배열
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	static int count; // 지날 수 있는 칸의 수
	static boolean[] visited = new boolean[26]; // A~Z 방문 여부(A : 0 , Z : 25)

	// isWall : 범위 밖인지 안인지 확인하기
	public static boolean isWall(int nx, int ny) {
		if (nx < 0 || nx >= R || ny < 0 || ny >= C)
			return true;
		return false;
	}

	// 최대 칸 수 계산하기
	public static void go(int x, int y, int count) {
		
		result = Math.max(result,  count);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isWall(nx, ny))
				continue;

			int index = alphabet[nx][ny] - 'A';  //해당 칸의 알파벳 인덱스
			if (!visited[index]) {          
				visited[index] = true;
				go(nx, ny, count+1);
				visited[index] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alphabet = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				alphabet[i][j] = input.charAt(j);
			}
		}
		
		//시작점 방문처리
		visited[alphabet[0][0] - 'A'] = true;
		go(0, 0, 1);

		bw.write(result + " ");
		bw.flush();
		br.close();
		bw.close();
	}
}