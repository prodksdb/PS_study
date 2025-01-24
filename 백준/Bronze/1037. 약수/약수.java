import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int[] divisors = new int[count];
        for (int i = 0; i < count; i++) {
            divisors[i] = scanner.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int divisor : divisors) {
            if (divisor < min) {
                min = divisor;
            }
            if (divisor > max) {
                max = divisor;
            }
        }
        
        int N = min * max;

        System.out.println(N);
    }
}
