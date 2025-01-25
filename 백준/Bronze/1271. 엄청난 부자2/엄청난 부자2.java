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
      String [] input = br.readLine().trim().split(" ");
      
      //10진수 문자열 반환 -> BigInteger
      BigInteger n = new BigInteger(input[0]);
      BigInteger m = new BigInteger(input[1]);
      
      //BigInteger는 나누기 연산과 나머지 연산을 하기 위해서는 .divide(), .remainder() 메서드를 사용해야한다. 
      BigInteger result1 = n.divide(m); //n/m
      BigInteger result2 = n.remainder(m); //n%m
      
      //BigInteger는 숫자처럼 보이지만 객체이다. 그래서 toString() 메서드로 문자열로 반환환
      bw.write(result1.toString()+"\n");
      bw.write(result2.toString());
      
      
      bw.flush();
      br.close();
      bw.close();
  }
}