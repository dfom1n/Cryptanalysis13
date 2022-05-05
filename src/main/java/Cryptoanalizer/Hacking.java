package Cryptoanalizer;

import java.io.*;
import java.util.*;

public class Hacking {
    static final List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я", ".", ",", "\"", ":", "-", "!", "?", " ");
    static final List<String> ARR_STATISTIC = Arrays.asList(" ", "о", "а", "е", "и", "н", "т", "р", "с", "л", "в", "к", "п", "м", "у", "д", "я", "ы", "ь", "з", "б", "г", "й", "ч", "ю", "х", "ж", "ш", "ц", "щ", "ф", "э", "ъ", ".", ",", "\"", ":", "-", "!", "?");

    public static void hacking() throws IOException {
        Map<String, Integer> stringMap = new HashMap<>();
        List<Map.Entry<String, Integer>> valuesList = null;
        Map<String, Integer> stringMapCheck = new HashMap<>();
        List<Map.Entry<String, Integer>> valuesListCheck = null;
        String letterTopInTextCheck = null;
        int keyCrypt = 0;
        FilePath filePath = new FilePath();
        String filePathInput = filePath.getFilePathInput();
        String filePathOutput = filePath.getFilePathOutput();

        try (FileInputStream fileInputStream = new FileInputStream(filePathInput);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String strIn;
            while ((strIn = bufferedReader.readLine()) != null) {

                ConstructorArrayCharToString arrStrings = new ConstructorArrayCharToString(strIn);


                for (String string : arrStrings.getArrStrings()) {
                    if (stringMap.containsKey(string)) {
                        stringMap.put(string, stringMap.get(string) + 1);
                    } else {
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
                }
                keyCrypt = Math.abs(ARR_LOWER_LETTER.size()) - Math.abs(indexLetterTopInTextInArr - indexLetterTopRussian);
            }
        }

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
//                        if ((number - keyCrypt) >= 0 && (number - keyCrypt) < ARR_LOWER_LETTER.size()) {
//                            numberLetter = number - keyCrypt;
//                        } else {
//                            numberLetter = Math.abs(ARR_LOWER_LETTER.size() - Math.abs(keyCrypt - number));
//                        }
//                        String letter = ARR_LOWER_LETTER.get(numberLetter);
//                        listOut.add(letter);
//                    } else {
//                        System.out.println("Извените! В настоящее время я умею обрабатывать русские буквы и знаки припенанияю");
//                        System.out.println("Привидите файл в соответствие и запустите программу заного! До встречи!");
//                        break;
//                    }
//                }
//                WritingToFile.writingToFile(filePath, listOut);
        СodingFileImputStream.codingFileImputStream(filePath,"hacking", keyCrypt);


        try (FileInputStream fileOutputStream = new FileInputStream(filePathOutput);
                     BufferedReader bufferedReaderCheck = new BufferedReader(new InputStreamReader(fileOutputStream))) {
                    String strCheck;
                    while ((strCheck = bufferedReaderCheck.readLine()) != null) {

                        ConstructorArrayCharToString arrStringsChek = new ConstructorArrayCharToString(strCheck);

                        for (String string : arrStringsChek.getArrStrings()) {
                            if (stringMapCheck.containsKey(string)) {
                                stringMapCheck.put(string, stringMapCheck.get(string) + 1);
                            } else {
                                stringMapCheck.put(string, 1);
                            }
                        }
                        valuesListCheck = new ArrayList(stringMapCheck.entrySet());
                        Collections.sort(valuesListCheck, new Comparator<Map.Entry<String, Integer>>() {
                            @Override
                            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                return o1.getValue().compareTo(o2.getValue());
                            }
                        });
                        letterTopInTextCheck = valuesListCheck.get(valuesListCheck.size() - 1).getKey();
                    }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (letterTopInTextCheck.equals(ARR_STATISTIC.get(0))) {
            System.out.println("Я взломал текст, результат смотри в файле который ты указал");
            System.out.println("Готово! Возвращайся если понадобится помощь в криптографии!");
        } else {
            System.out.println("Что-то пошло не так и у меня не получилось взломать файл");
            System.out.println("letterTopInTextCheck " + letterTopInTextCheck);
            System.out.println("ARR_STATISTIC.get(0) " + ARR_STATISTIC.get(0));
        }

    }
}
