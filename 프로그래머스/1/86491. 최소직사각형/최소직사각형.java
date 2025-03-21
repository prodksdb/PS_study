import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int n = sizes.length;
        int m = sizes[0].length;
        int [] width = new int[n];  // 가로
        int [] length = new int[n]; // 세로
        int max = Integer.MIN_VALUE;
        
        // 가로 배열에 가로 길이와 세로 길이를 비교해 더 긴 길이를 저장 
        for(int i = 0; i < n; i++){
            width[i]  = sizes[i][0];
            length[i] = sizes[i][1];
        }
        
        for(int i = 0; i < n; i++){
            if(width[i] < length[i]){
                int temp = width[i];
                width[i] = length[i];
                length[i] = temp;
            }
        }
        
        Arrays.sort(width);  //가로
        Arrays.sort(length); //세로
        
        // 가장 큰 가로의 길이와 가장 큰 세로의 길이 호출해서 지갑의 크기가 가장 작으면 return
        answer = width[n-1] * length[n-1];
        return answer;
    }
}