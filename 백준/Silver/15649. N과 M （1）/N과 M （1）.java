import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] sequence; // 선택된 숫자 저장
    static boolean[] visited; // 중복 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1부터 N까지 사용
        M = Integer.parseInt(st.nextToken()); // M개의 숫자 선택

        sequence = new int[M]; // 선택한 수열 저장
        visited = new boolean[N + 1]; // 숫자 중복 체크 (1~N)

        backtrack(0); // 백트래킹 시작
    }

    static void backtrack(int depth) {
        if (depth == M) { // M개 선택 완료 시 출력
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) { // 1부터 N까지 탐색
            if (!visited[i]) { // 방문하지 않은 숫자 선택
                visited[i] = true; // 방문 체크
                sequence[depth] = i; // 현재 위치에 숫자 저장
                backtrack(depth + 1); // 다음 숫자 선택 (재귀 호출)
                visited[i] = false; // 백트래킹 (원래 상태로 복구)
            }
        }
    }
}
