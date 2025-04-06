import java.io.*;
import java.util.*;

public class Main {
    static class Location {
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Location> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Location(x, y));
        }

        // y 좌표 오름차순 정렬, y가 같으면 x 좌표 오름차순 정렬
        list.sort(Comparator.comparingInt((Location l) -> l.y)
                .thenComparingInt(l -> l.x));

        for (Location l : list) {
            sb.append(l.x).append(" ").append(l.y).append("\n");
        }
        System.out.print(sb);
    }
}