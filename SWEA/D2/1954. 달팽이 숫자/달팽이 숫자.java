import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= N; test_case++) {
      int M = Integer.parseInt(br.readLine());

      // M*M 배열 생성
      int[][] grid = new int[M][M];
      int num = 1; // 채울 숫자
      int x = 0, y = 0; // 현재 위치
      int direction = 0; // 방향( 오른쪽, 아래, 왼쪽, 위)
      int[] dx = { 0, 1, 0, -1 }; // X축 이동
      int[] dy = { 1, 0, -1, 0 }; // Y축 이동

      while (num <= M * M) {
        grid[x][y] = num++; // 현재 위치에 숫자 채우기!
        int nx = x + dx[direction]; // 다음 x 위치
        int ny = y + dy[direction]; // 다음 y 위치

        // 방향 전환 조건
        if (nx < 0 || nx >= M || ny < 0 || ny >= M || grid[nx][ny] != 0) {
          direction = (direction + 1) % 4;
          nx = x + dx[direction];
          ny = y + dy[direction];
        }

        x = nx;
        y = ny;

      }
      bw.write("#" + String.valueOf(test_case));
      bw.newLine();
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < M; j++) {
          bw.write(String.valueOf(grid[i][j]) + " ");
        }
        bw.newLine();
      }
    }

    bw.flush();
    br.close();
    bw.close();

  }
}
