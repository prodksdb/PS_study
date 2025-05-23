import java.util.*;

public class Main {
    static String N;
    static int K;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.next();
        K = sc.nextInt();

        // 숫자가 한 자리이거나, 두 자리인데 10의 자리와 1의 자리를 바꾸면 0이 되는 경우
        if (N.length() == 1 || (N.length() == 2 && N.charAt(1) == '0')) {
            System.out.println(-1);
            return;
        }

        visited = new boolean[K + 1][1000001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visited[0][Integer.parseInt(N)] = true;

        int answer = -1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.cnt == K) {
                answer = Math.max(answer, Integer.parseInt(current.num));
                continue;
            }

            for (int i = 0; i < current.num.length(); i++) {
                for (int j = i + 1; j < current.num.length(); j++) {
                    String swapped = swap(current.num, i, j);

                    if (swapped.charAt(0) == '0') continue;

                    int numInt = Integer.parseInt(swapped);
                    if (!visited[current.cnt + 1][numInt]) {
                        visited[current.cnt + 1][numInt] = true;
                        queue.add(new Node(swapped, current.cnt + 1));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    static class Node {
        String num;
        int cnt;

        Node(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}