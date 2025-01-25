import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int N = Integer.parseInt(br.readLine());
      int initialValue = N;
      int count = 0; 
      
     //do while문은 조건 확인 없이 무조건 한 번 실행한다. 
     do {
            int tens = N / 10; // 10의 자리
            int ones = N % 10; // 1의 자리
            int sum = tens + ones; // 각 자리 숫자의 합
            
            // 새로운 숫자 생성
            N = (ones * 10) + (sum % 10);
            count++; // 사이클 증가
        } while (N != initialValue); // 초기값으로 돌아오면 종료
     
     bw.write(String.valueOf(count));
      
      bw.flush();
      br.close();
      bw.close();
  }
}