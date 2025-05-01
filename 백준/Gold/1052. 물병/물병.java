import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 현재 1리터 물병 수
        int K = sc.nextInt(); // 최대 비어있지 않은 물병 수
        int buy = 0;

        // N을 하나씩 증가시키며 1의 개수(K개 이하 될 때까지)를 확인
        while (Integer.bitCount(N) > K) {
            buy++;
            N++;
        }

        System.out.println(buy);
    }
}