import java.io.*;
import java.util.*;

public class Solution {
    static char [][] field;
    static char [][] command;
    static int N;
    static int startX, startY, endX, endY;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case ++){
            N = Integer.parseInt(br.readLine());
            field = new char[N][N];
            for(int i = 0; i < N; i++){
                String input = br.readLine();
                for(int j = 0; j < N; j++){
                    field[i][j] = input.charAt(j);
                    if(field[i][j] == 'X') {
                        startX = i;
                        startY = j;
                    }else if(field[i][j] == 'Y'){
                        endX = i;
                        endY = j;
                    }
                }
            }

            int Q = Integer.parseInt(br.readLine());
            int [] results = new int[Q];
            for(int i = 0; i < Q; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                String commands = st.nextToken();

                int curX = startX;
                int curY = startY;
                int dir = 0;

                for(int j = 0; j < C; j++){
                    char c = commands.charAt(j);
                    if (c == 'A') {
                        int nx = curX+ dx[dir];
                        int ny = curY + dy[dir];
                        if(can_go(nx, ny)){
                            curX = nx;
                            curY = ny;
                        }
                    }
                    else if(c =='L') {
                        dir = (dir + 3) % 4;
                    }else if(c == 'R'){
                        dir = (dir + 1) % 4;
                    }
                }

                if(curX == endX && curY == endY){
                    results[i] = 1;
                }else{
                    results[i] = 0;
                }
            }

            sb.append("#"+test_case+" ");
            for(int i = 0; i < Q; i++){
               sb.append(results[i]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    static boolean can_go(int nx, int ny){
        if(nx >= 0 && ny >= 0 && nx < N && ny < N && field[nx][ny] != 'T'){
            return true;
        }
        return false;
    }
}