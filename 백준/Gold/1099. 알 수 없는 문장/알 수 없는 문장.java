import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();
        int N = sc.nextInt();

        Map<String, List<String>> dict = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            String sorted = sortString(word);
            dict.putIfAbsent(sorted, new ArrayList<>());
            dict.get(sorted).add(word);
        }

        int len = sentence.length();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < len; i++) {
            if (dp[i] == INF) continue;

            for (int j = i + 1; j <= len; j++) {
                String sub = sentence.substring(i, j);
                String sorted = sortString(sub);
                if (dict.containsKey(sorted)) {
                    for (String word : dict.get(sorted)) {
                        if (word.length() == sub.length()) {
                            int cost = calcCost(sub, word);
                            dp[j] = Math.min(dp[j], dp[i] + cost);
                        }
                    }
                }
            }
        }

        System.out.println(dp[len] == INF ? -1 : dp[len]);
    }

    static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    static int calcCost(String a, String b) {
        int cost = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cost++;
        }
        return cost;
    }
}