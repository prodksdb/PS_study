import java.io.*;
import java.util.*;

public class Main {

	static int[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			result = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int j = 0; j < 6; j++) {
				result[j][0] = Integer.parseInt(st.nextToken()); // 승
				result[j][1] = Integer.parseInt(st.nextToken()); // 무
				result[j][2] = Integer.parseInt(st.nextToken()); // 패
				sum += result[j][0] + result[j][1] + result[j][2];

			}

			if (sum > 30) {
				sb.append("0 ");
			} else {
				if (match(0, 1)) {
					sb.append("1 ");
				} else {
					sb.append("0 ");
				}
			}
		}
		System.out.println(sb);
	}

	// win 2 tie 1 lose 0
	public static boolean match(int i, int j) {

		if (j == 6) {
			i++;
			j = i + 1;
		}

		if (i == 5) {
			return true;
		}

		// team1이 이길 경우
		if (result[i][0] != 0 && result[j][2] != 0) {
			result[i][0]--;
			result[j][2]--;
			if (match(i, j + 1))
				return true;
			result[i][0]++;
			result[j][2]++;

		} // team1과 team2가 무승부일 경우
		if (result[i][1] != 0 && result[j][1] != 0) {
			result[i][1]--;
			result[j][1]--;
			if (match(i, j + 1))
				return true;
			result[j][1]++;
			result[i][1]++;

		} // team2가 이길 경우
		if (result[i][2] != 0 && result[j][0] != 0) {
			result[i][2]--;
			result[j][0]--;
			if (match(i, j + 1))
				return true;
			result[i][2]++;
			result[j][0]++;
		}

		// 어떠한 경우도 아닐 경우
		return false;

	}

}