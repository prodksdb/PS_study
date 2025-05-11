import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int [] heights;
    static int total;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            heights = new int[N];
            for(int i = 0; i < N; i++){
                heights[i] = Integer.parseInt(st.nextToken());
            }

            total = 0;
            view(2);
            sb.append("#"+test_case+" "+total+"\n");
        }
        System.out.println(sb);
    }

    static void view(int building){
        if(building == N-2){
            return;
        }

        int max = 0;
        int count = 0;

        for(int i = building-2; i<= building + 2; i++){
           if(heights[i] < heights[building]){
               max = Math.max(heights[i], max);
               count++;
           }
        }


        if(count == 4){
            total += heights[building] - max;
        }
        view(building+1);
    }
}