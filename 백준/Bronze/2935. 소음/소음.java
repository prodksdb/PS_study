import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String op = br.readLine();
        String B = br.readLine();
        long countA = 0, countB = 0, count = 0;

        for(int i = 1; i < A.length(); i++){
            countA++;
        }

        for(int i = 1; i < B.length(); i++){
            countB++;
        }

        if(op.equals("*")){
            sb.append("1");
            for(int i = 1; i <=countA+countB;i++){
                sb.append("0");
            }
        }else{
            if(A.length()>B.length()){
                sb.append("1");
                for(int i = 1; i < A.length()-B.length(); i++){
                    sb.append("0");
                }
                sb.append(B);
            }
            else if(A.length() == B.length()){
                sb.append("2");
                for(int i = 1; i < A.length();i++) {
                    sb.append("0");
                }
            }
            else{
                sb.append("1");
                for(int i = 1; i < B.length()-A.length(); i++){
                    sb.append("0");
                }
                sb.append(A);
            }

        }

        System.out.println(sb);

        }
    }