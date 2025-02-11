import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Shortcut {
        int start;
        int end;
        int length;

        Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);

        // 지름길 저장
        List<Shortcut> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] shortcutInfo = br.readLine().split(" ");
            int start = Integer.parseInt(shortcutInfo[0]);
            int end = Integer.parseInt(shortcutInfo[1]);
            int length = Integer.parseInt(shortcutInfo[2]);

            // 지름길이 고속도로 범위 내에 있고, 시작점이 도착점보다 작아야 유효함
            if (end <= D && end > start) {
                shortcuts.add(new Shortcut(start, end, length));
            }
        }

        // DP 배열 초기화
        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i; // 기본적으로 각 위치까지의 거리는 직선 거리로 초기화
        }

        // DP 업데이트, dp[i]까지의 최단 거리를 기본적으로 직선 거리로 설정
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 직선 도로로 가는 경우
            }

            for (Shortcut shortcut : shortcuts) {
                if (shortcut.start == i) { // 현재 위치가 지름길의 시작점이라면
                    dp[shortcut.end] = Math.min(dp[shortcut.end], dp[i] + shortcut.length);
                }
            }
        }

        // 결과 출력
        bw.write(dp[D] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
