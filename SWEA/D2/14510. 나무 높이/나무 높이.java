import java.io.*;
import java.util.*;

class Solution{
	
	static int N;
	static int [] tree;
	static int highTree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T= Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T;test_case++) {
			N = Integer.parseInt(br.readLine());
            tree = new int[N];
            highTree = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				highTree = Math.max(highTree,  tree[i]);
			}
			
			Arrays.sort(tree);
			int one = 0; 
			int two = 0;
			for(int i = 0; i < N; i++) {
				int difference = highTree - tree[i];
				two += difference / 2;
				one += difference % 2;
			}
			while(two - one >= 2) {
				two -= 1;
				one += 2;
			}
			
			int result = 0;
			if( two >= one) {
				result = two*2;
			}else {
				result = one * 2 -1;
			}
			
			sb.append("#"+test_case+" "+result+"\n");
		}
		System.out.println(sb);
	}
}