import java.io.*;
import java.util.*;

public class Main {
	
	static PriorityQueue <Integer> minq; //큰 숫자들 저장
	static PriorityQueue <Integer> maxq; //작은 숫자들 저장 
	static int medium;
	
	public static void addNumber(int num) {
		if(minq.isEmpty() || num <= maxq.peek()) {
			maxq.offer(num);
		}else {
			minq.offer(num);
		}
		
		// 큐의 크기 조정하여 균형 유지 
		if(maxq.size() > minq.size() + 1) {
			minq.offer(maxq.poll());
		}else if(minq.size() > maxq.size()) {
			maxq.offer(minq.poll());
		}
		
		//중앙값
		medium = maxq.peek();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		maxq = new PriorityQueue<>(Collections.reverseOrder());
		minq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			addNumber(num);
			sb.append(medium+"\n");
		}
		
		bw.write(sb + "");
		bw.flush();
		br.close();
		bw.close();
	}
}