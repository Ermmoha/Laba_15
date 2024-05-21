import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b((\\d\\d?|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d\\d?|1\\d\\d|2[0-4]\\d|25[0-5])\\b");

        try (FileWriter writer = new FileWriter("ipv4.txt")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                writer.write(matcher.group());
            }
            else {
                writer.write("ipv4 не обнаружено");
            }
        } catch (IOException e) {
            System.out.println("Ошибочка вышла");
        }
    }
}