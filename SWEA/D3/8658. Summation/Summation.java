import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 10; i++){
                String input = st.nextToken();
                int sum = 0;
                for(int j = 0; j < input.length(); j++){
                    int num = Integer.parseInt(String.valueOf(input.charAt(j)));
                    sum += num;
                }
                max = Math.max(sum, max);
                min = Math.min(sum, min);
            }
            sb.append("#" + test_case + " "+max+" "+min+"\n");
        }
        System.out.println(sb);
    }


}