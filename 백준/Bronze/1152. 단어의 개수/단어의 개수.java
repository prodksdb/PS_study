import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력 문자열을 읽고, 양쪽 공백 제거 후 split
    String input = br.readLine().trim();

    // 공백만 입력된 경우 처리
    if (input.isEmpty()) {
      System.out.println(0); // 단어가 없으므로 0 출력
    } else {
      String[] words = input.split(" "); // 공백 기준으로 단어 분리
      System.out.println(words.length); // 단어 개수 출력
    }
  }
}
