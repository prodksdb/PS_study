import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            sb.append(queue.poll()+" ");
            if(!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        System.out.print(sb);
    }
}