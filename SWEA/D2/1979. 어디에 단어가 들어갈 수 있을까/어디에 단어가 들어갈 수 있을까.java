import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int K;
	static int [][] exist; //단어가 들어있는지 안들어있는지
	static int count;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String [] input = br.readLine().trim().split(" ");
			N = Integer.parseInt(input[0]);  //N*N 퍼즐의 크기 
			K = Integer.parseInt(input[1]);  //K 특정 길이의 단어 
			
			exist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String [] input1 = br.readLine().trim().split(" ");
				for(int j = 0; j < N; j++) {
					exist[i][j] = Integer.parseInt(input1[j]);
				}
			}
			
			result = 0;
			
			//가로 검사 
			for(int i = 0; i < N; i++) {
				count = 0;
				for(int j = 0; j < N; j++) {
					if( exist[i][j] == 1) {
						count++;
					}else{
						if(count == K) result++;
							count = 0;
				
					}
				}
				if(count == K) result++; //마지막 칸도 세기 
			}
			
			
			//세로 검사 
			for(int j = 0; j < N; j++) {
				count = 0;
				for(int i = 0; i < N; i++) {
					if(exist[i][j] == 1) {
						count++;
					}else {
						if(count == K) result++;
							count = 0;
						
					}
				}
				if(count == K) result++; //마지막 칸도 세기 
			}
		
		
			sb.append("#"+test_case+" "+ result +"\n");
		}
		System.out.println(sb);
		
	}
}