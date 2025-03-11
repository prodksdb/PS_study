import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 스네이크버드의 초기 길이 정수

		st = new StringTokenizer(br.readLine(), " ");
		int[] fruits = new int[N];

		// 과일들이 있는 높이
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		// 과일 키 오름차순
		Arrays.sort(fruits);

		for (int i = 0; i < N; i++) {
			// 과일 높이가 스네이크 버드의 길이보다 작거나 같을 때
			if (fruits[i] <= L) {
				L += 1;
			} else {
				break;
			}
		}
		
		System.out.println(L);
	}
}