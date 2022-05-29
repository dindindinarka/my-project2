package file;

import java.io.*;


public class ModifyFileText {

    public static void main(String[] args) {

        File inputFile = new File("src/test/resources/inputFile.txt");
        File outputFile = new File("src/test/resources/outputFile.txt");

        try {
            if (FileExists.checkExists(inputFile)) {
                StringBuffer s = ReaderFile.readFile(inputFile);
                String result = ModifyText.modifyText(s);
                WriterInFile.writerInFile(outputFile, result);
            }
        } catch (IOException e) {
            System.out.println("Исходный файл не найден " + e);
        }
    }
}

