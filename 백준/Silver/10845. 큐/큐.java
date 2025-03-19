import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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
					System.out.println(deque.pop());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if (!deque.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
				break;
			case "front":
				if (!deque.isEmpty()) {
					System.out.println(deque.peekFirst());
				} else {
					System.out.println(-1);
				}
				break;
			case "back":
				if (!deque.isEmpty()) {
					System.out.println(deque.peekLast());
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}