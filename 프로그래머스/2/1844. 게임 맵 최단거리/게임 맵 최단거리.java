import java.util.*;

class Solution {
    
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0, 0, -1, 1};
    static int n, m;
    
    class Point{
        int x; 
        int y; 
        int dist;
        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean [][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Point current = queue.poll();
            
            if( current.x == n-1 && current.y == m-1){
                return current.dist;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] != 0){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, current.dist + 1));
                    }
                }
            }
        }
        return -1;
    }
    
}