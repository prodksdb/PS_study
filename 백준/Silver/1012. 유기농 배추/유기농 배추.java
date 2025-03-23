import java.io.*;
import java.util.*;

public class Main {

    static int [][] cabbage;
    static boolean [][] visited;
    static int N, M;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            cabbage = new int[N][M];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                cabbage[x][y] = 1;
            }

            int count = 0;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(cabbage[i][j] == 1 && !visited[i][j]){
                        count++;
                        findField(i, j);
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }

    public static void findField(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (can_go(nx, ny) && !visited[nx][ny] && cabbage[nx][ny] == 1) {
                findField(nx, ny);
            }
        }
    }

    public static boolean can_go(int nx, int ny){
        return nx>=0 && ny>=0 && nx < N && ny < M;
    }
}