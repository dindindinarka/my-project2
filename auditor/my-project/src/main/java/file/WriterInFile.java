package file;

import java.io.*;


public class WriterInFile {

    public static void writerInFile(File outputFile, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(text);
        writer.close();
    }
}

