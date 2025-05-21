import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] tickets;
	static int[] plan;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			tickets = new int[4];
			plan = new int[12];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				tickets[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			result = Integer.MAX_VALUE;
			swimmingpool(0, 0);
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}

	static void swimmingpool(int month, int paied) {
		if (result < paied) {
			return;
		}
		if (month >= 12) {
			if (result > paied) {
				result = paied;
			}
			return;
		}

		swimmingpool(month + 1, paied + (tickets[0] * plan[month]));
		swimmingpool(month + 1, paied + tickets[1]);
		swimmingpool(month + 3, paied + tickets[2]);
		swimmingpool(month + 12, paied + tickets[3]);
	}
}