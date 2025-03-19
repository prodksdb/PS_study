import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}

			switch (s) {
			case "push":
				deque.offer(num);
				break;
			case "pop":
				if (!deque.isEmpty()) {
					sb.append(deque.pop() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			case "size":
				sb.append(deque.size() + "\n");
				break;
			case "empty":
				if (deque.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;
			case "front":
				if (!deque.isEmpty()) {
					sb.append(deque.peekFirst() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			case "back":
				if (!deque.isEmpty()) {
					sb.append(deque.peekLast() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}