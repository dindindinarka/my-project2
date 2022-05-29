package file;

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

