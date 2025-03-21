import java.util.*;

class Solution {
    
    static String [] ws;
    static String t;
    static int l;
    static int w;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        w = target.length();
        l = words.length;
        t = target;
        ws = words;
       
        return bfs(begin);
    }
    
    public static int bfs(String begin){
        
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(begin);
        visited.add(begin);
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                String current = queue.poll();      
            
                // 현재 단어가 target과 일치할 경우 탈출!
                if( current.equals(t)){
                    return level;
                }
                
                // words에서 전체 word 탐색 
                for(int i = 0; i < l; i++){
                    int count = 0;
                    // word의 각 자리의 문자가 현재 word의 문자와 몇 개 일치하는지 확인(count 변수)
                    // 이 word를 이미 방문하지 않았는지? 
                    if(!visited.contains(ws[i])){
                        for(int j = 0; j < w; j++){
                            if(ws[i].charAt(j) == current.charAt(j)){
                                count++;
                            }
                        }
                    }
    
                    // 현재 단어와 ws[i]의 단어가 1개만 일치하지 않을 경우 
                    // ws[i]를 queue에 추가 
                    // 한 단계의 과정을 거치므로 level + 1
                    if(count == w-1){
                        queue.offer(ws[i]);
                        visited.add(ws[i]);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}