import java.util.*;

class Solution {
    
    class Pair{
        int w;
        int l;
        public Pair(int w, int l){
            this.w = w;
            this.l = l;
        }
    }
    
    public int[] solution(int brown, int yellow) {
        int [] answer = new int[2];
        int carpet = brown+yellow;
        // width(가로의 길이) >= length(세로의 길이)
        
        //쌍 찾기 
        int n = carpet / 2;
        List<Pair> cases = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(carpet % i == 0){
                // width(가로의 길이) >= length(세로의 길이)
                int w = Math.max(carpet / i, i);
                int l = Math.min(carpet / i, i);
                cases.add(new Pair(w, l));
            }
        }
        
        // 쌍 중에서 밖의 1줄 갈색 격자 제외하고 가운데 노란색 격자의 크기와 일치하는지 확인 
         for (Pair p : cases) {
            int k = p.w; // 가로 길이 
            int m = p.l; // 세로 길이 
            if (yellow == (k - 2) * (m - 2)) {
                answer[0] = k;
                answer[1] = m;
                break;
            }
        }
        return answer;
        
    }
}