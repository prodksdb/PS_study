import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            sb.append("#"+test_case+" ");
            String s = br.readLine();
            switch(s) {
                case "MON":
                    sb.append("6\n");
                    break;
                case "TUE":
                    sb.append("5\n");
                    break;
                case "WED":
                    sb.append("4\n");
                    break;
                case "THU":
                    sb.append("3\n");
                    break;
                case "FRI":
                    sb.append("2\n");
                    break;
                case "SAT":
                    sb.append("1\n");
                    break;
                case "SUN":
                    sb.append("7\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}