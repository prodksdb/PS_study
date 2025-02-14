import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j) {
					System.out.print("#");
					continue;
				}
				System.out.print("+");
			}
			System.out.println();
		}
	}
}
