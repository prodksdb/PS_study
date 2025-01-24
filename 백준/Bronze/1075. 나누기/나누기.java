import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int F = scanner.nextInt();

        int base = (N / 100) * 100;

        int result = 0;
        for (int i = 0; i < 100; i++) {
            if ((base + i) % F == 0) {
                result = i;
                break;
            }
        }

        System.out.printf("%02d\n", result);
    }
}
