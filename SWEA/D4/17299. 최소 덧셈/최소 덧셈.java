import java.io.*;
import java.sql.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            sb.append("#"+test_case+" ");   
            String st = br.readLine();
            int minSum = Integer.MAX_VALUE;

            for(int i = 1; i <st.length(); i++){
                int left = Integer.parseInt(st.substring(0, i));
                int right = Integer.parseInt(st.substring(i));
                minSum = Math.min(minSum, left+right);
            }
            sb.append(minSum+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}