import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1자리부터 10자리까지
        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }
    }

    static void dfs(long num, int lastDigit) {
        list.add(num);

        for (int next = lastDigit - 1; next >= 0; next--) {
            dfs(num * 10 + next, next);
        }
    }
}