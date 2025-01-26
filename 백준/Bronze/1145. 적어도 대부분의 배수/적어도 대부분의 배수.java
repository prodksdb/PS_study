import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] Input = br.readLine().trim().split(" ");
		int [] A = new int[5];
		
		for(int i = 0; i < 5; i++) {
			A[i] = Integer.parseInt(Input[i]);
		}
		
		int x = 1; //최소공배수를 찾기 위한 시작값 
		
		//while(true)는 종료 조건이 명시되지 않는 무한 루프이다. 
		//루프 안에서 조건을 확인하고, 조건을 만족하면 break 키워드를 사용해 종료한다!!
		while(true) {
			int count = 0;   //나누어떨어지는 숫자의 개수 
			for(int num : A) { 
				//x가 배열의 숫자 중 하나로 나누어 떨어지는지 확인 
				if(x % num == 0) { 
					count++;
				}
			}
			//적어도 3개의 숫자로 나누어떨어지면 출력 
			if(count >= 3) {
				bw.write(String.valueOf(x));
				bw.newLine(); //줄바꿈 역할
				break;
			}
			//x를 1씩 증가 
			x++;
	}
		bw.flush();
		br.close();
		bw.close();
		
	}
}
