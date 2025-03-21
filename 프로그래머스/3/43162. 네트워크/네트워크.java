import java.util.*;

class Solution {
     
    static class connectNode{
        int node1; 
        int node2;
        public connectNode(int node1, int node2){
            this.node1 = node1;
            this.node2 = node2;
        }
    }
    
    
    static List<connectNode> connect = new ArrayList<>();
    static boolean [] visited;
    static int count = 0;  // count = 중복되지 않은 네트워크의 개수 

    
    public int solution(int n, int[][] computers) {
        boolean [] visited = new boolean[n]; //각 컴퓨터의 방문 여부
        int network = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers, visited, n);
                network++;
            }
            
        }
        return network;
    }
    
    // 
    static void dfs(int node, int [][]computers, boolean [] visited, int n) {
        visited[node] = true;
        // 모든 노드 탐색해보기 
        for(int i = 0; i < n; i++){
            if(computers[node][i] == 1 & !visited[i]){
                dfs(i, computers, visited, n);
            }
        }
    }
}