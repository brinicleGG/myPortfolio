import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Введите путь до папки: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();

        try {
            System.out.print("Сумма размеров всех файлов: ");
            Files.walk(Paths.get(path)).map(p -> p.toFile()).filter(f -> f.isFile()).
                    map(f -> f.length()).reduce((l1, l2) -> l1 + l2).ifPresent(System.out::print);
            System.out.print(" байт");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
