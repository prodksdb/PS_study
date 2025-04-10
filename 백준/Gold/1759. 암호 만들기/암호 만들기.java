import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static String[] arr;
	static StringBuilder sb = new StringBuilder();
	static final Set<Character> VOWELS = new HashSet<>();
	static {
	    VOWELS.add('a');
	    VOWELS.add('e');
	    VOWELS.add('i');
	    VOWELS.add('o');
	    VOWELS.add('u');
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}

		Arrays.sort(arr);
		dfs(0, 0, 0, 0, new StringBuilder());

		System.out.println(sb);
	}

	static void dfs(int start, int depth, int vowelCount, int consonantCount, StringBuilder current) {
		if (depth == L) {
			if (vowelCount >= 1 && consonantCount >= 2) {
				sb.append(current).append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			char ch = arr[i].charAt(0);
			current.append(ch); // 선택

			if (VOWELS.contains(ch)) {
				dfs(i + 1, depth + 1, vowelCount + 1, consonantCount, current); // 탐색
			} else {
				dfs(i + 1, depth + 1, vowelCount, consonantCount + 1, current); // 탐색
			}

			current.deleteCharAt(current.length() - 1); // 선택 취소(백트래킹)
		}
	}
}