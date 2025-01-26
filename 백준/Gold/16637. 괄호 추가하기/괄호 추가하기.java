import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String expression;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        N = Integer.parseInt(br.readLine());
        expression = br.readLine();
        
        // 백트래킹 시작
        dfs(0, Character.getNumericValue(expression.charAt(0))); 
        
        // 결과 출력
        System.out.println(maxResult);
    }

    // DFS 재귀 탐색 함수
    private static void dfs(int index, int currentResult) {
        // 종료 조건: 수식의 끝까지 탐색한 경우
        if (index >= N - 1) {
            maxResult = Math.max(maxResult, currentResult);
            return;
        }

        // 현재 연산자와 다음 숫자
        char operator = expression.charAt(index + 1);
        int nextNum = Character.getNumericValue(expression.charAt(index + 2));

        // 1. 괄호를 추가하지 않고 계산
        int resultWithoutBracket = calculate(currentResult, operator, nextNum);
        dfs(index + 2, resultWithoutBracket);

        // 2. 괄호를 추가하는 경우
        if (index + 4 < N) {
            char nextOperator = expression.charAt(index + 3);
            int nextNextNum = Character.getNumericValue(expression.charAt(index + 4));
            
            // 괄호 안의 값을 계산
            int resultInBracket = calculate(nextNum, nextOperator, nextNextNum);
            
            // 괄호 계산 결과를 현재 결과에 반영
            int resultWithBracket = calculate(currentResult, operator, resultInBracket);
            dfs(index + 4, resultWithBracket);
        }
    }

    // 연산을 수행하는 함수
    private static int calculate(int a, char operator, int b) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
