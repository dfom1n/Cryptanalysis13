package Cryptoanalizer;

import java.io.*;
import java.util.*;

public class Hacking {
    static final List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я");
    static final List<String> ARR_UPPER_LETTER = Arrays.asList("А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ь", "Ы", "Ъ", "Э", "Ю", "Я");
    static final List<String> ARR_SYMBOL = Arrays.asList(".", ",", "\"", ":", "-", "!", "?", " ");
    static final List<String> ARR_STATISTIC = Arrays.asList("о", "а", "е", "и", "н", "т", "р", "с", "л", "в", "к", "п", "м", "у", "д", "я", "ы", "ь", "з", "б", "г", "й", "ч", "ю", "х", "ж", "ш", "ц", "щ", "ф", "э", "ъ");

    public static void hacking() throws IOException {
        Map<String, Integer> stringMap = new HashMap<>();
        List<Map.Entry<String, Integer>> valuesList = null;
        int keyCrypt=0;
        FilePath filePath = new FilePath();
        String filePathInput = filePath.getFilePathInput();
        String filePathOutput = filePath.getFilePathOutput();

        try (FileInputStream fileInputStream = new FileInputStream(filePathInput);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String strIn;
            while ((strIn = bufferedReader.readLine()) != null) {
                char[] chars = strIn.toCharArray();
                String[] strings = new String[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    strings[i] = String.valueOf(chars[i]);
                }
                for (String string : strings) {
                    if (stringMap.containsKey(string)) {
                        stringMap.put(string, stringMap.get(string) + 1);
                    } else if (!(string.equals(" ") || string.equals(".") || string.equals(",") || string.equals("\"") || string.equals(":") || string.equals("-") || string.equals("!") || string.equals("?"))) {
                        stringMap.put(string, 1);
                    }
                }
                valuesList = new ArrayList(stringMap.entrySet());
                Collections.sort(valuesList, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });
                String letterTopInText = valuesList.get(valuesList.size() - 1).getKey();
                int indexLetterTopInTextInArr = 0;
                int indexLetterTopRussian = 0;
                if (ARR_LOWER_LETTER.contains(letterTopInText)) {
                    indexLetterTopInTextInArr = ARR_LOWER_LETTER.indexOf(letterTopInText);
                    indexLetterTopRussian = ARR_LOWER_LETTER.indexOf(ARR_STATISTIC.get(0));
                } else if (ARR_UPPER_LETTER.contains(letterTopInText)) {
                    indexLetterTopInTextInArr = ARR_UPPER_LETTER.indexOf(letterTopInText);
                    indexLetterTopRussian = ARR_UPPER_LETTER.indexOf(ARR_STATISTIC.get(0).toUpperCase());
                }
                keyCrypt = Math.abs(indexLetterTopRussian - indexLetterTopInTextInArr);
            }
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePathInput);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String strIn;
            while ((strIn = bufferedReader.readLine()) != null) {
                char[] chars = strIn.toCharArray();
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
                        if ((number - keyCrypt) >= 0 && (number - keyCrypt) < ARR_LOWER_LETTER.size()) {
                            numberLetter = number - keyCrypt;
                        } else {
                            numberLetter = Math.abs(ARR_LOWER_LETTER.size() - Math.abs(number - keyCrypt));
                        }
                        String letter = ARR_LOWER_LETTER.get(numberLetter);
                        listOut.add(letter);
                    } else if (ARR_UPPER_LETTER.contains(listIn.get(i))) {
                        int number = ARR_UPPER_LETTER.indexOf(listIn.get(i));
                        int numberLetter;
                        if ((number - keyCrypt) >= 0 && (number - keyCrypt) < ARR_UPPER_LETTER.size()) {
                            numberLetter = number - keyCrypt;
                        } else {
                            numberLetter = Math.abs(ARR_UPPER_LETTER.size() - Math.abs(number - keyCrypt));
                        }
                        String letter = ARR_UPPER_LETTER.get(numberLetter);
                        listOut.add(letter);
                    } else if (ARR_SYMBOL.contains(listIn.get(i))) {
                        int number = ARR_SYMBOL.indexOf(listIn.get(i));
                        int numberLetter;
                        if ((number - keyCrypt) >= 0 && (number - keyCrypt) < ARR_SYMBOL.size()) {
                            numberLetter = number - keyCrypt;
                        } else {
                            numberLetter = Math.abs(ARR_SYMBOL.size() - Math.abs(number - keyCrypt));
                        }
                        String letter = ARR_SYMBOL.get(numberLetter);
                        listOut.add(letter);
                    } else {
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
