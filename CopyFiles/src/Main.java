import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Папка которую нужно скопировать: ");
        Scanner scanner1 = new Scanner(System.in);
        String pathFromString = scanner1.nextLine().trim();

        System.out.println("Папка в которую нужно скопировать: ");
        Scanner scanner2 = new Scanner(System.in);
        String pathToString = scanner2.nextLine().trim();

        Path pathFrom = Paths.get(pathFromString);
        Path pathTo = Paths.get(pathToString);


        Files.walk(pathFrom).forEach(path -> {
            try {
                Files.copy(path, pathTo.resolve(pathFrom.subpath(pathFrom.getNameCount() - 1, pathFrom.getNameCount()))
                        .resolve(pathFrom.relativize(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
