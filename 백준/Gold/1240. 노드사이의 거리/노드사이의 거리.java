import java.io.*;
import java.sql.Array;
import java.util.*;

// 연결된 노드 번호와 가중치를 저장
class Edge{
    int link;  // 연결된 노드 번호
    int weight; // 간선의 가중치

    public Edge(int link, int weight){
        this.link = link;
        this.weight = weight;
    }
}

public class Main {
    static List<Edge> [] tree; // tree 배열은 ArrayList<Edge>를 저장

    //그래프에 간선을 추가하는 메서드(무방향이므로 양쪽에 추가)
    public static void addEdge(int u, int v, int w){
        tree[u].add(new Edge(v, w));
        tree[v].add(new Edge(u, w));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input = br.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        tree = new ArrayList[N+1];
        for(int i = 1; i <=N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            addEdge(u,v,w);
        }


        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean [] visited = new boolean[N+1];
            int distance = dfs(start, end, 0, visited);
            System.out.println(distance);
        }
    }

    public static int dfs(int current, int destination, int dist, boolean [] visited ){
        if( current == destination ){
            return dist;
        }
        visited[current] = true;
        for(Edge edge : tree[current]){
            if(!visited[edge.link]){
                int result = dfs(edge.link, destination, dist+edge.weight, visited);
                if(result != -1){ // 목적지를 찾은 경우
                    return result;
                }
            }
        }
        return -1; // 트리이므로 도달 불가능한 경우 발생하지 앟ㄴ는다.
    }
}