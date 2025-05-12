import java.io.*;
import java.util.*;

public class Solution {
    static int [][] magnetics;
    static int N, S, total;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++){
            int length = Integer.parseInt(br.readLine());
            magnetics = new int[100][100];
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < 100; j++){
                    magnetics[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            N = 0;
            S = 0;
            total = 0;
            for(int j = 0; j < 100; j++){
                boolean hasN = false;
                for(int i = 0; i < 100; i++){
                    // N극 발견
                    if(magnetics[i][j] == 1){
                        hasN = true;
                    }else if(magnetics[i][j] == 2){
                        if(hasN){    // 앞서 N이 있었고, 그 다음 S가 등장하면 교착
                            total++;
                            hasN = false; // 이 교착은 처리했으므로 초기화
                        }
                    }
                }
            }
            sb.append("#"+test_case+" "+total+"\n");
        }
        System.out.println(sb);
    }
}