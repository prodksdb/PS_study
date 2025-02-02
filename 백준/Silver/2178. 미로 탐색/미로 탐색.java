import java.util.*;
import java.io.*;
public class Main{
		static int N, M;
		static int[][] maze;
		//상하좌우
		static int[][] directions = {{-1,0}, {1,0},{0,-1},{0,1}};
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			maze = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < M; j++) {
					//문자를 숫자로 변환하기 위해 '0'을 빼준다
					//'0'의 ASCII 코드 값 = 48
					maze[i][j] = line.charAt(j)-'0';
				}
			}
			
			//최단거리 출력
			System.out.println(bfs(0,0));	
	}
		
		static int bfs(int startX, int startY) {
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] {startX, startY});
			
			while(!queue.isEmpty()) {
				int [] current = queue.poll();
				int x = current[0];
				int y = current[1];
				
				for(int[]dir : directions) {
					int nx = x + dir[0];
					int ny = y + dir[1];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || maze[nx][ny] == 0) {
					continue;
				}
				
				if(maze[nx][ny] == 1) {
					maze[nx][ny] = maze[x][y]+1;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		 // 도착 지점(N-1, M-1)의 거리 값 반환
        return maze[N - 1][M - 1];
		
}
}