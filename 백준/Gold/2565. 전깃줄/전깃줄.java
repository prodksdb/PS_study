import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 전깃줄 개수 입력 받기
        int n = Integer.parseInt(br.readLine());

        List<int[]> wires = new ArrayList<>();

        // 2. 전깃줄 정보 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            wires.add(new int[]{A, B});
        }

        // 3. A 기준 정렬
        wires.sort(Comparator.comparingInt(o -> o[0])); // A 전봇대 값 기준 정렬

        // 4. A 기준 정렬된 후 B 값만 리스트에 저장
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = wires.get(i)[1];
        }

        // 5. LIS 길이 구하기
        int length = findLISLength(B);
        System.out.println(n - length); // 제거해야 하는 전깃줄 개수
    }

    // 이진 탐색을 이용한 LIS 길이 계산 (O(N log N))
    private static int findLISLength(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1); // Lower Bound 찾기
            if (pos == lis.size()) lis.add(num); // 새로운 값 추가
            else lis.set(pos, num); // LIS 업데이트
        }
        return lis.size();
    }
}