import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        Integer[] cranes = new Integer[N];
        for (int i = 0; i < N; i++) cranes[i] = sc.nextInt();

        int M = sc.nextInt(); 
        Integer[] boxes = new Integer[M];
        for (int i = 0; i < M; i++) boxes[i] = sc.nextInt();

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        if (boxes[0] > cranes[0]) {
            System.out.println(-1); 
            return;
        }

        boolean[] visited = new boolean[M];
        int moved = 0;
        int time = 0;

        while (moved < M) {
            int boxIdx = 0;
            for (int i = 0; i < N; i++) {
                while (boxIdx < M) {
                    if (!visited[boxIdx] && cranes[i] >= boxes[boxIdx]) {
                        visited[boxIdx] = true;
                        moved++;
                        boxIdx++;
                        break;
                    }
                    boxIdx++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}