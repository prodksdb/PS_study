import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 탑의 수
		int[] towers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}

		int[] answers = new int[N];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
				stack.pop();
			}

			answers[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int num : answers) {
			sb.append(num + " ");
		}
		System.out.println(sb);
	}

}