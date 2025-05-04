import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int MAX = 100001;
    static int [] dist = new int[MAX];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < MAX; i++) dist[i] = -1;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        dist[N] = 0;
        while(!dq.isEmpty()){
            int cur = dq.poll();

            if(cur == K) break;

            // 순간이동(0초) -> 먼저 넣기
            if(cur*2 < MAX && dist[cur*2] == -1){
                dist[cur*2] = dist[cur];
                dq.offerFirst(cur*2);  // 0초는 앞쪽에 삽입
            }

            // -1 이동(1초)
            if (cur - 1 >= 0 && dist[cur - 1] == -1) {
                dist[cur - 1] = dist[cur] + 1;
                dq.offerLast(cur - 1);
            }

            // +1 이동(1초)
            if (cur + 1 < MAX && dist[cur + 1] == -1) {
                dist[cur + 1] = dist[cur] + 1;
                dq.offerLast(cur + 1);
            }
        }

        System.out.println(dist[K]);
    }
}