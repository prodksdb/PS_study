import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int[] soldiers = new int[N];
        for (int i = 0; i < N; i++) {
            soldiers[i] = sc.nextInt();
        }

        // DP 배열
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // 모든 병사는 최소 1명의 수열을 가질 수 있음

        // DP 실행 (가장 긴 감소하는 부분 수열 찾기)
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (soldiers[j] > soldiers[i]) { // 내림차순을 유지해야 함
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 가장 긴 감소하는 부분 수열의 길이 찾기
        int maxLDS = 0;
        for (int i = 0; i < N; i++) {
            maxLDS = Math.max(maxLDS, dp[i]);
        }

        // 제거해야 하는 병사의 수
        System.out.println(N - maxLDS);
    }
}
