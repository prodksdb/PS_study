import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine().trim());		
			String [] price = br.readLine().trim().split(" ");
			
			int maxPrice = 0;
			long profit = 0;
			
			
			for(int i = N-1; i >=0; i--) {
				
				int currentPrice = Integer.parseInt(price[i]);
				
				if(currentPrice> maxPrice) {
					maxPrice = currentPrice;
				}else {
					profit += maxPrice - currentPrice;
			}
		}
		
			bw.write("#"+(t+1)+" "+profit+"\n");
	}

		bw.flush();
		br.close();
		bw.close();
	}
}
