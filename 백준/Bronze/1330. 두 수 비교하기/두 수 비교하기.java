import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String [] input = br.readLine().trim().split(" ");
      int A = Integer.parseInt(input[0]);
      int B = Integer.parseInt(input[1]);
      
      if(A > B){
          bw.write(">");
      }else if(A < B){
          bw.write("<");
      }else{
          bw.write("==");
      }
      
      bw.flush();
      br.close();
      bw.close();
  }
}