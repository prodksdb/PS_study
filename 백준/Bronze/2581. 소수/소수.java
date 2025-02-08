import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine().trim());
		int N = Integer.parseInt(br.readLine().trim());
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = Math.max(M, 2); i <= N; i++) {
			int count = 0;
			for(int j = 2; j * j <= i; j++) {
				if(i % j == 0) {
					count++;
					break;
				}
			}
			if(count == 0) {
				numbers.add(i);
			}
		}
	
		
		if(numbers.isEmpty()) {
			bw.write("-1");
		}else {
			int sum = 0;
			for(int num:numbers) {
				sum += num;
			}
			bw.write(String.valueOf(sum));
			bw.newLine();
			bw.write(numbers.get(0).toString());
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}