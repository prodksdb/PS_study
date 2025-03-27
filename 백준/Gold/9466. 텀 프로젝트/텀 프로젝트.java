import java.util.*;

public class Main {
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void dfs(int node) {
        visited[node] = true;
        int next = students[node];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발생
            int current = next;
            while (current != node) {
                count++;
                current = students[current];
            }
            count++; // 마지막 노드도 포함
        }

        finished[node] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                students[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - count);
        }
    }
}