import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ModifyText {

    public static String modifyText(StringBuffer s) throws IOException {
        Scanner scan = new Scanner(s.toString());
        String result = "";
        while (scan.hasNext()) {
            result += scan.next() + " ";
        }
        return result;
    }
}

