import java.io.*;
import java.util.*;

public class Solution {

/** * 1. 입력 받기(고객 정보 별도 저장, 시작 위치와 도착 위치 저장)
    * 2. 고객 방문 순서 순열 만들기 -> 회사에서 시작, 집 도착
    * 3. 방문 순서 완성 -> 순서에 따라서 거리 계산 ( 재귀 파라미터 누적 )
    * 4. 최단 이동거리 갱신
    * 5. 출력                                                    **/

    static class Customer {
        int x;
        int y;
        public Customer(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, min;
    static Customer [] customers; // 고객들 배열
    static Customer start;        // 시작 위치(회사)
    static Customer end;          // 도착 위치(집)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            min = Integer.MAX_VALUE;

            // 고객의 수 N명
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            customers = new Customer[N];

            // 회사의 좌표
            start = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 집의 좌표
            end = new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            // N명의 고객의 좌표
            for(int i = 0; i < N; i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                customers[i] = new Customer(x, y);
            }

            Permutation(new boolean[N], 0, 0, start);
            sb.append("#"+test_case+" "+min+"\n");
        }
        System.out.println(sb);
    }

    /*
     * N명의 고객 방문 순서 순열 만들기
     * @param selected : 순열 선택 여부 저장 배열
     * @param depth : 선택한 고객의 수
     * @param distance: 누적 방문 거리
     * @param cur : 현재 고객 정보
     */

    private static void Permutation(boolean[] selected, int depth, int distance, Customer cur){
        // 순열이 완료될 때마다 최소거리 갱신
        if(depth == N){
            // 마지막 손님~집까지의 거리 추가
            distance += getDistance(cur, end);
            min = Math.min(min, distance); // 최저값 계산
            return;
        }

        for(int i = 0; i < selected.length; i++){
            if(selected[i])
                continue;
            selected[i] = true;
            Permutation(selected, depth+1, distance + getDistance(cur, customers[i]), customers[i]);
            selected[i] = false;
        }
    }

    private static int getDistance(Customer c1, Customer c2){
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y- c2.y);
    }
}
