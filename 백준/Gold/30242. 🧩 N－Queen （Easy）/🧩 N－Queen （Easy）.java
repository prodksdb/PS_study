import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] chess;
	static boolean[] col; // 각 열의 사용 여부
	static boolean[] diag1; // 좌대각선 사용 여부(row+col)
	static boolean[] diag2; // 우대각선 사용 여부(row-col+N-1)
	static List<Integer> nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		col = new boolean[N+1];
		diag1 = new boolean[2 * N ];
		diag2 = new boolean[2 * N ];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 퀸이 어디에 있는지 확인, i는 행 chess[i] 열
		for (int i = 0; i < N; i++) {
			chess[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> allNumbers = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			allNumbers.add(i);
		}

		for(int num : chess) {
			if(num!=0) allNumbers.remove(num);
		}
		
		nums = new ArrayList<>(allNumbers);
		Collections.sort(nums);
		
		
		if (!backtrack(0)) {
			System.out.println(-1);	
		} 
	}

	 static boolean backtrack(int row) {
	        if (row == N) {
	            for (int num : chess) {
	                System.out.print(num + " ");
	            }
	            System.out.println();
	            return true;
	        }

	        if (chess[row] != 0) { // Queen already placed
	            int num = chess[row];
	            if (!col[num] && !diag1[row - num + N] && !diag2[row + num]) {
	                col[num] = diag1[row - num + N] = diag2[row + num] = true;
	                if (backtrack(row + 1)) return true;
	                col[num] = diag1[row - num + N] = diag2[row + num] = false;
	            }
	            return false;
	        }

	        for (int num : nums) { // Place a Queen
	            if (!col[num] && !diag1[row - num + N] && !diag2[row + num]) {
	                chess[row] = num;
	                col[num] = diag1[row - num + N] = diag2[row + num] = true;
	                if (backtrack(row + 1)) return true;
	                col[num] = diag1[row - num + N] = diag2[row + num] = false;
	                chess[row] = 0;
	            }
	        }

	        return false;
	    }
}