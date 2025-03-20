import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String p = br.readLine();
			char[] order = new char[p.length()];
			for (int i = 0; i < p.length(); i++) {
				order[i] = p.charAt(i);
			}

			int n = Integer.parseInt(br.readLine());

			String string = br.readLine();
			String string1 = string.replace("[", "");
			String string2 = string1.replace("]", "");
			StringTokenizer st = new StringTokenizer(string2, ", ");

			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				deque.offer(num);
			}

			boolean isError = false;
			int reverse = 0;
			// 명령어 처리하기
			for (int i = 0; i < p.length(); i++) {

				// 뒤집기
				if (order[i] == 'R') {
					reverse++;
				}
				// order[i] == 'D'
				else {
					if (!deque.isEmpty()) {
						// 순서가 거꾸로일 경우
						if (reverse % 2 == 1) {
							deque.removeLast();
						}
						// 순서가 원래대로일 경우, reverse % 2 == 0
						else {
							deque.removeFirst();
						}
					} else {
						sb.append("error\n");
						isError = true;
						break;
					}
				}
			}

		if (!isError) {
				if (!deque.isEmpty()) {
					StringBuilder resultSb = new StringBuilder();
					resultSb.append("[");

					while (!deque.isEmpty()) {
						if (reverse % 2 == 1) {
							resultSb.append(deque.removeLast());
						} else {
							resultSb.append(deque.removeFirst());
						}
						if (!deque.isEmpty()) {
							resultSb.append(",");
						}
					}
					resultSb.append("]");
					sb.append(resultSb + "\n");
				} else {
					sb.append("[]\n");
				}
			}
		}
		System.out.println(sb);
	}
}