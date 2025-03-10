import java.io.*;
import java.util.*;

public class Main {
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		count = 0;
		int arraySize = (int) Math.pow(2, N);
		visit(r, c, arraySize);

		bw.write(count + "");
		bw.flush();
		br.close();
		bw.close();
	}

	private static void visit(int row, int col, int size) {

		if (size == 1) {
			return;
		}

		size /= 2;

		// size * size 배열이 또 분할되는 경우
		if (row >= size && col >= size) {
			count += size * size * 3;
			visit(row - size, col - size, size);
		} // size * size 배열이 행은 분할되고 열은 분할되지 않을 경우
		else if (row >= size && col < size) {
			count += size * size * 2;
			visit(row - size, col, size);
		} // size * size 배열이 행은 분할되지 않고 열은 분할될 경우
		else if (row < size && col >= size) {
			count += size * size;
			visit(row, col - size, size);
		} // size * size 배열이 더 이상 분리되지 않을 경우
		else {
			visit(row, col, size);
		}
	}
}