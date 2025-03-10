import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        for (int t = 1; t <= T; t++) {
            String original = br.readLine(); 
            int changes = 0;
            char prev = '0'; 

            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) != prev) {
                    changes++;
                    prev = original.charAt(i); 
                }
            }

            System.out.println("#" + t + " " + changes);
        }
    }
}