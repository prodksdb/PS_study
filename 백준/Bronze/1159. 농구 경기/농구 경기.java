import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    HashMap<Character, Integer> playerFirstName = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String player = br.readLine();
      if (!player.isEmpty()) {
        char p = player.charAt(0);
        playerFirstName.put(p, playerFirstName.getOrDefault(p, 0) + 1);
      }
    }

    // 선발 가능한 성의 첫 글자 리스트
    ArrayList<Character> result = new ArrayList<>();

    for (char key : playerFirstName.keySet()) {
      int count = playerFirstName.get(key);
      if (count >= 5) {
        result.add(key);
      }
    }

    Collections.sort(result);

    if (result.isEmpty()) {
      bw.write("PREDAJA");
    } else {
      for (char c : result) {
        bw.write(c);
      }
    }

    bw.flush();
    br.close();
    bw.close();

  }
}
