import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] Input = br.readLine().trim().split(" ");
    int N = Integer.parseInt(Input[0]);
    int m = Integer.parseInt(Input[1]);
    int M = Integer.parseInt(Input[2]);
    int T = Integer.parseInt(Input[3]);
    int R = Integer.parseInt(Input[4]);

    if (m + T > M) {
      bw.write(String.valueOf(-1));
      bw.flush();
      br.close();
      bw.close();
      return;
    }

    int currentPulse = m; // 현재 맥박
    int exerciseTime = 0; // 운동한 시간
    int totalTime = 0; // 총 소요 시간

    while (exerciseTime < N) {
      if (currentPulse + T <= M) {
        // 운동할 수 있는 경우
        currentPulse += T;
        exerciseTime++;
      } else {
        // 운동할 수 없으므로 휴식
        currentPulse -= R;
        if (currentPulse < m) {
          currentPulse = m;
        }
      }
      totalTime++;
    }

    bw.write(String.valueOf(totalTime));

    bw.flush();
    br.close();
    bw.close();

  }
}
