import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    static void dfs(long current, int lastDigit) {
        list.add(current);

        for (int i = 0; i < lastDigit; i++) {
            dfs(current * 10 + i, i);
        }
    }
}