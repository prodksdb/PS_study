import java.io.*;
import java.util.*;

public class Main {
    public static int M, N;
    public static int[][] grid; // 창고 내 토마토 상태: 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 없는 칸

    // 토마토의 위치를 나타내는 클래스
    static class Tomato {
        int x, y;
        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        Queue<Tomato> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }

        // BFS를 통해 모든 토마토가 익는 과정을 시뮬레이션
        bfs(queue);

        // BFS 종료 후, 아직 익지 않은 토마토(0)가 존재하면 -1을 출력
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                // grid에 기록된 숫자는 처음 익은 토마토(1)부터 시작하여 익게 된 날짜를 나타냄
                maxDay = Math.max(maxDay, grid[i][j]);
            }
        }
        // 처음 익은 토마토는 1이었으므로, 실제 경과 일수는 (maxDay - 1)임
        System.out.println(maxDay - 1);
    }

    // BFS 메서드: 익은 토마토가 주변 토마토에 전파되는 과정을 시뮬레이션
    static void bfs(Queue<Tomato> queue) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            int x = current.x;
            int y = current.y;

            // 4방향 각각에 대해 익지 않은 토마토(0)가 있다면 익은 토마토로 업데이트
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 유효한 범위 내이며, 토마토가 존재하고(값이 -1이 아닌 경우) 아직 익지 않은 경우(값이 0) 처리
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && grid[nx][ny] == 0) {
                    // 익은 토마토의 값에 1을 더하여, 해당 토마토가 몇 번째 날에 익었는지 기록
                    grid[nx][ny] = grid[x][y] + 1;
                    queue.add(new Tomato(nx, ny));
                }
            }
        }
    }
}