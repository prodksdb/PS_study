import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= 10; test_case++){
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int [] numbers = new int[101];
            for(int i = 0; i < 1000; i++){
                int number = Integer.parseInt(st.nextToken());
                numbers[number]++;
            }

            int number = 0;
            int max = 0;

            for(int i = 0; i < 101; i++){
                if(max <= numbers[i]){
                    max = numbers[i];
                    number = i;
                }
            }

            sb.append("#"+test_case+" "+number+"\n");
        }
        System.out.println(sb);
    }
}