import java.io.*;
import java.util.*;

public class Solution {
    static int [][] maze;
    static boolean [][] visited;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            int t = Integer.parseInt(br.readLine());
            maze = new int[16][16];
            visited = new boolean[16][16];
            int startX = 0;
            int startY = 0;
            int result = 0;
            for(int i = 0; i < 16; i++){
                String input = br.readLine();
                for(int j = 0; j < 16; j++){
                    maze[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                    if(maze[i][j] == 2){
                        startX = i;
                        startY = j;
                    }
                }
            }
            if(bfs(startX, startY)){
                result = 1;
            }

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }

    static boolean bfs(int startX, int startY){
        Queue<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(startX, startY));
        while(!queue.isEmpty()){
            Location current = queue.poll();
            int curX = current.x;
            int curY = current.y;
            visited[curX][curY] = true;

            if(maze[curX][curY] == 3){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(can_go(nx, ny)){
                    visited[nx][ny] = true;
                    queue.offer(new Location(nx, ny));
                }
            }

        }
        return false;
    }

    static boolean can_go(int nx, int ny){
        return nx >= 0 && ny >= 0 && nx < 16 && ny < 16 && (maze[nx][ny] == 0 || maze[nx][ny] == 3) && !visited[nx][ny];
    }
}