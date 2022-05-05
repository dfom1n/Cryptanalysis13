package Cryptoanalizer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class WritingToFile {
    public static void writingToFile(FilePath filePath, List<String> listOut) {

        String filePathOutput = filePath.getFilePathOutput();
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePathOutput, true);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))) {
            for (String s : listOut) {
                bufferedWriter.write(s);
            }
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Готово! Возвращайся если понадобится помощь в криптографии!");
    }
}
