import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    static class Floor {
        int cur;  // 현재 위치
        int count; // 이동 횟수 저장

        public Floor(int cur, int count) {
            this.cur = cur;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 층 수
        S = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 층
        G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층
        U = Integer.parseInt(st.nextToken()); // 위로 올라갈 수 있는 층 수
        D = Integer.parseInt(st.nextToken()); // 아래로 갈 수 있는 층 수

        visited = new boolean[F+1];
        bfs(S);
    }

    static void bfs(int start) {
        Queue<Floor> queue = new ArrayDeque<>();
        queue.offer(new Floor(start, 0));
        while (!queue.isEmpty()) {
            Floor current = queue.poll();
            if (current.cur == G) {
                System.out.println(current.count);
                return;
            }

            int up = current.cur + U;
            if (up >= 1 && up <= F && !visited[up]) {
                visited[up] = true;
                queue.offer(new Floor((up), current.count+1));
            }

            int down = current.cur - D;
            if (down >= 1 && down <= F && !visited[down]) {
                visited[down] = true;
                queue.offer(new Floor((down), current.count+1));
            }
        }

        System.out.println("use the stairs");
    }
}