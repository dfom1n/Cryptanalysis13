package Cryptoanalizer;

import java.io.*;
import java.util.*;

public class Encryptor {
    static final List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я", ".", ",", "\"", ":", "-", "!", "?", " ");

    public static void encrypt() throws IOException {
        KeyCrypt keyCryptEncryptor = new KeyCrypt();
        FilePath filePath = new FilePath();
        СodingFileImputStream.codingFileImputStream(filePath,"encrypt", keyCryptEncryptor.getKeyCrypt());
//        String filePathInput = filePath.getFilePathInput();
//        try (FileInputStream fileInputStream = new FileInputStream(filePathInput);
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
//            String strIn;
//            while ((strIn = bufferedReader.readLine()) != null) {
//
//                ConstructorArrayCharToString arrStrings = new ConstructorArrayCharToString(strIn);
//
//                List<String> listIn = Arrays.asList(arrStrings.getArrStrings());
//                List<String> listOut = new ArrayList<>(listIn.size());
//                for (int i = 0; i < listIn.size(); i++) {
//                    if (ARR_LOWER_LETTER.contains(listIn.get(i))) {
//                        int number = ARR_LOWER_LETTER.indexOf(listIn.get(i));
//                        int numberLetter;
//                        if ((number + keyCryptEncryptor.getKeyCrypt()) >= 0 && (number + keyCryptEncryptor.getKeyCrypt()) < (ARR_LOWER_LETTER.size())) {
//                            numberLetter = number + keyCryptEncryptor.getKeyCrypt();
//                        } else {
//                            numberLetter = Math.abs(ARR_LOWER_LETTER.size() - Math.abs(number + keyCryptEncryptor.getKeyCrypt()));
//                        }
//                        String letter = ARR_LOWER_LETTER.get(numberLetter);
//                        listOut.add(letter);
//                    }
//                    else {
//                        System.out.println("Извените! В настоящее время я умею обрабатывать русские буквы и знаки припенанияю");
//                        System.out.println("Привидите файл в соответствие и запустите программу заного! До встречи!");
//                        break;
//                    }
//                }
//                WritingToFile.writingToFile(filePath, listOut);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Готово! Возвращайся если понадобится помощь в криптографии!");
    }
}
