import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static long P, Q;
    static HashMap<Long, Long> memo = new HashMap<>();

    public static long getValue(long n) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        long val = getValue(n / P) + getValue(n / Q);
        memo.put(n, val);
        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();

        System.out.println(getValue(N));
    }
}