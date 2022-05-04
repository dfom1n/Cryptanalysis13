package Cryptoanalizer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KeyCrypt {
    static final List<String> ARR_LOWER_LETTER = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я", ".", ",", "\"", ":", "-", "!", "?", " ");
    private int keyCrypt;
    private int numKey;

    public KeyCrypt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число которое будет ключем шифрования или расшифрования");
        if (scanner.hasNextInt()) {
            numKey = scanner.nextInt();
            setKeyCrypt(numKey);
        } else System.out.println("Введите корректный URL");
    }

    public Integer getKeyCrypt() {
        return keyCrypt;
    }

    private void setKeyCrypt(Integer numKey) {
        this.keyCrypt = numKey%ARR_LOWER_LETTER.size();
    }

}
