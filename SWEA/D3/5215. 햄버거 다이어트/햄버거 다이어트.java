import java.io.*;
import java.util.*;


public class Solution {

    public static int highScore;
    public static int[] scores;
    public static int[] calories;
    public static int N, L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            scores = new int[N];
            calories = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            highScore = 0;
            select(0, 0, 0);
            sb.append("#" + test_case + " " + highScore + "\n");
        }
        System.out.println(sb);
    }

    public static void select(int start, int score, int calorie) {

        if (calorie > L) return;
        highScore = Math.max(highScore, score);
        if (start == N) {
            return;
        }

        select(start + 1, score + scores[start], calorie + calories[start]);

        select(start + 1, score, calorie);

    }
}