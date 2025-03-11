import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long result = exp(A, B, C);
        System.out.println(result);
    }
    public static long exp(long a, long b, long c){

        // 기저 부분
        if( b == 1){
            return a % c;
        }

        //분할, 계산한 결과를 재사용
        long y = exp(a, b/2, c);
        y = (y*y) % c;
        
        if( b % 2 == 1){
            y = (y*a)%c;
        }
        return y;
    }
}