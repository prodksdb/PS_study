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
		
		// 1번째줄 입력 처리 
		int N = Integer.parseInt(br.readLine().trim());
		//누적합 sum 선언 및 초기화 
		int sum = 0;
		
		//2번째줄 입력 처리 
		String[] Input = br.readLine().trim().split(" ");
		
		//각 사람이 돈을 인출하는데 걸리는 시간을 저장할 리스트 
		List<Integer> time = new ArrayList<>();
		
		//반복문을 통해 정수 list에 저장한 후 합 누적하기 
		for(int i = 0; i < N; i++) {
			time.add(Integer.parseInt(Input[i]));	
		}
		
		//시간을 오름차순으로 정렬
		Collections.sort(time);
		
		//sum은 최종합, sum2는 누적합
		int finalSum = 0;
		int initialSum = 0;
		
		for(int t: time) {
			initialSum += t;
			finalSum += initialSum;
		}
			
		//String.valueOf : 다양한 데이터 타입을 문자열로 변환할 때 사용하는 정적 메서드 
		bw.write(String.valueOf(finalSum));
	
		bw.flush();
		br.close();
		bw.close();
	}

}