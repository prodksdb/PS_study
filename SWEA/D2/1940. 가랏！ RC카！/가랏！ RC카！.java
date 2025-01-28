import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      int t = Integer.parseInt(br.readLine());
      int distance = 0;
      int speed = 0;

      for (int i = 0; i < t; i++) {

        String[] input = br.readLine().trim().split(" ");
        // 명렁어 : 0:속도 유지 / 1: 가속 /2:감속
        int command = Integer.parseInt(input[0]);
        int accerelation = (command != 0) ?Integer.parseInt(input[1]) : 0;

        switch (command) {
        case 1: // 가속
          speed += accerelation;
          break;
        case 2:
          speed -= accerelation;
          if (speed < 0) {
            speed = 0; // 속도는 음수가 될 수 없음
          }
          break;
        case 0: // 속도 유지
          break;
        default:
          throw new IllegalArgumentException("Invalid command: " + command);
        }

        distance += speed;

      }

      bw.write("#" + test_case + " " + distance + "\n");
    }

    bw.flush();
    br.close();
    bw.close();

  }

}
