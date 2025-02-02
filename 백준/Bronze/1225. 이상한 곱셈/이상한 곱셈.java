import java.util.*;
import java.io.*;
public class Main{
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	String A = st.nextToken();
	String B = st.nextToken();
	long Sum = 0;
	
	if(A.equals("0") || B.equals("0")) {
		System.out.println(0);
		return;	
	}
	
	for(int i = 0; i < A.length(); i++) {
		for(int j = 0; j < B.length(); j++ ) {
			Sum += (A.charAt(i)-'0')*(B.charAt(j)-'0');
		}
	}
	
	System.out.println(Sum);
}
		
}
