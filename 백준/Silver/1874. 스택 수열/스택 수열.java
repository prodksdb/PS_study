import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int currentNumber = 1;  //스택에 push할 숫자
        boolean possible = true; // 수열이 가능한지 여부

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            //target이 현재 넣을 숫자보다 크다면, target까지 push
            while(currentNumber <= target){
                stack.push(currentNumber++);
                sb.append("+\n");
            }

            // 스택의 top이 target과 같은 경우 pop
            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            }else{
                possible = false;
                break;
            }
        }

        if(possible){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}