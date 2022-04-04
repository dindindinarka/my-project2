import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;


public class GenerateFile {
    public static void main(String[] args) throws IOException {
        int setSize = 1024*1024;
        File f = new File("src/test/resources/inputFile.txt");
        RandomAccessFile rf = new RandomAccessFile(f, "rw");
        Random random = new Random();
        FileWriter fw = new FileWriter(f);
        for (int i = 0; f.length() < setSize; i++) {
            var v = (char) ('a' + random.nextInt(26));
            fw.write(v);
            if (v == 'a') {
                fw.write(13);
            }
            if (v == 'p') {
                fw.write(32);
                fw.write(10);
                fw.write(32);
            }

        }
        fw.close();
        rf.setLength(setSize);
    }
}

