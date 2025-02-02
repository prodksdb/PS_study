import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int S1 = Integer.parseInt(input[0]);
        int S2 = Integer.parseInt(input[1]);
        int S3 = Integer.parseInt(input[2]);

        int maxSum = S1 + S2 + S3; // 가능한 최대 합
        int[] count = new int[maxSum + 1]; // 합의 빈도를 저장할 배열

        // 모든 주사위 눈의 합 계산 및 빈도수 카운트
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    int sum = i + j + k;
                    count[sum]++; // 해당 합의 빈도를 증가
                }
            }
        }

        // 가장 높은 빈도를 찾고, 가장 작은 합을 출력하기 위해 탐색
        int maxCount = 0;
        int result = Integer.MAX_VALUE; // 가장 작은 합을 찾기 위해 초기값을 큰 값으로 설정

        for (int i = 3; i <= maxSum; i++) { // 가능한 최소 합은 3 (1+1+1)
            if (count[i] > maxCount) { 
                maxCount = count[i]; // 최댓값 갱신
                result = i; // 현재 합을 저장
            } else if (count[i] == maxCount) { 
                result = Math.min(result, i); // 동일한 빈도일 경우 더 작은 값 저장
            }
        }

        System.out.println(result);
    }
}
