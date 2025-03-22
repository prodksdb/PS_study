import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        // Step 1: 섬에 고유 번호 붙이기
        int islandId = 2; // 1은 이미 사용 중이므로 2부터 시작
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] == 1 && !visited[i][j])
                    markIsland(i, j, islandId++);

        // Step 2: 다리 놓기 (최단 거리 찾기)
        int minBridge = Integer.MAX_VALUE;
        for (int id = 2; id < islandId; id++) {
            minBridge = Math.min(minBridge, buildBridge(id));
        }

        System.out.println(minBridge);
    }

    // 섬에 번호를 붙이는 BFS
    static void markIsland(int x, int y, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = id;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 다리 놓기 BFS
    static int buildBridge(int id) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedBridge = new boolean[N][N];

        // 현재 섬의 모든 지점에서 출발
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] == id) {
                    q.add(new int[]{i, j, 0}); // {x, y, 다리길이}
                    visitedBridge[i][j] = true;
                }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (!inRange(nx, ny) || visitedBridge[nx][ny])
                    continue;

                // 바다면 계속 확장
                if (map[nx][ny] == 0) {
                    visitedBridge[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
                // 다른 섬을 만난 경우
                else if (map[nx][ny] != id) {
                    return dist;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}