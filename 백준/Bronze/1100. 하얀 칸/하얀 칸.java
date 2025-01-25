import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main{
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int count = 0;
      
      for(int i = 0; i < 8; i++){
          String input = br.readLine();
          for(int j = 0; j < 8; j++){
              if((i+j) %  2 == 0 && input.charAt(j) == 'F' ) {
                       count ++;
              }
          }
      }
      
      //String.valuOf() : 기본형 및 객체를 문자열로 변환해주는 메서드
      //.toString() : 객체의 메서드 
      bw.write(String.valueOf(count));
      
      bw.flush();
      br.close();
      bw.close();
  }
}