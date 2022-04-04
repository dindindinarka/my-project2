import java.io.*;


public class ReaderFile {

    public static StringBuffer readFile(File inputFile) throws IOException {
        StringBuffer s = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        int symbol;
        while (((symbol = br.read()) != -1)) {
            s.append((char) symbol);
        }
        br.close();
        return s;
    }

}

