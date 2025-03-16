import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 목표값 T 입력
        int T = Integer.parseInt(br.readLine());
        
        // 배열 A 입력
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 B 입력
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A의 부분 배열 합을 HashMap에 저장
        Map<Integer, Integer> sumA = getSubarraySums(A);

        // B의 부분 배열을 탐색하며 가능한 경우의 수 찾기
        long count = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j]; // 부분 배열 B[i:j]의 합
                
                // (T - sum)이 sumA에 존재하는지 확인
                count += sumA.getOrDefault(T - sum, 0);
            }
        }
        
        // 정답 출력
        System.out.println(count);
    }

    // A의 모든 부분 배열 합을 HashMap에 저장
    private static Map<Integer, Integer> getSubarraySums(int[] arr) {
        Map<Integer, Integer> subarraySums = new HashMap<>();
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j]; // 부분 배열 arr[i:j]의 합
                
                // 해당 부분합이 등장한 횟수 증가
                subarraySums.put(sum, subarraySums.getOrDefault(sum, 0) + 1);
            }
        }
        
        return subarraySums;
    }
}