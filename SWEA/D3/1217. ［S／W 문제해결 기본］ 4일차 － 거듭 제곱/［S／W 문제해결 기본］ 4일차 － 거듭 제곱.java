import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++){
            int T = sc.nextInt(); 
            int N = sc.nextInt(); 
            int M = sc.nextInt(); 
            int result = power(N, M);
            System.out.println("#"+T+" "+result );
        }
    }

    public static int power(int n, int m){
        if (m == 0) return 1;
        if (m == 1) return n;

        int half = power(n, m / 2);
        return (m % 2 == 0) ? half * half : half * half * n;
    }
}