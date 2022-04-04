import java.io.*;
import java.util.Scanner;


public class WriterInFile {

    public static void writerInFile(File outputFile, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(text);
        writer.close();
    }
}

