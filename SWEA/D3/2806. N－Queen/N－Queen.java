import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int count;
    static boolean[] col;      // 열에 대한 체크 배열
    static boolean[] diag1;    // 주 대각선 체크 배열(row - col)
    static boolean[] diag2;    // 부 대각선 체크 배열(row + col)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            count = 0;
            col = new boolean[N];
            diag1 = new boolean[2*N-1];  // 인덱스 row-col + (N -1)
            diag2 = new boolean[2*N-1];  // 인덱스 row + col

            solve(0);
            sb.append("#" + test_case + " " + count + "\n");
        }
        System.out.println(sb);
    }

    public static void solve(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {

            // 해당 열과 두 대각선에 다른 퀸이 없는지 확인
            if (!col[c] && !diag1[row - c + N - 1] && !diag2[row + c]) {
                col[c] = true;
                diag1[row - c + N - 1] = true;
                diag2[row + c] = true;

                solve(row + 1);

                col[c] = false;
                diag1[row - c + N - 1] = false;
                diag2[row + c] = false;
            }
        }
    }
}
