import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); 

        String[] lamps = new String[N];
        for (int i = 0; i < N; i++) {
            lamps[i] = sc.next();
        }

        int K = sc.nextInt();

        Map<String, Integer> rowCount = new HashMap<>();
        int max = 0;

        for (String row : lamps) {
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
                max = Math.max(max, rowCount.get(row));
            }
        }

        System.out.println(max);
    }
}