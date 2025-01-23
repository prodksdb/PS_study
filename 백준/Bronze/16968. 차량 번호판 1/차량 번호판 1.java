import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		br.close();

		int result = possibleSituation(input);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	public static int possibleSituation(String s) {
		int total = 1;
		char prev = ' ';

		for (char c : s.toCharArray()) {
			if (c == 'c') {
				if (prev == 'c') {
					total *= 25; // 같은 문자가 연속해서 나타나지 않도록 25개 선택
				} else {
					total *= 26; // 모든 문자를 선택할 수 있음
				}
			} else if (c == 'd') {
				if (prev == 'd') {
					total *= 9; // 같은 숫자가 연속해서 나타나지 않도록 9개 선택
				} else {
					total *= 10; // 모든 숫자를 선택할 수 있음
				}
			}
			prev = c;
		}

		return total;
	}
}
