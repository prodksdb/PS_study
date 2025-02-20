import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static String input;
	static Deque<Character> stack;
	static char before;

	public static void check(char a, char b) {
		if (a == b) {
			stack.pop();
			return;
		}
		stack.push(b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			input = st.nextToken();
			stack = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				if (!stack.isEmpty()) {
					before = stack.peek();
					check(before, input.charAt(i));
				} else {
					stack.push(input.charAt(i));
				}
			}
			sb.append("#" + test_case + " ");
			
			StringBuilder s = new StringBuilder();
			for(char c : stack) {
				s.append(c);
			}
			sb.append(s.reverse()+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}