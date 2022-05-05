package Cryptoanalizer;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class СodingFileImputStream {
    static List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я", ".", ",", "\"", ":", "-", "!", "?", " ");

    public static void codingFileImputStream(FilePath filePath, String program, Integer keyCryptoanalizer) {

        String filePathInput = filePath.getFilePathInput();
        int keyCrypt = keyCryptoanalizer;
        String codingProgram = program;
        try (FileInputStream fileInputStream = new FileInputStream(filePathInput);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String strIn;
            while ((strIn = bufferedReader.readLine()) != null) {

                ConstructorArrayCharToString arrStrings = new ConstructorArrayCharToString(strIn);

                List<String> listIn = Arrays.asList(arrStrings.getArrStrings());
                List<String> listOut = new ArrayList<>(listIn.size());
                for (int i = 0; i < listIn.size(); i++) {
                    int number = ARR_LOWER_LETTER.indexOf(listIn.get(i));
                    int numberLetter;
                    if (ARR_LOWER_LETTER.contains(listIn.get(i)) && (codingProgram.equals("decoder")||codingProgram.equals("hacking"))) {
                        if ((number - keyCrypt) >= 0 && (number - keyCrypt) < ARR_LOWER_LETTER.size()) {
                            numberLetter = number - keyCrypt;
                        } else {
                            numberLetter = Math.abs(ARR_LOWER_LETTER.size() - Math.abs(keyCrypt - number));
                        }
                        String letter = ARR_LOWER_LETTER.get(numberLetter);
                        listOut.add(letter);
                    } else if (ARR_LOWER_LETTER.contains(listIn.get(i)) && codingProgram.equals("encrypt")) {
                        if ((number + keyCrypt) >= 0 && (number + keyCrypt) < (ARR_LOWER_LETTER.size())) {
                            numberLetter = number + keyCrypt;
                        } else {
                            numberLetter = Math.abs(ARR_LOWER_LETTER.size() - Math.abs(number + keyCrypt));
                        }
                        String letter = ARR_LOWER_LETTER.get(numberLetter);
                        listOut.add(letter);
                    } else {
                        System.out.println("Извените! В настоящее время я умею обрабатывать русские буквы и знаки припенанияю");
                        System.out.println("Привидите файл в соответствие и запустите программу заного! До встречи!");
                        break;
                    }
                }
                WritingToFile.writingToFile(filePath, listOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}