import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

    for (int test_case = 1; test_case <= T; test_case++) {
      String[] input = br.readLine().trim().split(" ");
      int N = Integer.parseInt(input[0]);
      int K = Integer.parseInt(input[1]);
      int midScore, finalScore, homeworkScore;
      int[] totalScore = new int[N];
      int caseNumber = 0;

      for (int student = 0; student < N; student++) {
        String[] score = br.readLine().trim().split(" ");
        midScore = Integer.parseInt(score[0]);
        finalScore = Integer.parseInt(score[1]);
        homeworkScore = Integer.parseInt(score[2]);

        totalScore[student] = midScore * 35 + finalScore * 45 + homeworkScore * 20;
      }

      int checkScore = totalScore[K - 1];
      Arrays.sort(totalScore);
      for (int i = 0; i < N / 2; i++) {
        int temp = totalScore[i];
        totalScore[i] = totalScore[N - i - 1];
        totalScore[N - i - 1] = temp;
      }

      for (int i = 0; i < N; i++) {
        if (totalScore[i] == checkScore) {
          int number = N / 10;
          caseNumber = i / number + 1;
          break;
        }
      }

      switch (caseNumber) {
      case 1:
        bw.write("#" + test_case + " A+\n");
        break;
      case 2:
        bw.write("#" + test_case + " A0\n");
        break;
      case 3:
        bw.write("#" + test_case + " A-\n");
        break;
      case 4:
        bw.write("#" + test_case + " B+\n");
        break;
      case 5:
        bw.write("#" + test_case + " B0\n");
        break;
      case 6:
        bw.write("#" + test_case + " B-\n");
        break;
      case 7:
        bw.write("#" + test_case + " C+\n");
        break;
      case 8:
        bw.write("#" + test_case + " C0\n");
        break;
      case 9:
        bw.write("#" + test_case + " C-\n");
        break;
      case 10:
        bw.write("#" + test_case + " D0\n");
        break;
      }
    }

    bw.flush();
    br.close();
    bw.close();
  }
}
