import java.io.*;
import java.util.*;

public class Solution {

    static int [] heights;
    static int dumpCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            dumpCount = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            heights = new int[100];
            for(int i = 0; i < 100; i++){
                heights[i] = Integer.parseInt(st.nextToken());
            }
            dump(0);
            Arrays.sort(heights);

            int difference = heights[99] - heights[0];
            sb.append("#"+test_case+" "+difference+"\n");
        }
        System.out.println(sb);
    }

    static void dump(int count){
        if(count == dumpCount){
            return;
        }

        Arrays.sort(heights);
        int high = heights[99];
        int low = heights[0];
        heights[99] = high - 1;
        heights[0] = low + 1;

        dump(count+1);
    }
}