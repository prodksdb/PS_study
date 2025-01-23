import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄에 R과 C 입력 받기 
		String [] input = br.readLine().trim().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);

		// R X C 크기의 그리드 선언
		char [][] grid = new char[R][C];


		//outerloop, boolean 플래그...? 


		//dx, dy 배열을 만들어 상하좌우에 해당하는 병화량 정의 
		int[] dx = {-1, 1, 0, 0}; //상, 하, 좌, 우에 대한 x 변화
		int[] dy = {0, 0, -1, 1}; //상, 하, 좌, 우에 대한 y 변화 

		// R개의 줄별로 문자열을 읽고 그리드에 문자 입력 
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C;j++) {
				grid[i][j] = line.charAt(j);//문자열에서 charAt으로 문자를 읽는다
			}
		}

		//메서드 호출 : install 메소드가 반환하는 값은 result라는 변수에 저장 
		int result = install(grid, R, C, dx, dy);

		System.out.println(result);
		if(result == 1) {
			for (int l = 0; l< R; l++) {
				System.out.println(new String(grid[l]));
			}
		}
		br.close();
	}

	//탐색 및 울타리 설치를 하나의 책임으로 관리하기 위해 메서드를 따로 만들었음 
	private static int install(char[][] grid, int R, int C, int [] dx, int[] dy) {

		for(int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 'S') {
					//상하좌우 탐색
					for(int k = 0; k <4; k++) {
						int nx = i+dx[k];
						int ny = j + dy[k];
						//인덱스 범위 체크 
						if(nx >= 0 && nx < R && ny >=0 && ny < C) {
							if(grid[nx][ny] == 'W') {
								return 0; //즉시 탐색 종료 
							}
							if(grid[nx][ny]== '.') {
								grid[nx][ny] = 'D';
							}
						}

					}
				}
			}
		}
		return 1; //모든 탐색 끝난 경우 
	}
}

