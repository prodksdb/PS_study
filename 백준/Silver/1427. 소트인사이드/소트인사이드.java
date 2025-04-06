import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String st = br.readLine();
        Integer [] chars = new Integer[st.length()];
        int a = 0;
        for(char c : st.toCharArray()){
            chars[a] = Integer.parseInt(String.valueOf(c));
            a++;
        }

        Arrays.sort(chars, Collections.reverseOrder());

        for(int i = 0; i < st.length(); i++){
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}