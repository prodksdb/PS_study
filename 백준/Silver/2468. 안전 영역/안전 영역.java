import java.io.*;
import java.util.*;

public class Main {

    static int[][] zone;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Safety {
        int x, y;
        public Safety(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        zone = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                zone[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, zone[i][j]);
            }
        }

        int result = 0;
        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int safeAreaCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && zone[i][j] > h) {
                        bfs(i, j, h);
                        safeAreaCount++;
                    }
                }
            }

            result = Math.max(result, safeAreaCount);
        }

        System.out.println(result);
    }

    public static void bfs(int x, int y, int height) {
        Queue<Safety> queue = new ArrayDeque<>();
        queue.offer(new Safety(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Safety current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (can_go(nx, ny) && !visited[nx][ny] && zone[nx][ny] > height) {
                    queue.offer(new Safety(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean can_go(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}