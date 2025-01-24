import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> valueMap = new HashMap<>();
        Map<String, Integer> multiplierMap = new HashMap<>();

        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        for (int i = 0; i < colors.length; i++) {
            valueMap.put(colors[i], i);
            multiplierMap.put(colors[i], (int) Math.pow(10, i));
        }

        String color1 = scanner.nextLine();
        String color2 = scanner.nextLine();
        String color3 = scanner.nextLine();

        long resistance = (valueMap.get(color1) * 10L + valueMap.get(color2)) * multiplierMap.get(color3);

        System.out.println(resistance);
    }
}
