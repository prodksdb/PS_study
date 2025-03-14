import java.util.*;

public class Main {
    static class Node {
        int x, y, dist, broken;
        public Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken; // 0: 벽 안부숨, 1: 벽 부숨
        }
    }

    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M][2]; // visited[x][y][0]: 벽을 안 부쉈을 때, visited[x][y][1]: 벽을 부쉈을 때

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0)); // (x, y, 거리, 벽 부순 여부)
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;
            int broken = cur.broken;

            // 목표 지점 도달 시 즉시 리턴
            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 벗어나면 스킵
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 이동할 수 있는 경우 (벽 X, 방문 안함)
                if (map[nx][ny] == 0 && visited[nx][ny][broken] == 0) {
                    visited[nx][ny][broken] = dist + 1;
                    queue.add(new Node(nx, ny, dist + 1, broken));
                }

                // 벽을 만났고, 아직 벽을 부수지 않은 경우
                if (map[nx][ny] == 1 && broken == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = dist + 1;
                    queue.add(new Node(nx, ny, dist + 1, 1));
                }
            }
        }

        // 도달할 수 없을 경우 -1 리턴
        return -1;
    }
}