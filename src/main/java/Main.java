import java.io.*;
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
        BufferedWriter writer = null;
        try {
             writer = new BufferedWriter(new FileWriter("1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int j = 0;
        try {
            for (File i : Files.walk(Paths.get(a))
                    .map(Path::toFile)
                    .collect(Collectors.toList())
                    ) {
                writer.write(i.getName() + " , " + (i.isDirectory() ? "Directory" : "File") +
                        (i.canRead() && i.canWrite() ? ", RWX " : ", NOT RWX") + " , " + i.getAbsolutePath() + "\n");
                j++;
                if ( j % 5 == 0) {
                    writer.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        createFileList();
    }

}
