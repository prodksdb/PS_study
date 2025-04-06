import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 리스트 정렬
        Collections.sort(list); // 오름차순 정렬

        for (int num : list) {
            sb.append(num).append('\n');
        }

        System.out.print(sb);
    }
}