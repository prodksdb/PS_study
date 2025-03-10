import java.io.*;
import java.util.*;

public class Solution {
    // 팰린드롬 판별 함수
    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); 

        StringBuilder result = new StringBuilder();
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int count = 0;

            // A ~ B 범위 내에서 제곱 팰린드롬 수 찾기
            for (int i = A; i <= B; i++) {
                if (isPalindrome(i)) { // N이 팰린드롬인가?
                    int sqrt = (int) Math.sqrt(i);
                    if (sqrt * sqrt == i && isPalindrome(sqrt)) { // √N도 팰린드롬인가?
                        count++;
                    }
                }
            }

            result.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.print(result.toString());
    }
}