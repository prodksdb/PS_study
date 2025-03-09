import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> [] tree;
    static boolean [] isDeleted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new ArrayList[N];
        isDeleted = new boolean[N];

        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i; // 루트 노드 저장
            } else {
                tree[parent].add(i); //부모-자식 관계 저장
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        delete(deleteNode);

        int leafCount = countLeafNodes(root);
        System.out.println(leafCount);
    }

    static void delete(int number) {
        isDeleted[number] = true;
    }

    static int countLeafNodes(int node) {
        if (isDeleted[node]) return 0; // 삭제된 노드는 무시

        boolean isLeaf = true;
        int count = 0;

        for (int child : tree[node]) {
            if (!isDeleted[child]) {
                isLeaf = false;
                count += countLeafNodes(child);
            }
        }

        return isLeaf ? 1 : count;
    }


}