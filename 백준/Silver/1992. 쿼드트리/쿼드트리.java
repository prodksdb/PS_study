import java.io.*;
import java.util.*;

public class Main {
	
	static int [][] quadTree;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());
		
		quadTree = new int[N][N];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				quadTree[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		
		
		checkTree(0, 0, N);
		System.out.println(sb.toString());
		
	}
	
	public static void checkTree(int x, int y, int size) {
		
		if(size == 1) {
			sb.append(quadTree[x][y]);
			return;
		}
		
		int sum = 0;
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y + size; j++) {
				sum += quadTree[i][j];
			}
		}
		
		if( sum == size*size) {
			sb.append(1);
		}else if( sum == 0) {
			sb.append(0);
		}else {
			int treeSize = size / 2;
			
			sb.append("(");
			checkTree(x, y, treeSize);  //좌상
			checkTree(x, y + treeSize, treeSize); //우상
			checkTree(x+treeSize, y, treeSize);  // 좌하 
			checkTree(x+treeSize, y+treeSize, treeSize); //우하
			sb.append(")");
		}
		
		
	}
}