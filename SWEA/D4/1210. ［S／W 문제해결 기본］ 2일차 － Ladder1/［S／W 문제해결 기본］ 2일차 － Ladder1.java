import java.io.*;
import java.util.*;

public class Solution {

    static int[][] ladders;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int t = Integer.parseInt(br.readLine());
            ladders = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladders[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            // 모든 시작점(0행에서 값이 1인 열) 검사
            for (int y = 0; y < 100; y++) {
                if (ladders[0][y] == 1) {
                    int x = 0;
                    int curY = y;

                    boolean[][] visited = new boolean[100][100];

                    while (x < 99) {
                        visited[x][curY] = true;

                        // 왼쪽으로 갈 수 있으면 계속 감
                        if (curY > 0 && ladders[x][curY - 1] == 1 && !visited[x][curY - 1]) {
                            while (curY > 0 && ladders[x][curY - 1] == 1) {
                                curY--;
                                visited[x][curY] = true;
                            }
                        }
                        // 오른쪽으로 갈 수 있으면 계속 감
                        else if (curY < 99 && ladders[x][curY + 1] == 1 && !visited[x][curY + 1]) {
                            while (curY < 99 && ladders[x][curY + 1] == 1) {
                                curY++;
                                visited[x][curY] = true;
                            }
                        }

                        // 아래로 한 칸
                        x++;
                    }

                    // 도착지점이면 이 y가 정답
                    if (ladders[x][curY] == 2) {
                        result = y;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}