import java.util.*;

public class Main {
    static final int INF = 987654321;
    static int N, M;
    static boolean[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 학생 수
        M = sc.nextInt(); // 비교 수

        graph = new boolean[N + 1][N + 1];

        // 방향 그래프 구성
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = true; // a < b
        }

        // 플로이드 워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int result = 0;

        // 각 학생에 대해 순위를 알 수 있는지 확인
        for (int i = 1; i <= N; i++) {
            int smaller = 0;
            int taller = 0;

            for (int j = 1; j <= N; j++) {
                if (graph[i][j]) taller++; // i보다 키가 큰 사람
                if (graph[j][i]) smaller++; // i보다 키가 작은 사람
            }

            if (smaller + taller == N - 1) result++;
        }

        System.out.println(result);
    }
}