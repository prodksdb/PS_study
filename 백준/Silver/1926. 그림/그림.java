import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, m;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        int number = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]){
                    number++;
                    count = 0;
                    max = Math.max(findPicture(i, j), max);
                }
            }
        }

        if(number == 0){
            System.out.println(number);
            System.out.println(0);
        }else{
            System.out.println(number);
            System.out.println(max);
        }
    }


    public static int findPicture(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (can_go(nx, ny) && !visited[nx][ny] && paper[nx][ny] == 1){
                findPicture(nx, ny);
            }
        }
        return count;
    }


    public static boolean can_go(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}