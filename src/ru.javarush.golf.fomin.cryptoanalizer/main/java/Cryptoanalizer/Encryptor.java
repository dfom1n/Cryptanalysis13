package Cryptoanalizer;

public class Encryptor {
    public static void encrypt() {
        KeyCrypt keyCryptEncryptor = new KeyCrypt();
        FilePath filePath = new FilePath();
        СodingFileImputStream.codingFileImputStream(filePath,"encrypt", keyCryptEncryptor.getKeyCrypt());
        System.out.println("Готово! Возвращайся если понадобится помощь в криптографии!");
    }
}
