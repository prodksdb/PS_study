import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
			String [] Input = br.readLine().trim().split(" ");
			List<Integer> list = new ArrayList<>();

			for(int i = 0; i < 10; i++) { 
				list.add(Integer.parseInt(Input[i]));
			}

			Collections.sort(list);
			list.remove(list.size()-1);
			list.remove(0);

			int sum = 0;
			
			for(int num : list) {
				sum += num;
			}

			Integer AVERAGE = (int)Math.round((double)sum / list.size());

			bw.write("#"+test_case+" "+AVERAGE);
			bw.newLine();


		}

		bw.flush();
		br.close();
		bw.close();
	}

}
