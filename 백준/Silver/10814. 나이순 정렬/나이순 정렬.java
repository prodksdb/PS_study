import java.io.*;
import java.util.*;

public class Main {
    static class Member {
        int age;
        String name;

        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name));
        }

        list.sort(Comparator.comparingInt(m -> m.age));

        for(Member m : list){
            sb.append(m.age+" "+m.name+"\n");
        }
        System.out.println(sb);
    }
}