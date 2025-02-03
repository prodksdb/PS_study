import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class Main{
	                 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int N = line.length();
		char[] array = line.toCharArray();
		//알파벳 순으로 정렬
		Arrays.sort(array);
		
		//HashMap은 순서 보장x(빠른 접근 속도), TreeMap은 순서 보장(정렬된 상태 유지)
		//HashMap은 순서를 보장하지 않아서 TreemMap을 사용해야한다. 
		//TreeMap을 사용하면 keySet()을 사용할 때 항상 알파벳 순서로 정렬된 키를 가져옴
		Map<String, Integer> map = new TreeMap<>();

		
		for(char c : array) {
			map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
		}
		
		//keySet에 key값을 통해 알파벳의 중복횟수 확인하려고 
		Set<String> set = map.keySet();
		StringBuilder front = new StringBuilder("");
		StringBuilder middle = new StringBuilder("");
		int count = 0;
		
		for(String s : set) {
			//key의 value값, 즉 알파벳의 갯수가 짝수이면 상관없음
			//알파벳의 갯수가 홀수이면 홀수인 갯수가 1개여야함
			if(map.get(s) % 2 == 0) {
				for(int i = 1; i <= map.get(s) / 2; i++) {
				front.append(s);
				}
			}else {
				count++;
				middle.append(s);
				
				if(count >= 2) {
					bw.write("I'm Sorry Hansoo");
					bw.flush();
					return;
				}
				
				//남은 문자 중 절반을 front에 추가 (홀수 개수에서 1개 제외 후 /2
				for(int i = 1; i<=(map.get(s)-1)/2;i++) {
					front.append(s);
				}
			}
		}
		
		StringBuilder back = new StringBuilder(front).reverse();
		
		bw.write(front.toString()+ middle.toString()+back.toString());

		bw.flush();
		br.close();
		bw.close();
	}
	
	
}
