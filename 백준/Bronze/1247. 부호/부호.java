import java.io.*;
import java.math.BigInteger;
public class Main{
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	for(int test_case = 1; test_case <= 3; test_case++) {
		int N = Integer.parseInt(br.readLine());
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i <= N; i++) {
			BigInteger num = new BigInteger(br.readLine());
			//BigInteger 덧셈
			sum = sum.add(num);
		}
		
		//부호 판별하기 
		//compareTo()는 비교 결과를 int 값으로 반환한다!
		if(sum.compareTo(BigInteger.ZERO) > 0) {
			System.out.println("+");
		}else if(sum.compareTo(BigInteger.ZERO) == 0) {
			System.out.println("0");
		}else {
			System.out.println("-");
		}
	}
	
	br.close();
}	
}
