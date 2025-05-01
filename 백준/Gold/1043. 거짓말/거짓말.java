import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 파티 수
        parent = new int[N + 1];

        // 초기 parent 설정
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int truthCount = sc.nextInt();
        List<Integer> truths = new ArrayList<>();
        for (int i = 0; i < truthCount; i++) {
            truths.add(sc.nextInt());
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int count = sc.nextInt();
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                party.add(sc.nextInt());
            }
            parties.add(party);

            // 같은 파티 사람들끼리 union
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }
        }

        int result = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                for (int truth : truths) {
                    if (find(person) == find(truth)) {
                        canLie = false;
                        break;
                    }
                }
                if (!canLie) break;
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }

    // 유니온 파인드 메서드
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootB] = rootA;
    }
}