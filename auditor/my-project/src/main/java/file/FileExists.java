package file;

import java.io.File;


public class FileExists {

    public static boolean checkExists(File file) {
        return (file.exists()) && !file.isDirectory();
    }
}

