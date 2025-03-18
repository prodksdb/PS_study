import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		temp.push(-1);
		for (int i = N - 2; i >= 0; i--) {
			if (A[i] < A[i + 1]) {
				stack.push(A[i + 1]);
				temp.push(A[i + 1]);
			} // A[i] >= A[i+1]
			else {
				while (!stack.isEmpty() && stack.peek() <= A[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					temp.push(-1);
				} else {
					temp.push(stack.peek());
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!temp.isEmpty()) {
			sb.append(temp.pop() + " ");
		}

		System.out.println(sb);
	}
}