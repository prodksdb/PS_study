import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int totalSum = 0;
		int [] arr = new int[9];
		for(int i = 0; i < 9; i ++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			totalSum += arr[i];
		}
		
		Arrays.sort(arr);

		int targetSum = totalSum - 100;
		int a= 0;
		int b = 0;
		for(int i = 0, j = 8; i < j; ) {
			int currentSum = arr[i] + arr[j];
			if(currentSum == targetSum ) {
				a = i;
				b = j;
				break;
			}else if(currentSum < targetSum) {
				i++;
			}else {
				j--;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			if( i!= a && i!= b) {
				bw.write(arr[i] + "\n");
			}
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}