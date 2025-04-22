import java.io.*;
import java.util.*;

public class Solution {
    static int N, W, H, minRemain;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minRemain = Integer.MAX_VALUE;
            dfs(0, map);
            sb.append("#").append(tc).append(" ").append(minRemain).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int[][] currentMap) {
        if (depth == N) {
            minRemain = Math.min(minRemain, countBlocks(currentMap));
            return;
        }

        for (int col = 0; col < W; col++) {
            int[][] copiedMap = copyMap(currentMap);
            if (dropBall(col, copiedMap)) {
                gravity(copiedMap);
                dfs(depth + 1, copiedMap);
            } else {
                dfs(depth + 1, copiedMap); // 아무 벽돌 못 맞췄지만 진행
            }
        }
    }

    static boolean dropBall(int col, int[][] map) {
        for (int row = 0; row < H; row++) {
            if (map[row][col] != 0) {
                boom(row, col, map);
                return true;
            }
        }
        return false;
    }

    static void boom(int x, int y, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, map[x][y]});
        map[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                for (int i = 1; i < cur[2]; i++) {
                    int nx = cur[0] + dx[d] * i;
                    int ny = cur[1] + dy[d] * i;
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 0)
                        continue;
                    q.offer(new int[]{nx, ny, map[nx][ny]});
                    map[nx][ny] = 0;
                }
            }
        }
    }

    static void gravity(int[][] map) {
        for (int col = 0; col < W; col++) {
            int bottom = H - 1;
            for (int row = H - 1; row >= 0; row--) {
                if (map[row][col] != 0) {
                    int temp = map[row][col];
                    map[row][col] = 0;
                    map[bottom--][col] = temp;
                }
            }
        }
    }

    static int countBlocks(int[][] map) {
        int count = 0;
        for (int[] row : map) {
            for (int b : row) {
                if (b != 0) count++;
            }
        }
        return count;
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, W);
        }
        return newMap;
    }
}
