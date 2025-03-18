import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		long result = 0;
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());

			while (!stack.isEmpty()) {
				if (stack.peek() <= height) {
					stack.pop();
				} else
					break;
			}
			result += stack.size();
			stack.push(height);
		}

		System.out.println(result);
	}
}