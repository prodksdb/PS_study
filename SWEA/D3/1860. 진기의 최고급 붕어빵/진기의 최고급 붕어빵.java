import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, K;
	static int[] people;
	static int Bungeobbang;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 자격을 얻은 사람들
			M = Integer.parseInt(st.nextToken()); // 걸리는 시간
			K = Integer.parseInt(st.nextToken()); // 붕어빵의 개수

			st = new StringTokenizer(br.readLine());
			people = new int[N];
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(people);

			sb.append("#" + test_case + " ");

			Bungeobbang = 0;
			if (isPossible()) {
				sb.append("Possible");
			} else {
				sb.append("Impossible");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean isPossible() {
		// 예약한 손님들이 가져간 붕어빵의 개수
		int count = 0;
		for (int i = 0; i < N; i++) {

			// 예약한 손님들이 도착하는 시간 
			int arriveTime = people[i];
			// 만약 도착한 시간이 붕어빵 생성시간 M초보다 짧을 경우
			if (arriveTime < M) {
				return false;
			} // 도착한 시간이 붕어빵 생성시간 M초보다 길 경우
			else {
				// 도착한 시간에 남아있는 붕어빵의 개수
				Bungeobbang = arriveTime / M * K;
				// 도착한 시간에 붕어빵이 있을 경우
				if (Bungeobbang - count > 0) {
					count ++;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
