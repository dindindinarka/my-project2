package File;

import java.io.File;
import java.io.IOException;


public class FileExists {

    public static boolean checkExists(File file) {
        return (file.exists()) && !file.isDirectory();
    }
}

