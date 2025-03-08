import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            for(char c : input.toCharArray()){
                if(c == '<'){
                    if(!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                }else if( c == '>'){
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                }else if( c == '-'){
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                }else{
                    leftStack.push(c);
                }
            }

            while(!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
            }


            while(!rightStack.isEmpty()){
                sb.append(rightStack.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}