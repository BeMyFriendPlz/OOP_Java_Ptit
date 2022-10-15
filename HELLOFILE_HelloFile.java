import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HELLOFILE_HelloFile {
    public static void main(String[] args) {
        Path p = Paths.get("Hello.txt");
        try {
            List<String> list = Files.readAllLines(p);
            for (String temp : list) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
