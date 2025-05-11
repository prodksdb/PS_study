import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case<=10; test_case++){
            int t = Integer.parseInt(br.readLine());
            int [][] numbers = new int[100][100];

            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < 100; j++){
                    numbers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int sum = 0;

            // 열의 합
            for(int i = 0; i < 100; i++){
                sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += numbers[i][j];
                }
                max = Math.max(sum, max);
            }

            // 행의 합
            for(int j = 0; j < 100; j++){
                sum = 0;
                for(int i = 0; i < 100; i++){
                    sum += numbers[i][j];
                }
                max = Math.max(sum, max);
            }

            // 대각선의 합
            sum = 0;
            for(int i = 0; i<100; i++){
                for(int j = 0; j < 100; j++){
                    if(i == j){
                        sum += numbers[i][j];
                    }
                }
            }
            max = Math.max(sum, max);

            // 대각선의 합
            sum = 0;
            for(int i = 0; i<100; i++){
                for(int j = 0; j < 100; j++){
                    if(i + j == 99){
                        sum += numbers[i][j];
                    }
                }
            }
            max = Math.max(sum, max);
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}