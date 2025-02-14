import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class  Solution {
	public static void main(String[] args) throws IOException {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st = br.readLine();

		String result = st.toUpperCase();

		bw.write(result);

		bw.flush();
		br.close();
		bw.close();
	}
}
