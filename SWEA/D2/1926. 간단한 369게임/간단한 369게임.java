import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            String s = String.valueOf(i);
            if(s.contains("3") || s.contains("6") || s.contains("9")){
                for(int j = 0; j <s.length(); j++){
                    char c = s.charAt(j);
                    if(c == '3' || c == '6' || c=='9'){
                        sb.append("-");
                    }
                }
                sb.append(" ");
            }else{
                sb.append(s+" ");
            }

        }
        System.out.println(sb);
    }
}