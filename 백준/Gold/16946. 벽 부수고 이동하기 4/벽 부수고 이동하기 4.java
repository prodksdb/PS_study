import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] groupMap;
    static Map<Integer, Integer> groupSizeMap = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        groupMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        // Step 1: 0들의 그룹을 찾고 크기 계산
        int groupId = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && groupMap[i][j] == 0) {
                    int size = bfs(i, j, groupId);
                    groupSizeMap.put(groupId, size);
                    groupId++;
                }
            }
        }
        
        // Step 2: 벽을 부쉈을 때 이동할 수 있는 칸 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    sb.append(getReachableCount(i, j));
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static int bfs(int x, int y, int groupId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        groupMap[x][y] = groupId;
        int size = 1;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0], cy = pos[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && groupMap[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    groupMap[nx][ny] = groupId;
                    size++;
                }
            }
        }
        return size;
    }
    
    static int getReachableCount(int x, int y) {
        Set<Integer> adjacentGroups = new HashSet<>();
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && groupMap[nx][ny] > 0) {
                adjacentGroups.add(groupMap[nx][ny]);
            }
        }
        
        int count = 1; // 벽을 부수면서 생기는 본인 위치 포함
        for (int groupId : adjacentGroups) {
            count += groupSizeMap.get(groupId);
        }
        return count % 10;
    }
}