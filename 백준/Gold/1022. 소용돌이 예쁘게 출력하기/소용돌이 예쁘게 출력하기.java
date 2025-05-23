import java.util.Scanner;

public class Main {
    static int[] dy = {0, -1, 0, 1}; // → ↑ ← ↓
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int row = r2 - r1 + 1;
        int col = c2 - c1 + 1;
        int[][] map = new int[row][col];

        int x = 0, y = 0; // 시작 위치
        int num = 1;
        int dir = 0; // 방향: → ↑ ← ↓
        int step = 1; // 이동 거리
        int len = 0;  // 같은 step 반복 2번
        int cnt = 0;  // 출력 범위 내에 기록된 숫자 수

        int maxVal = 1;

        while (cnt < row * col) {
            for (int i = 0; i < step; i++) {
                if (r1 <= y && y <= r2 && c1 <= x && x <= c2) {
                    map[y - r1][x - c1] = num;
                    maxVal = Math.max(maxVal, num);
                    cnt++;
                }

                if (cnt >= row * col) break;

                y += dy[dir];
                x += dx[dir];
                num++;
            }

            dir = (dir + 1) % 4; // 방향 전환
            len++;

            if (len == 2) {
                len = 0;
                step++;
            }
        }

        int width = String.valueOf(maxVal).length();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%" + width + "d", map[i][j]);
                if (j != col - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}