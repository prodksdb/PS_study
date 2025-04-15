import java.io.*;
import java.util.*;

public class Main {

    // 완전 제곱수 여부 체크 (음수는 제외)
    public static boolean isSquare(long num) {
        if (num < 0) {
            return false;
        }
        long root = (long) Math.sqrt(num);
        return root * root == num;
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리: BufferedReader로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().trim();
        }

        long maxSquare = -1; // 완전 제곱수 중 최대값

        // 모든 시작 좌표 (i, j)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 진행 간격: 행 방향은 -N+1부터 N-1까지, 열 방향은 -M+1부터 M-1까지
                for (int dr = -N + 1; dr < N; dr++) {
                    for (int dc = -M + 1; dc < M; dc++) {
                        // (dr, dc) = (0, 0)인 경우는 한 칸만 선택하는 경우로 처리
                        if (dr == 0 && dc == 0) {
                            long num = board[i].charAt(j) - '0';
                            if (isSquare(num) && num > maxSquare) {
                                maxSquare = num;
                            }
                            continue;
                        }
                        int x = i, y = j;
                        StringBuilder sb = new StringBuilder();
                        // 표의 범위 내에서 진행하며 숫자를 이어붙임
                        while (x >= 0 && x < N && y >= 0 && y < M) {
                            sb.append(board[x].charAt(y));
                            long num = Long.parseLong(sb.toString());
                            if (isSquare(num) && num > maxSquare) {
                                maxSquare = num;
                            }
                            x += dr;
                            y += dc;
                        }
                    }
                }
            }
        }
        System.out.println(maxSquare);
    }
}