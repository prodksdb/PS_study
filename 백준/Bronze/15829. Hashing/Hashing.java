import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int L = Integer.parseInt(br.readLine().trim());
	String input = br.readLine().trim();
	
	long pow = 1;
	long result = 0;
	int mod = 1234567891;
	
	for(int i = 0; i < L; i++) {
		
		//input.charAt(i) -> 문자열 input에서 i번째 문자 가져오는 것!, 문자를 숫자로 변환한 값 저장
		int a = input.charAt(i)-'a'+1;
		// 해시 값을 계산하고, 결과를 모듈러 연산으로 제한한다. result는 이전까지 계산된 해시 값
		result = (result+a*pow) % mod;
		pow = (pow*31) % mod;
	}
	
	bw.write(String.valueOf(result));
	
	bw.flush();
	br.close();
	bw.close();
	}
	
}
