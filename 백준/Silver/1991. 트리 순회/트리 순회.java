import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;
    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node [] tree;

    //전위 순회
    public static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    //중위 순회
    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    //후위 순회
    public static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new Node[N+1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if(tree[parentValue-'A'] == null){  //부모 노드가 아직 생성되지 않은 경우
                tree[parentValue - 'A'] = new Node(parentValue); //부모 노드를 생성
            }
            if(leftValue != '.'){  // 왼쪽 노드가 있을 경우
                tree[leftValue-'A'] = new Node(leftValue);    // 왼쪽 자식 노드 생성
                tree[parentValue-'A'].left = tree[leftValue-'A']; // 부모 노드와 연결
            }
            if(rightValue != '.'){ // 오른쪽 노드가 있을 경우
                tree[rightValue-'A'] = new Node(rightValue);  // 오른쪽 자식 노드 생성
                tree[parentValue-'A'].right = tree[rightValue-'A']; // 부모 노드와 연결
            }
        }

        //전위 순회
        preorder(tree[0]);
        System.out.println();

        //중위 순회
        inorder(tree[0]);
        System.out.println();

        //후위 순회
        postorder(tree[0]);
        System.out.println();
    }
}