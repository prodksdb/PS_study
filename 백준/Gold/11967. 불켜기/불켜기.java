import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] light, visited, canVisit;
    static List<int[]>[][] switches;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        light = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        canVisit = new boolean[N + 1][N + 1];
        switches = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                switches[i][j] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int a = sc.nextInt(), b = sc.nextInt();
            switches[x][y].add(new int[]{a, b});
        }

        light[1][1] = true;
        bfs();

        int count = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (light[i][j]) count++;

        System.out.println(count);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            // 스위치 작동
            for (int[] sw : switches[x][y]) {
                int a = sw[0], b = sw[1];
                if (!light[a][b]) {
                    light[a][b] = true;

                    // 인접한 곳 중 이미 방문한 곳이 있다면, 갈 수 있는 곳이므로 큐에 추가
                    for (int d = 0; d < 4; d++) {
                        int na = a + dx[d], nb = b + dy[d];
                        if (inRange(na, nb) && visited[na][nb]) {
                            queue.add(new int[]{a, b});
                            visited[a][b] = true;
                            break;
                        }
                    }
                }
            }

            // 인접한 방 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (inRange(nx, ny) && light[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}