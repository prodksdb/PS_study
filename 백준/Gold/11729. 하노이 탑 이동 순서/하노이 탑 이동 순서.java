import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int N;
	static int K;
	static StringBuilder sb = new StringBuilder();
	static int count;
	
	static void move(int n, int a, int b, int mid ) {
		if( n == 1 ) {
			sb.append(a).append(" ").append(b).append("\n");
			count++;
			return;
		}
		

		//1. N-1개의 원판을 첫 번째 탑에서 두 번째 탑으로 옮김(임시 저장) 
		move(n-1, a, mid, b);		
		//2. 가장 큰 원판(맨 아래 원판)을 3번째 탑으로 옮김
		sb.append(a).append(" ").append(b).append("\n");
		count++;
		//3. 두 번째 탑에 있던 N-1개의 원판을 세 번째 탑으로 옮김. 
		move(n-1, mid, b, a);
	
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		
		move(N, 1, 3, 2);
		bw.write(count+"\n");
		bw.write(sb+"");
		
		bw.flush();
		br.close();
		bw.close();

		
		
	
	}
}

