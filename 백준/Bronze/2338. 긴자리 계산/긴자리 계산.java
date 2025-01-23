import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BigInteger A =  new BigInteger(br.readLine().trim());
		BigInteger B =  new BigInteger(br.readLine().trim());
	
		
		bw.write(A.add(B).toString()+"\n");
		bw.write(A.subtract(B).toString()+"\n");
		bw.write(A.multiply(B).toString()+"\n");
		
		
		bw.flush();
		br.close();
		bw.close();
	}

}
