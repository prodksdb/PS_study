import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fireTime, jihoonTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime = new int[R][C];
        jihoonTime = new int[R][C];

        Queue<Point> fireQ = new LinkedList<>();
        Queue<Point> jihQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireTime[i][j] = -1;
                jihoonTime[i][j] = -1;

                if (map[i][j] == 'F') {
                    fireQ.add(new Point(i, j));
                    fireTime[i][j] = 0;
                }

                if (map[i][j] == 'J') {
                    jihQ.add(new Point(i, j));
                    jihoonTime[i][j] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            Point cur = fireQ.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#' || fireTime[nx][ny] >= 0) continue;

                fireTime[nx][ny] = fireTime[cur.x][cur.y] + 1;
                fireQ.add(new Point(nx, ny));
            }
        }

        while (!jihQ.isEmpty()) {
            Point cur = jihQ.poll();


            if (cur.x == 0 || cur.y == 0 || cur.x == R - 1 || cur.y == C - 1) {
                System.out.println(jihoonTime[cur.x][cur.y] + 1);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#' || jihoonTime[nx][ny] >= 0) continue;

 
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihoonTime[cur.x][cur.y] + 1) continue;

                jihoonTime[nx][ny] = jihoonTime[cur.x][cur.y] + 1;
                jihQ.add(new Point(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}