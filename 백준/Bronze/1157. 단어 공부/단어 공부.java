import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String Input = br.readLine();
    // 대소문자를 구분하지 않으므로 다 대문자로 바꿔준다!!
    Input = Input.toUpperCase();
    // 알파벳 등장 횟수를 저장할 HashMap
    HashMap<Character, Integer> charCount = new HashMap<>();
    // 최대 빈도수
    int maxCount = 0;
    // 가장 많이 등장한 문자, 초기값은 ?
    char maxChar = '?';
    // 최대 빈도가 중복인지 확인하기
    boolean isDuplicate = false;

    // 1. 각 알파벳의 등장 횟수 계산
    //String.toCharArray() : 문자열을 문자 배열(char[])로 변환하는 메서드 
    for (char c : Input.toCharArray()) {
      //put은 HashMap에 키, 값 데이터를 저장한다. 
      //기존에 해당 키가 있으면 값을 덮어쓴다. 
      //.getOrDefault() : HashMap에서 키 c에 해당하는 값을 가져온다. 
      // 키가 존재하지 않으면 기본값 0을 반환 
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);

      
      //get 메서드의 특징 : get을 호출하면 예외가 발생하지 않고 null을 반환 
      int count = charCount.get(c);
      if (count > maxCount) {
        maxCount = count;
        maxChar = c;
        isDuplicate = false;
      } else if (count == maxCount) {
        isDuplicate = true;
      }
    }

    if (isDuplicate) {
      bw.write("?");
    } else {
      bw.write(maxChar);
    }

    bw.flush();
    br.close();
    bw.close();

  }
}
