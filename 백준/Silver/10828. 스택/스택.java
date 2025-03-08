import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

       for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();
            if(order.equals("push")){
                int X = Integer.parseInt(st.nextToken());
                stack.push(X);
            }else if(order.equals("top")){
                if(!stack.isEmpty()){
                    sb.append(stack.peek()).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }else if(order.equals("size")){
                sb.append(stack.size()).append("\n");
            }else if(order.equals("empty")){
                if(!stack.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append("1\n");
                }
            } else if(order.equals("pop")){
                if(!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }
        }
        System.out.println(sb);
    }
}