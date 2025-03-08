import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while(!list.isEmpty()){
            index = (index + K - 1) % list.size(); // K번째 위치 찾기
            sb.append(list.remove(index)); // K번째 사람 제거
            if(!list.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}