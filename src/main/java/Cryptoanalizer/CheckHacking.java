package Cryptoanalizer;

import java.io.*;
import java.util.*;

public class CheckHacking {
    static final List<String> ARR_STATISTIC = Arrays.asList(" ", "о", "а", "е", "и", "н", "т", "р", "с", "л", "в", "к", "п", "м", "у", "д", "я", "ы", "ь", "з", "б", "г", "й", "ч", "ю", "х", "ж", "ш", "ц", "щ", "ф", "э", "ъ", ".", ",", "\"", ":", "-", "!", "?");

    public static void checkHacking(FilePath filePath) throws IOException {
        Map<String, Integer> stringMapCheck = new HashMap<>();
        List<Map.Entry<String, Integer>> valuesListCheck = null;
        String letterTopInTextCheck = null;
        String filePathOutput = filePath.getFilePathOutput();
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
        }
    }
}
