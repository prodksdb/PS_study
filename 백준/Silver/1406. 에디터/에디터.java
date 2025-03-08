import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 leftStack에 삽입
        for (char c : string.toCharArray()) {
            leftStack.push(c);
        }



        for (int i = 0; i < N; i++) {

            // 편집 명령어 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String edit = st.nextToken();

            //명령어 수행하기
            if (edit.equals("L")) { // 커서 왼쪽으로 한 칸 이동, 맨 앞이면 무시
                if(!leftStack.isEmpty()){
                    rightStack.push(leftStack.pop());
                }
            } else if (edit.equals("D")) {  //커서 오른쪽으로 한 칸 이동, 맨 뒤면 무시
                if(!rightStack.isEmpty()){
                    leftStack.push(rightStack.pop());
                }
            } else if (edit.equals("B")) {  // 커서 왼쪽에 있는 문자 삭제, 맨 앞이면 무시
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }
            }
            // edit.equals("P")
            else { // 문자를 커서 왼쪽에 추가
                leftStack.push(st.nextToken().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> r = new Stack<>();
        while(!leftStack.isEmpty()){
            r.push(leftStack.pop());
        }

        while(!r.isEmpty()){
            sb.append(r.pop());
        }

        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}