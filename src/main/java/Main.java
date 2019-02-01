import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class Main {

    static void createFileList() {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String a = null;
        try {
            a = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            for (File i : Files.walk(Paths.get(a))
                    .map(Path::toFile)
                    .collect(Collectors.toList())
                    ) {
                System.out.println(i.getName() + " , " + (i.isDirectory() ? "Directory" : "File") +
                        (i.canRead() && i.canWrite() ? ", RWX " : ", NOT RWX") + " , " + i.getAbsolutePath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        createFileList();
    }

}
