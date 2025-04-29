import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = sc.nextInt();
                    if (box[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                    }
                }
            }
        }

        bfs();

        int result = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, box[h][n][m]);
                }
            }
        }
        System.out.println(result - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int z = curr[0], y = curr[1], x = curr[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = box[z][y][x] + 1;
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
        }
    }
}