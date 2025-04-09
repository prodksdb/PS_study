import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [] numbers;
    static int [] results;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        results = new int[M];
        visited = new boolean[N];
        Permutation(0);

        System.out.println(sb);
    }

    public static void Permutation(int count){
        if(count == M){
            for(int i = 0; i < M; i++ ){
                sb.append(results[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                results[count] = numbers[i];
                Permutation(count + 1);
                visited[i] = false;
            }
        }
    }
}