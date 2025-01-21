import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 0; test_case <T; test_case++) {
			
			int n = Integer.parseInt(br.readLine().trim());
			String input1 [] = br.readLine().trim().split(" ");
			String input2 [] = br.readLine().trim().split(" ");
			
			int [] A = new int[n];
			int [] B = new int[n];
		
			for(int i = 0; i <n; i++) {
				A[i] = Integer.parseInt(input1[i]);
				B[i] = Integer.parseInt(input2[i]);
			}
			
			if(n == 1) {
				bw.write(Math.max(A[0], B[0])+"\n");
				continue;
			}
			
			// DP 배열 정의
            int[] dpA = new int[n]; // 위쪽 스티커를 선택했을 때
            int[] dpB = new int[n]; // 아래쪽 스티커를 선택했을 때
            
            // 초기화
            dpA[0] = A[0];
            dpB[0] = B[0];
            dpA[1] = B[0] + A[1];
            dpB[1] = A[0] + B[1];
            
            // DP 점화식 계산
            for (int i = 2; i < n; i++) {
		            //dpA[i] : i번째 열에서 위쪽 스티커를 선택했을때 얻을 수 있는 최대 점수 
                dpA[i] = Math.max(dpB[i - 1], dpB[i - 2]) + A[i];
                //dpB[i] : i번째 열에서 아래쪽 스티커를 선택했을 때 얻을 수 있는 최대 점수 
                dpB[i] = Math.max(dpA[i - 1], dpA[i - 2]) + B[i];
            }

			
			//최대값 계산
			int maxResult = Math.max(dpA[n-1],dpB[n-1]);
			bw.write(maxResult+"\n");
			
		}
		
		bw.flush();
		br.close();
		bw.close();

	}
	
}
	