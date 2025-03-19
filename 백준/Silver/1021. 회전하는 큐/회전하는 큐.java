import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] number = new int[M];
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			number[i] = num;
		}

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		int count = 0;

		for (int i = 0; i < M; i++) {
			int target = number[i];

			int pos = 0;
			for (int num : deque) {
				if (num == target)
					break;
				pos++;
			}

			if (pos <= deque.size() / 2) {
				for (int j = 0; j < pos; j++) {
					deque.addLast(deque.pollFirst());
					count++;
				}
			} else {
				int rotations = deque.size() - pos;
				for (int j = 0; j < rotations; j++) {
					deque.addFirst(deque.pollLast());
					count++;
				}
			}
			deque.pollFirst();
		}

		System.out.println(count);
	}
}