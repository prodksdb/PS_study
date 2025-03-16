import java.io.*;
import java.util.*;

public class Solution {
    static int[] gyu, inyoung, inyoungPerm;
    static boolean[] used;
    static int win, lose;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            gyu = new int[9];
            boolean[] selected = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                selected[gyu[i]] = true;
            }

            //인영이가 가질 수 있는 카드 목록 구성
            inyoung = new int[9];
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!selected[i]) inyoung[idx++] = i;
            }
            //모든 경우의 수 탐색을 위한 변수 초기화
            inyoungPerm = new int[9];
            used = new boolean[9];
            win = 0;
            lose = 0;

            //백트래킹을 이용한 순열 생성 및 시뮬레이션
            permute(0);
            sb.append("#" + test_case + " " + win + " " + lose+"\n");
        }
        System.out.println(sb);
    }

    // 인영이 카드의 모든 순열을 생성하는 백트래킹 함수
    static void permute(int depth) {
        if (depth == 9) { // 9장의 카드 순서가 정해지면
            playGame(); // 해당 순열로 게임 진행
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                inyoungPerm[depth] = inyoung[i]; // 순열 생성
                permute(depth + 1);
                used[i] = false;
            }
        }
    }

    // 9라운드 게임을 진행하여 승패 계산
    static void playGame() {
        int gyuScore = 0, inyoungScore = 0;
        for (int i = 0; i < 9; i++) {
            if (gyu[i] > inyoungPerm[i]) {
                gyuScore += gyu[i] + inyoungPerm[i]; // 규영 승리
            } else {
                inyoungScore += gyu[i] + inyoungPerm[i]; // 인영 승리
            }
        }
        if (gyuScore > inyoungScore) win++; // 규영 승리 카운트 증가
        else if (gyuScore < inyoungScore) lose++; // 인영 승리 카운트 증가
    }
}