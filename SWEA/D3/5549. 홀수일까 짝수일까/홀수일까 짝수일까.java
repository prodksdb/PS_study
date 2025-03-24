import java.io.*;
import java.math.BigInteger;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            sb.append("#"+test_case+" ");
            String input = br.readLine();
            BigInteger num = new BigInteger(input);
            BigInteger two = new BigInteger("2");
            if(num.mod(two).equals(BigInteger.ZERO)){
                sb.append("Even\n");
            }else{
                sb.append("Odd\n");
            }
        }
        System.out.println(sb);
    }
}