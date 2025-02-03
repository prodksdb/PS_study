import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char [][] input = new char[15][15];
		
		for(int i = 0; i <5; i++) {
			String line = br.readLine();
			for(int j = 0; j <line.length(); j++){
					input[i][j] = line.charAt(j);
			}
		}


		for(int i = 0; i < 15;i++) {
			for(int j = 0; j< 5; j++) {
				char c = input[j][i];
				if(c == '\u0000') {
					continue;
				}else {
					bw.write(c);
				}
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
