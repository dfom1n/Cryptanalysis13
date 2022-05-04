package Cryptoanalizer;

import java.io.*;
import java.util.*;

public class Encryptor {
//    static final int KEY_CRYPT = 8;
    static final List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я", ".", ",", "\"", ":", "-", "!", "?", " ");
//    static final List<String> ARR_UPPER_LETTER = Arrays.asList("А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ь", "Ы", "Ъ", "Э", "Ю", "Я");
//    static final List<String> ARR_SYMBOL = Arrays.asList(".", ",", "\"", ":", "-", "!", "?", " ");


    public static void encrypt() throws IOException {
        KeyCrypt keyCryptEncryptor = new KeyCrypt();
        FilePath filePath = new FilePath();
        String filePathInput = filePath.getFilePathInput();
        String filePathOutput = filePath.getFilePathOutput();
        try (FileInputStream fileInputStream = new FileInputStream(filePathInput);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String strIn;
            while ((strIn = bufferedReader.readLine()) != null) {
                char[] chars = strIn.toLowerCase().toCharArray();
                String[] strings = new String[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    strings[i] = String.valueOf(chars[i]);
                }
                List<String> listIn = Arrays.asList(strings);
                List<String> listOut = new ArrayList<>(listIn.size());
                for (int i = 0; i < listIn.size(); i++) {
                    if (ARR_LOWER_LETTER.contains(listIn.get(i))) {
                        int number = ARR_LOWER_LETTER.indexOf(listIn.get(i));
                        int numberLetter;
                        if ((number + keyCryptEncryptor.getKeyCrypt()) >= 0 && (number + keyCryptEncryptor.getKeyCrypt()) < (ARR_LOWER_LETTER.size())) {
                            numberLetter = number + keyCryptEncryptor.getKeyCrypt();
                        } else {
                            numberLetter = Math.abs(ARR_LOWER_LETTER.size() - Math.abs(number + keyCryptEncryptor.getKeyCrypt()));
                        }
                        String letter = ARR_LOWER_LETTER.get(numberLetter);
                        listOut.add(letter);
                    }
//                    else if (ARR_UPPER_LETTER.contains(listIn.get(i))) {
//                        int number = ARR_UPPER_LETTER.indexOf(listIn.get(i));
//                        int numberLetter;
//                        if ((number + KEY_CRYPT) >= 0 && (number + KEY_CRYPT) < ARR_UPPER_LETTER.size()) {
//                            numberLetter = number + KEY_CRYPT;
//                        } else {
//                            numberLetter = Math.abs(ARR_UPPER_LETTER.size() - (number + KEY_CRYPT));
//                        }
//                        String letter = ARR_UPPER_LETTER.get(numberLetter);
//                        listOut.add(letter);
//                    } else if (ARR_SYMBOL.contains(listIn.get(i))) {
//                        int number = ARR_SYMBOL.indexOf(listIn.get(i));
//                        int numberLetter;
//                        if ((number + KEY_CRYPT) >= 0 && (number + KEY_CRYPT) < ARR_SYMBOL.size()) {
//                            numberLetter = number + KEY_CRYPT;
//                        } else {
//                            numberLetter = Math.abs(ARR_SYMBOL.size() - (number + KEY_CRYPT));
//                        }
//                        String letter = ARR_SYMBOL.get(numberLetter);
//                        listOut.add(letter);
//                    }
                    else {
                        System.out.println("Извените! В настоящее время я умею обрабатывать русские буквы и знаки припенанияю");
                        System.out.println("Привидите файл в соответствие и запустите программу заного! До встречи!");
                        break;
                    }
                }
                try (FileOutputStream fileOutputStream = new FileOutputStream(filePathOutput, true);
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))) {
                    for (String s : listOut) {
                        bufferedWriter.write(s);
                    }
                    bufferedWriter.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Готово! Возвращайся если понадобится помощь в криптографии!");
    }
}
