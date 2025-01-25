import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int N = Integer.parseInt(br.readLine().trim());
      
      for(int i = 1; i <= 9; i++){
          int result = N*i;
          bw.write(N+ " * " + i +" = " + String.valueOf(result)+"\n");
          }
      
      bw.flush();
      br.close();
      bw.close();
  }
}