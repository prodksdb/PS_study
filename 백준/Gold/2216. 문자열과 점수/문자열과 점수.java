import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();  // 같은 문자
        int B = sc.nextInt();  // 공백 포함
        int C = sc.nextInt();  // 다른 문자
        String X = sc.next();
        String Y = sc.next();
        int n = X.length();
        int m = Y.length();

        int[][] dp = new int[n + 1][m + 1];

        // 초기값
        for (int i = 1; i <= n; i++) dp[i][0] = dp[i-1][0] + B;
        for (int j = 1; j <= m; j++) dp[0][j] = dp[0][j-1] + B;

        // 점화식
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int match = (X.charAt(i - 1) == Y.charAt(j - 1)) ? A : C;
                dp[i][j] = Math.max(dp[i - 1][j - 1] + match,
                            Math.max(dp[i - 1][j] + B, dp[i][j - 1] + B));
            }
        }

        System.out.println(dp[n][m]);
    }
}