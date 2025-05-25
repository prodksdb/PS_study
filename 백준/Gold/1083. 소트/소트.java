import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int S = sc.nextInt();

        for (int i = 0; i < N && S > 0; i++) {
            // 현재 i 위치에서 S 범위 안에서 최대값 찾기
            int maxIdx = i;
            for (int j = i + 1; j < N && j - i <= S; j++) {
                if (A[j] > A[maxIdx]) {
                    maxIdx = j;
                }
            }

            // maxIdx 값을 앞으로 당기기 (필요한 swap 수는 maxIdx - i)
            for (int j = maxIdx; j > i; j--) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
            }

            S -= (maxIdx - i);
        }

        // 출력
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}