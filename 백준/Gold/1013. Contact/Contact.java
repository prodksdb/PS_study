import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        // 정규 표현식 패턴
        Pattern pattern = Pattern.compile("^(100+1+|01)+$");

        for (int i = 0; i < T; i++) {
            String signal = sc.nextLine();
            Matcher matcher = pattern.matcher(signal);

            if (matcher.matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}