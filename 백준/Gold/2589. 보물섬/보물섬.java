import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static String[][] treasure;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Location{
        int x;
        int y;
        int dist;
        public Location(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        treasure = new String[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                treasure[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int maxDist = 0;

        // 모든 L에서 BFS 실행
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(treasure[i][j].equals("L")){
                    int dist = bfs(i, j);
                    maxDist = Math.max(maxDist, dist);
                }
            }
        }
        System.out.println(maxDist);
    }

    public static int bfs(int startX, int startY){
        boolean[][] visited = new boolean[N][M];
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(startX, startY, 0));
        visited[startX][startY] = true;

        int max = 0;

        while(!queue.isEmpty()){
            Location cur = queue.poll();
            max = Math.max(max, cur.dist);

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(can_go(nx, ny, visited)){
                    visited[nx][ny] = true;
                    queue.offer(new Location(nx, ny, cur.dist+1));

                }
            }
        }
        return max;
    }

    static boolean can_go(int nx, int ny, boolean[][] visited){
        return nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && treasure[nx][ny].equals("L");
    }
}