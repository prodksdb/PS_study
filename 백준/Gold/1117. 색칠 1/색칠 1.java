import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

	public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static MyScanner sc = new MyScanner();

	static int pi(String s) {
		return Integer.parseInt(s);
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
	
   	public static void main(String[] args) throws IOException{
	   long W = sc.nextLong();
	   long H = sc.nextLong();
	   long f = sc.nextLong();
	   long c = sc.nextLong();
	   long x1 = sc.nextLong();
	   long y1 = sc.nextLong();
	   long x2 = sc.nextLong();
	   long y2 = sc.nextLong();
        long total = W*H;
        long min = Long.min(W-f, f);
        long height = H/(c+1);
        long unpainted;
        if(x2>min){
            if(min>x1){
                unpainted = (y2-y1)*(x2+min-2*x1)*(c+1);
                
            }
            else{
                unpainted = (y2-y1)*(x2-x1)*(c+1);            
            }
        }
        else{
            unpainted = (y2-y1)*2*(x2-x1)*(c+1);
        }
        out.println(total-unpainted);
        out.flush();
        
	}
	
}