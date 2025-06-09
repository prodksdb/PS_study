import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int I;  // 체스판의 한 변의 길이
    static Location knight;  // 나이트가 현재 있는 칸
    static Location destination;  // 나이트가 이동하려고 하는 칸
    static int [] dx ={-2, -1, -2, -1, 2, 1, 2, 1};
    static int [] dy = {-1, -2, 1, 2, -1, -2, 1, 2};
    static int min;
    static boolean visited[][];
    // 위치 클래스
    static class Location {
        int x;
        int y;
        int count;

        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // I 입력 받기
            I = Integer.parseInt(br.readLine());

            // 나이트가 현재 있는 칸 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            knight = new Location(x, y,0);

            // 나이트가 이동하려고 하는 칸 입력 받기
            st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            destination = new Location(x, y,0);

            min = Integer.MAX_VALUE;
            visited = new boolean[I][I];
            int result = bfs(knight);
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }

    // 나이트 최소 이동 횟수 찾기
    static int bfs(Location start){
        Queue<Location> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){
            Location current = q.poll();
            int curX = current.x;
            int curY = current.y;
            int curD = current.count;

            if(curX == destination.x && curY == destination.y){
                min = Math.min(min, curD);
                return min;
            }

            for(int i = 0; i < 8; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(can_go(nx, ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Location(nx,ny,curD + 1 ));
                }
            }
        }
        return -1;
    }

    // 나이트가 이동할 수 있는지 확인하는 함수
    static boolean can_go(int nx, int ny){
        return nx >= 0 && ny >= 0 && nx < I && ny < I;
    }
}