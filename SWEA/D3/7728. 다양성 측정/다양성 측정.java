import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for (int t = 1; t <= T; t++) {
            String X = br.readLine().trim(); // 다양성을 체크할 숫자
            Set<Character> uniqueDigits = new HashSet<>();
            
            for (char digit : X.toCharArray()) {
                uniqueDigits.add(digit);
            }
            
            System.out.println("#" + t + " " + uniqueDigits.size());
        }
        
        br.close();
    }
}