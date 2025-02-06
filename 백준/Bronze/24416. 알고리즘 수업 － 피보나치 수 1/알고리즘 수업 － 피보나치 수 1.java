import java.io.*;

public class Main {
    static int count1 = 0; // 코드1 (재귀 호출) 실행 횟수
    static int count2 = 0; // 코드2 (DP 반복문) 실행 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine().trim());

        // 재귀 함수 실행
        fib(n);

        // 동적 프로그래밍 실행
        fibonacci(n);

        // 결과 출력
        bw.write(count1 + " " + count2 + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    // 재귀 방식 (코드1 실행 횟수 계산)
    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++; 
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 동적 프로그래밍 방식 (코드2 실행 횟수 계산)
    static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count2++; 
        }

        return f[n];
    }
}
