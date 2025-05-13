import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] ingredients;
    static boolean[] visited; // A 음식 재료 선택 여부
    static int minDiff;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            ingredients = new int[N][N];
            visited = new boolean[N];
            minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    ingredients[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combine(0, 0);  // 조합 시작
            sb.append("#").append(test_case).append(" ").append(minDiff).append("\n");
        }
        System.out.print(sb);
    }

    // N개 중에서 N/2개를 선택하는 조합
    static void combine(int idx, int count) {
        if (count == N / 2) {
            calculateTasteDiff();
            return;
        }
        for (int i = idx; i < N; i++) {
            visited[i] = true;
            combine(i + 1, count + 1);
            visited[i] = false;
        }
    }

    // 두 음식의 맛 차이를 계산
    static void calculateTasteDiff() {
        int aTaste = 0;
        int bTaste = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    aTaste += ingredients[i][j] + ingredients[j][i];
                } else if (!visited[i] && !visited[j]) {
                    bTaste += ingredients[i][j] + ingredients[j][i];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(aTaste - bTaste));
    }
}