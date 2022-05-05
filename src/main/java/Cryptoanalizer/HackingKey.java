package Cryptoanalizer;

import java.io.*;
import java.util.*;

public class HackingKey {
    static final List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я", ".", ",", "\"", ":", "-", "!", "?", " ");
    static final List<String> ARR_STATISTIC = Arrays.asList(" ", "о", "а", "е", "и", "н", "т", "р", "с", "л", "в", "к", "п", "м", "у", "д", "я", "ы", "ь", "з", "б", "г", "й", "ч", "ю", "х", "ж", "ш", "ц", "щ", "ф", "э", "ъ", ".", ",", "\"", ":", "-", "!", "?");

    public static Integer hackingKey(FilePath filePath) throws IOException {
        Map<String, Integer> stringMap = new HashMap<>();
        List<Map.Entry<String, Integer>> valuesList = null;
        int keyCrypt = 0;
        String filePathInput = filePath.getFilePathInput();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("keyCrypt "+keyCrypt);
        System.out.println(456%ARR_LOWER_LETTER.size());
    return keyCrypt;
    }
}
